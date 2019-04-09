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
 * Front Controller : Ŭ���̾�Ʈ�κ��� ������ ��� ��û�� ����
 * ���� ��û ó���� ���� Controller(MemberController)���� �۾��� �ѱ�
 * */
// @WebFilter("/MemberFilter")
@WebFilter("*.mvc") // ~.mvc�� ������ ��� ��û�� �ްڴ�. ex) http://localhost:8080/MVC/list.mvc
public class MainFilter implements Filter {
	
	private MemberController memberController;
	private MainController mainController;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. request, response�� Http�� �ٲ۴�.
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		// 2. charset�� �����Ѵ�.
		req.setCharacterEncoding("utf-8"); // �ѱ�ó��
		
		// 3. Ŭ���̾�Ʈ�� ������ ��û ���ڸ� ����
		// http : // localhost:8080/MVC/list.mvc
		String reqString = req.getServletPath(); // = list.mvc�� ����
		System.out.println(reqString);
		if(reqString.equals("/main.mvc")) { // ��ǰ ���� ��� 
			mainController.foodSearchAll(req, rep);
		}
		else if(reqString.equals("/foodSearch.mvc")) { // ��ǰ ��ȸ 
			mainController.foodSearch(req, rep);
        }
		else if(reqString.equals("/detail.mvc")) { // ��ǰ �� ��ȸ 
			mainController.detail(req, rep);
        }
		else if(reqString.equals("/memberAdd.mvc")) { // ȸ������
			memberController.memberAdd(req, rep);
        }
        else if(reqString.equals("/memberSearch.mvc")) { // ȸ����ȸ
        	memberController.memberSearch(req, rep);
        }
        else if(reqString.equals("/memberModify.mvc")) { // ȸ�� ����
        	memberController.memberModify(req, rep);
        }
        else if(reqString.equals("/memberWithdraw.mvc")) { // ȸ�� Ż��
        	memberController.memberWithdraw(req, rep);
        }
        else if(reqString.equals("/login.mvc")) { // �α���
        	memberController.login(req, rep);
        }
        else if(reqString.equals("/logout.mvc")) { // �α׾ƿ�
        	memberController.logout(req, rep);
        }
        else if(reqString.equals("/addFood.mvc")) { // ��ǰ ���� ����Ʈ �߰�
            memberController.addFood(req, rep);
        }
        else if(reqString.equals("/myfoodlist.mvc")) { // ��ǰ ���� ����Ʈ ��ȸ
        	mainController.myFoodList(req, rep);
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		memberController = new MemberController(); 
		mainController = new MainController();
	}

}
