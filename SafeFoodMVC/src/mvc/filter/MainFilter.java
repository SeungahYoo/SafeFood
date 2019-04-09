package mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.MainController;
import mvc.controller.MemberController;
/*
 * Front Controller : 클라이언트로부터 들어오는 모든 요청을 받음
 * 받은 요청 처리를 위해 Controller(MemberController)에게 작업을 넘김
 * */
// @WebFilter("/MemberFilter")
@WebFilter("*.mvc") // ~.mvc로 들어오는 모든 요청을 받겠다. ex) http://localhost:8080/MVC/list.mvc
public class MainFilter implements Filter {
	
	private MemberController memberController;
	private MainController mainController;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. request, response를 Http로 바꾼다.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		// 2. charset을 지정한다.
		req.setCharacterEncoding("utf-8"); // 한글처리
		
		// 3. 클라이언트가 보내온 요청 문자를 구분
		// http : // localhost:8080/MVC/list.mvc
		String reqString = req.getServletPath(); // = list.mvc가 추출
		System.out.println(reqString);
		if(reqString.equals("/main.mvc")) { // 식품 정보 목록 
			mainController.foodSearchAll(req, rep);
		}
		else if(reqString.equals("/foodSearch.mvc")) { // 식품 조회 
			mainController.foodSearch(req, rep);
        }
		else if(reqString.equals("/detail.mvc")) { // 식품 상세 조회 
			mainController.detail(req, rep);
        }
		else if(reqString.equals("/memberAdd.mvc")) { // 회원가입
			memberController.memberAdd(req, rep);
        }
        else if(reqString.equals("/memberSearch.mvc")) { // 회원조회
        	memberController.memberSearch(req, rep);
        }
        else if(reqString.equals("/memberModify.mvc")) { // 회원 수정
        	memberController.memberModify(req, rep);
        }
        else if(reqString.equals("/memberWithdraw.mvc")) { // 회원 탈퇴
        	memberController.memberWithdraw(req, rep);
        }
        else if(reqString.equals("/login.mvc")) { // 로그인
        	memberController.login(req, rep);
        }
        else if(reqString.equals("/logout.mvc")) { // 로그아웃
        	memberController.logout(req, rep);
        }
        else if(reqString.equals("/addFood.mvc")) { // 식품 섭취 리스트 추가
            memberController.addFood(req, rep);
        }
        else if(reqString.equals("/myfoodlist.mvc")) { // 식품 섭취 리스트 조회
        	mainController.myFoodList(req, rep);
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		memberController = new MemberController(); 
		mainController = new MainController();
	}

}
