package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.service.FoodService;
import mvc.service.FoodServiceImpl;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;
import mvc.vo.Member;

public class MemberController {
    private MemberService memberService;
    private FoodService foodService;

    public MemberController() {
        memberService = MemberServiceImpl.getInstance(); // singleton
        foodService = FoodServiceImpl.getInstance(); // singleton
    }
    
    public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//회원 가입
        // 추가할 회원 정보 추출
    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String [] allergies = request.getParameterValues("allergies");
        // service를 통한 삽입 수행
        memberService.insert(id, name, address, tel, password, allergies);
        // request에 식품 목록 세팅
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
     
    public void memberSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//회원 조회
    	// 조회할 회원 아이디 추추
        String id = request.getParameter("id");
        // serivce를 통한 회원 조회
        memberService.selectOne(id);
        // request에 식품 목록 세팅
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void memberModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//회원 수정
    	// 수정할 회원 정보 추출
        String id = (String)request.getSession(false).getAttribute("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String [] allergies = request.getParameterValues("allergies");
        System.out.println(id + " / " + name + " / " + address + " / " + tel + " / " + password);
        // service를 통한 회원 수정
        memberService.modify(id, name, address, tel, password, allergies);
        // 수정된 회원 정보 조회
        Member m = memberService.selectOne(id);
        System.out.println("수정 후 : " + m);
        // session 정보 갱신
        HttpSession session = request.getSession(false);
        session.setAttribute("id", id);
        session.setAttribute("m", m);
        request.setAttribute("m", m);
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void memberWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//회원 탈퇴
    	// 탈퇴할 회원 아이디 추출
        String id = request.getParameter("id");
        // service를 통한 회원 삭제
        memberService.delete(id);
        // session 정보 삭제
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
        // 식품 정보 추출
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 로그인할 회원 정보 추출
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        // 서비스를 통한 회원 정보 조회
        Member check = memberService.selectOne(id);
        // 존재하는 회원이고 비밀번호가 일치할 경우
        if(check != null && pass.equals(check.getPassword())) {
        	// session에 정보 세팅
            HttpSession session = request.getSession(false);
            session.setAttribute("id", id);
            session.setAttribute("m", check);
            request.setAttribute("mainList", foodService.searchAll());
            response.getWriter().println("1");
        }
        // 존재하지 않는 회원이고 비밀번호가 일치하지 않을 경우
        else {
            String message = "아이디 또는 패스워드가 다릅니다.";
            request.setAttribute("str", message);
            request.setAttribute("mainList", foodService.searchAll());
            response.getWriter().println("-1");
        }
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	// session 정보 삭제
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
        // 식품 정보 세팅
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }

    public void addFood(HttpServletRequest request, HttpServletResponse response) {
    	// 추가할 식품 코드 추출
        String code = (String)request.getParameter("code"); 
        // 사용자 정보가 세션에 존재할 경우
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        if (id != null) {
        	// service를 통한 식품 섭취 코드 추가
            memberService.addFood(id, code); 
            try {
                response.getWriter().println("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 사용자 정보가 세션에 존재하지 않을 경우
        else
            try {
                response.getWriter().println("2");
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

	
}