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

	public void foodSearchAll(HttpServletRequest request, HttpServletResponse response) { // 전체 푸드리스트
		// service를 통한 식품 정보 목록 추출
		List<Food> list = foodService.searchAll();
		// 식품 정보가 존재할 경우
		if (list.size() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				// 식품 정보 목록 세팅
				request.setAttribute("mainList", list);
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} 
		// 식품정보가 존재하지 않을 경우
		else {
			String message = "저장된 음식이 없습니다.";
			request.setAttribute("str", message);
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void foodSearch(HttpServletRequest request, HttpServletResponse response) { // 식품 조회
		// 조회할 keyword 추출
		String word = request.getParameter("word");
		// 음식 검색 시작 - 이름, 제조사, 재료
		List<Food> list = foodService.search("", word);
		// 조회 결과 목록이 존재할 경우
		if (list.size() != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/main/index.jsp");
			try {
				// 조회 결과 목록을 세팅
				request.setAttribute("mainList", list);
				request.setAttribute("type", "search");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} 
		// 조회 결과 목록이 존재하지 않을 경우
		else {
			String message = "저장된 음식이 없습니다.";
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
		// 조회할 식품 코드 정보 추출
		String code = request.getParameter("code");
		// 음식 상세 정보 세팅
		Food food = foodService.search(code);
		request.setAttribute("food", food);
		// 사용자가 존재할시 알레르기 정보 표시
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("m");
		if(m != null) {
			// 알레르기 목록 세팅
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
		// session에 사용자 정보가 존재하는지 확인
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("id");
        // 사용자 정보가 존재할 경우
        if (id != null) {
        	// 사용자 섭취 목록 반환
        	List<String> codes = memberService.getFoods(id);	
        	// 섭취 목록 코드에 따라 Food 정보 목록 추출
        	List<Food> list = new ArrayList<>();
        	for(String code : codes) {
        		list.add(foodService.search(code));
        	}
        	// 사용자가 추가한 식품정보 목록 세팅
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