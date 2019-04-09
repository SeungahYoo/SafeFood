package mvc.dao;

import java.util.List;

import mvc.vo.Food;

public interface FoodDAO {
	/**
	 * 저장(DB, XML)되어 있는 식품 정보 목록을 instance하는 메소드
	 */
	public void loadData();
	/**
	 * 식품 목록 개수 반환
	 * @return 식품 목록 개수
	 */
	public int foodCount();
	/**
	 * instance된 모든 식품 정보 목록 조회
	 * @return instance된 식품 정보 목록
	 */
	public List<Food> searchAll();
	/**
	 * 입력받은 코드 정보를 통해 instance된 식품 정보 조회
	 * @param code 조회할 식품 코드
	 * @return 입력 식품 코드와 일치하는 식품 정보
	 */
	public Food search(String code);
	/**
	 * 조건과 검색어 기반으로 식품 정보 목록 조회
	 * @param condition 조건 
	 * @param word 검색어
	 * @return 조건 및 검색어와 일치하는 식품 정보 목록
	 */
	public List<Food> search(String condition, String word);
	/**
	 * 찜 또는 추가 개수가 많은 식품 정보 목록 조회
	 * @return 찜 또는 추가 개수가 많은 식품 정보 목록
	 */
	public List<Food> searchBest();
	/**
	 * 찜 또는 추가 개수가 많은 식품 정보의 index 목록 조회
	 * @return 찜 또는 추가 개수가 많은 식품 정보 index 목록
	 */
	public List<Food> searchBestIndex();
	
}