package mvc.service;

import java.util.List;
import mvc.vo.Food;

public interface FoodService {
	/**
	 * 식품 정보 목록 반환
	 * @return 식품 정보 목록
	 */
	public List<Food> searchAll();
	/**
	 * 식품 코드와 일치하는 식품 정보 반환
	 * @param code 식품 코드 정보
	 * @return 식품 정보 
	 */
	public Food search(String code);
	/**
	 * 조건과 검색어와 일치하는 식품 정보 목록 반환
	 * @param condition 조건
	 * @param word 검색어
	 * @return 조건과 검색어와 일치하는 식품 정보 목록
	 */
	public List<Food> search(String condition, String word);
	/**
	 * 찜 또는 추가가 가장 많은 식품 정보 목록 반환
	 * @return 찜 또는 추가가 가장 많은 식품 정보 목록
	 */
	public List<Food> searchBest();
	/**
	 * 찜 또는 추가가 가장 많은 식품 정보 index 목록 반환
	 * @return 찜 또는 추가가 가장 많은 식품 정보 index 목록
	 */
	public List<Food> searchBestIndex();
}