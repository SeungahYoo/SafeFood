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
	/**���缺�� xml ���� ���*/
	private String nutritionFilePath;
	/**��ǰ���� xml ���� ���*/
	private String foodFilePath;
	private StringBuilder xml;
	/**��ǰ ���� ���*/
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
	 * foodFilePath, nutritionFilePath�κ��� xml ������ parsing�Ͽ� instance�ϴ� �޼ҵ�
	 */
	private void loadData() {
		// �ڵ�, �̸�, ������, ���, �̹��� �ε�
		FoodSAXHandler foodSaxHandler = new FoodSAXHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(foodFilePath, foodSaxHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		// �̸�, ���缺�� �ε�
		FoodNutritionSAXHandler NutritionSaxHandler = new FoodNutritionSAXHandler();
		factory = SAXParserFactory.newInstance();
		parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse(nutritionFilePath, NutritionSaxHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		// �ε�� ���缺�� ������ ��ȯ
		this.foods = NutritionSaxHandler.getFoods();
		// ���缺�а� Food ���� ����
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
	 * instance�� ��ǰ ���� ��� ��ȯ
	 * @return
	 */
	public List<Food> getFoods(){
		return this.foods;
	}
}
