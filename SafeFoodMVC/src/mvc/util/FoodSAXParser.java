package mvc.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import mvc.vo.Food;

public class FoodSAXParser {
	/**영양성분 xml 파일 경로*/
	private String nutritionFilePath;
	/**식품정보 xml 파일 경로*/
	private String foodFilePath;
	private StringBuilder xml;
	/**식품 정보 목록*/
	private List<Food> foods;
	
	public FoodSAXParser() {
		foodFilePath = "C:\\SSAFY\\work_java\\SafeFoodMVC\\xml\\safeFood_foodInfo.xml";
		nutritionFilePath = "C:\\SSAFY\\work_java\\SafeFoodMVC\\xml\\safeFood_FoodNutritionInfo.xml";
		loadData();
	}

	public FoodSAXParser(String nutritionFilePath, String foodFilePath, StringBuilder xml, List<Food> foods) {
		this.nutritionFilePath = nutritionFilePath;
		this.foodFilePath = foodFilePath;
		this.xml = xml;
		this.foods = foods;
	}
	/**
	 * foodFilePath, nutritionFilePath로부터 xml 파일을 parsing하여 instance하는 메소드
	 */
	private void loadData() {
		// 코드, 이름, 제조사, 재료, 이미지 로드
		FoodSAXHandler foodSaxHandler = new FoodSAXHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(foodFilePath, foodSaxHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		// 이름, 영양성분 로드
		FoodNutritionSAXHandler NutritionSaxHandler = new FoodNutritionSAXHandler();
		factory = SAXParserFactory.newInstance();
		parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(nutritionFilePath, NutritionSaxHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		// 로드된 영양성분 데이터 반환
		this.foods = NutritionSaxHandler.getFoods();
		// 영양성분과 Food 정보 병합
		Map<String, Food> map = foodSaxHandler.getFoods();
		for(Food f : foods) {
			Food cur = map.get(f.getName());
			f.setCode(cur.getCode());
			f.setName(cur.getName());
			f.setMaker(cur.getMaker());
			f.setMaterial(cur.getMaterial());
			f.setImage(cur.getImage());
		}
	}
	/**
	 * instance된 식품 정보 목록 반환
	 * @return
	 */
	public List<Food> getFoods(){
		return this.foods;
	}
}
