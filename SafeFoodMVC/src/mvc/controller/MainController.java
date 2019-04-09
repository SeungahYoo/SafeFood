package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.service.FoodService;
import mvc.service.FoodServiceImpl;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;
import mvc.vo.Food;
import mvc.vo.Member;

public class MainController {
	FoodService foodService;
    MemberService memberService;

	public MainController() {
		foodService = FoodServiceImpl.getInstance(); // singleton
		memberService = MemberServiceImpl.getInstance(); // singleton
	}

	public void foodSearchAll(HttpServletRequest request, HttpServletResponse response) { // ��ü Ǫ�帮��Ʈ
		// service�� ���� ��ǰ ���� ��� ����
		List<Food> list = foodService.searchAll();
		// ��ǰ ������ ������ ���
		if (list.size() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				// ��ǰ ���� ��� ����
				request.setAttribute("mainList", list);
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} 
		// ��ǰ������ �������� ���� ���
		else {
			String message = "����� ������ �����ϴ�.";
			request.setAttribute("str", message);
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void foodSearch(HttpServletRequest request, HttpServletResponse response) { // ��ǰ ��ȸ
		// ��ȸ�� keyword ����
		String word = request.getParameter("word");
		// ���� �˻� ���� - �̸�, ������, ���
		List<Food> list = foodService.search("", word);
		// ��ȸ ��� ����� ������ ���
		if (list.size() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				// ��ȸ ��� ����� ����
				request.setAttribute("mainList", list);
				request.setAttribute("type", "search");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} 
		// ��ȸ ��� ����� �������� ���� ���
		else {
			String message = "����� ������ �����ϴ�.";
			request.setAttribute("str", message);
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void detail(HttpServletRequest request, HttpServletResponse response) {
		// ��ȸ�� ��ǰ �ڵ� ���� ����
		String code = request.getParameter("code");
		// ���� �� ���� ����
		Food food = foodService.search(code);
		request.setAttribute("food", food);
		// ����ڰ� �����ҽ� �˷����� ���� ǥ��
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("m");
		if(m != null) {
			// �˷����� ��� ����
			StringBuilder sb = new StringBuilder();
			for(String allergy : m.getAllergies()) {
				if(food.getMaterial().contains(allergy)) {
					sb.append(allergy + " ");
				}
			}
			food.setAllergy(sb.toString());
		}
		// forward
		RequestDispatcher rd = request.getRequestDispatcher("/fooddetail/detail.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void myFoodList(HttpServletRequest request, HttpServletResponse response) {
		// session�� ����� ������ �����ϴ��� Ȯ��
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        // ����� ������ ������ ���
        if (id != null) {
        	// ����� ���� ��� ��ȯ
        	List<String> codes = memberService.getFoods(id);	
        	// ���� ��� �ڵ忡 ���� Food ���� ��� ����
        	List<Food> list = new ArrayList<>();
        	for(String code : codes) {
        		list.add(foodService.search(code));
        	}
        	// ����ڰ� �߰��� ��ǰ���� ��� ����
        	request.setAttribute("mainList", list);
        	RequestDispatcher rd = request.getRequestDispatcher("main/myfoodlist.jsp");
    		try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
    
}