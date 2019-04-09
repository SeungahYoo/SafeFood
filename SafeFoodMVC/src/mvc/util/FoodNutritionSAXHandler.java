package mvc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import mvc.vo.Food;

public class FoodNutritionSAXHandler extends DefaultHandler {
	/// instance field
	private List<Food> foods;
	private Food food;
	private String temp;
	private Attributes attributes;

	/// constructor
	public FoodNutritionSAXHandler() {
		super();
		this.foods = new ArrayList<>();
		this.food = new Food();
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}
	
	public double changeData(String data) {
		try {
			return Double.parseDouble(data);
		}
		catch (NumberFormatException e) {
			return 0.0;
		}
	}

	/**
	 * ���� ���� �� ȣ��ȴ�.
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("FoodNutritionSAXHandler starts.");
	}

	/**
	 * ���� ���� �� ȣ��ȴ�.
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("FoodNutritionSAXHandler ends.");
	}

	/**
	 * Element ���� �� ȣ��ȴ�.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = qName.trim(); // ���� parsing ���� ������ ����
		if(temp.equals("item"))
			food = new Food();
	}
	/**
	 * Text ���� �� ȣ��ȴ�.
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length).trim();	
		switch (temp) {
		case "DESC_KOR":
			food.setName(data);
			break;
		case "SERVING_WT": 
			food.setSupportpereat(changeData(data));
			break;
		case "NUTR_CONT1":
			food.setCalory(changeData(data));
			break;
		case "NUTR_CONT2":
			food.setCarbo(changeData(data));
			break;
		case "NUTR_CONT3":
			food.setProtein(changeData(data));
			break;
		case "NUTR_CONT4":
			food.setFat(changeData(data));
			break;
		case "NUTR_CONT5":
			food.setSugar(changeData(data));
			break;
		case "NUTR_CONT6":
			food.setNatrium(changeData(data));
			break;
		case "NUTR_CONT7":
			food.setChole(changeData(data));
			break;
		case "NUTR_CONT8":
			food.setFattyacid(changeData(data));
			break;
		case "NUTR_CONT9":
			food.setTransfat(changeData(data));
			break;
		}
	}

	/**
	 * Element ���� �� ȣ��ȴ�.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) { // �� ���� food ������ ��� �����Ͽ��� ��� ����Ʈ�� �߰�
		case "item":
			foods.add(food);
			break;
		}
	}

	public List<Food> getFoods() {
		return this.foods;
	}
	
	public static void main(String[] args) {
		FoodNutritionSAXHandler saxHandler = new FoodNutritionSAXHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse("xml/safeFood_FoodNutritionInfo.xml", saxHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * public void warning(SAXParseException exception) throws SAXException { throw
	 * new SAXException("warning �̺�Ʈ ó��"); }
	 * 
	 * public void error(SAXParseException exception) throws SAXException {
	 * System.out.println("DTD �Ǵ� XML Schema ���� ������ ����˴ϴ�.");
	 * System.out.println("��ȿ���� �ʴ� ���� �Դϴ�."); throw new
	 * SAXException("error �̺�Ʈ ó��"); }
	 * 
	 * public void fatalError(SAXParseException exception) throws SAXException {
	 * System.out.println("XML �ǰ���� ������ ��Ű�� �ʾҽ��ϴ�.");
	 * System.out.println("�� ¥���� XML ������ �ƴմϴ�."); throw new
	 * SAXException("fatalError �̺�Ʈ ó��"); }
	 */

}
