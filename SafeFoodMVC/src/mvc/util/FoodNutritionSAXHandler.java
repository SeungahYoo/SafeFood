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
	 * 문서 시작 시 호출된다.
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("FoodNutritionSAXHandler starts.");
	}

	/**
	 * 문서 종료 시 호출된다.
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("FoodNutritionSAXHandler ends.");
	}

	/**
	 * Element 시작 시 호출된다.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = qName.trim(); // 현재 parsing 중인 데이터 저장
		if(temp.equals("item"))
			food = new Food();
	}
	/**
	 * Text 만날 시 호출된다.
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
	 * Element 종료 시 호출된다.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) { // 한 개의 food 정보를 모두 저장하였을 경우 리스트에 추가
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
	 * new SAXException("warning 이벤트 처리"); }
	 * 
	 * public void error(SAXParseException exception) throws SAXException {
	 * System.out.println("DTD 또는 XML Schema 문서 구조에 위배됩니다.");
	 * System.out.println("유효하지 않는 문서 입니다."); throw new
	 * SAXException("error 이벤트 처리"); }
	 * 
	 * public void fatalError(SAXParseException exception) throws SAXException {
	 * System.out.println("XML 권고안의 내용을 지키지 않았습니다.");
	 * System.out.println("잘 짜여진 XML 문서가 아닙니다."); throw new
	 * SAXException("fatalError 이벤트 처리"); }
	 */

}
