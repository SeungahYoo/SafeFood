package mvc.service;

import java.util.List;

import mvc.dao.FoodDAO;
import mvc.dao.FoodDAOImpl;
import mvc.vo.Food;

public class FoodServiceImpl implements FoodService{
	private static FoodServiceImpl instance;
	private FoodDAO dao;
	
	private FoodServiceImpl() {
		dao = new FoodDAOImpl();
	}
	
	public static FoodService getInstance() {
		if(instance == null)
			instance = new FoodServiceImpl();
		return instance;
	}

	@Override
	public List<Food> searchAll() {
		return dao.searchAll();
	}

	@Override
	public List<Food> search(String condition, String word) {
		return dao.search(condition, word);
	}

	@Override
	public List<Food> searchBest() {
		return dao.searchBest();
	}

	@Override
	public List<Food> searchBestIndex() {
		return dao.searchBestIndex();
	}

	@Override
	public Food search(String code) {
		return dao.search(code);
	}

}