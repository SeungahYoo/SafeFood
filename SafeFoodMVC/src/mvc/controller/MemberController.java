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
    
    public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//ȸ�� ����
        // �߰��� ȸ�� ���� ����
    	String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String [] allergies = request.getParameterValues("allergies");
        // service�� ���� ���� ����
        memberService.insert(id, name, address, tel, password, allergies);
        // request�� ��ǰ ��� ����
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
     
    public void memberSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//ȸ�� ��ȸ
    	// ��ȸ�� ȸ�� ���̵� ����
        String id = request.getParameter("id");
        // serivce�� ���� ȸ�� ��ȸ
        memberService.selectOne(id);
        // request�� ��ǰ ��� ����
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void memberModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//ȸ�� ����
    	// ������ ȸ�� ���� ����
        String id = (String)request.getSession(false).getAttribute("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String [] allergies = request.getParameterValues("allergies");
        System.out.println(id + " / " + name + " / " + address + " / " + tel + " / " + password);
        // service�� ���� ȸ�� ����
        memberService.modify(id, name, address, tel, password, allergies);
        // ������ ȸ�� ���� ��ȸ
        Member m = memberService.selectOne(id);
        System.out.println("���� �� : " + m);
        // session ���� ����
        HttpSession session = request.getSession(false);
        session.setAttribute("id", id);
        session.setAttribute("m", m);
        request.setAttribute("m", m);
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void memberWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//ȸ�� Ż��
    	// Ż���� ȸ�� ���̵� ����
        String id = request.getParameter("id");
        // service�� ���� ȸ�� ����
        memberService.delete(id);
        // session ���� ����
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
        // ��ǰ ���� ����
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }
    
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// �α����� ȸ�� ���� ����
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        // ���񽺸� ���� ȸ�� ���� ��ȸ
        Member check = memberService.selectOne(id);
        // �����ϴ� ȸ���̰� ��й�ȣ�� ��ġ�� ���
        if(check != null && pass.equals(check.getPassword())) {
        	// session�� ���� ����
            HttpSession session = request.getSession(false);
            session.setAttribute("id", id);
            session.setAttribute("m", check);
            request.setAttribute("mainList", foodService.searchAll());
            response.getWriter().println("1");
        }
        // �������� �ʴ� ȸ���̰� ��й�ȣ�� ��ġ���� ���� ���
        else {
            String message = "���̵� �Ǵ� �н����尡 �ٸ��ϴ�.";
            request.setAttribute("str", message);
            request.setAttribute("mainList", foodService.searchAll());
            response.getWriter().println("-1");
        }
    }
    
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	// session ���� ����
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
        // ��ǰ ���� ����
        request.setAttribute("mainList", foodService.searchAll());
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("main/index.jsp");
        rd.forward(request, response);
    }

    public void addFood(HttpServletRequest request, HttpServletResponse response) {
    	// �߰��� ��ǰ �ڵ� ����
        String code = (String)request.getParameter("code"); 
        // ����� ������ ���ǿ� ������ ���
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        if (id != null) {
        	// service�� ���� ��ǰ ���� �ڵ� �߰�
            memberService.addFood(id, code); 
            try {
                response.getWriter().println("1");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // ����� ������ ���ǿ� �������� ���� ���
        else
            try {
                response.getWriter().println("2");
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

	
}