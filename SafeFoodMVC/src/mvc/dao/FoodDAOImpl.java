package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import mvc.util.FoodSAXParser;
import mvc.vo.Food;

public class FoodDAOImpl implements FoodDAO{
	private List<Food> foods;

	public FoodDAOImpl() {
		this.foods = new ArrayList<>();
	}

	public FoodDAOImpl(List<Food> foods) {
		this.foods = foods;
	}

	@Override
	public void loadData() {
		// xml을 통한 instance
		FoodSAXParser parser = new FoodSAXParser();
		this.foods = parser.getFoods();
	}

	@Override
	public int foodCount() {
		return foods.size();
	}

	@Override
	public List<Food> searchAll() {
		this.loadData(); // 데이터 로드
		return foods;
	}

	@Override
	public List<Food> search(String condition, String word) {
		System.out.println(word);
		List<Food> ret = new ArrayList<>();
		// 식품 명, 제조사, 재료 기반으로 검색
		for (Food f : foods) {
			String name = f.getName();
			String maker = f.getMaker();
			String material = f.getMaterial();
			if (name.contains(word) || maker.contains(word) || material.contains(word)) {
				ret.add(f);
			}
		}
		return ret;
	}

	@Override
	public List<Food> searchBest() {
		return null;
	}

	@Override
	public List<Food> searchBestIndex() {
		return null;
	}

	@Override
	public Food search(String code) {
		for(Food f : foods)
			if(f.getCode().equals(code))
				return f;
		return null;
	}

}
