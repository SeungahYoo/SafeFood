package mvc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import mvc.vo.Food;

public class FoodSAXHandler extends DefaultHandler {
	/// instance field
	private Map<String,Food> foods;
	private Food food;
	private String temp;
	private Attributes attributes;

	/// constructor
	public FoodSAXHandler() {
		super();
		this.foods = new HashMap<>();
		this.food = new Food();
	}

	/// Method
	/**
	 * 문서 시작 시 호출된다.
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("FoodSAXHandler starts.");
	}

	/**
	 * 문서 종료 시 호출된다.
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("FoodSAXHandler ends.");
	}

	/**
	 * Element 시작 시 호출된다.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = qName.trim(); // 현재 parsing 중인 데이터 저장
		if(temp.equals("food"))
			food = new Food();
	}
	/**
	 * Text 만날 시 호출된다.
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length).trim();
		switch (temp) {
		case "code":
			food.setCode(data);
			break;
		case "name": 
			food.setName(data);
			break;
		case "maker":
			food.setMaker(data);
			break;
		case "material":
			food.setMaterial(data);
			break;
		case "image":
			if(food.getImage() == null || food.getImage().equals(""))
				food.setImage(data);
			break;
		default:
			break;
		}
	}

	/**
	 * Element 종료 시 호출된다.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) { // 한 개의 food 정보를 모두 저장하였을 경우 리스트에 추가
		case "food":
			foods.put(food.getName(), food);
			break;
		}
	}

	public Map<String,Food> getFoods() {
		return this.foods;
	}
	
	public static void main(String[] args) {
		FoodSAXHandler saxHandler = new FoodSAXHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
			parser.parse("xml/safeFood_foodInfo.xml", saxHandler);
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
