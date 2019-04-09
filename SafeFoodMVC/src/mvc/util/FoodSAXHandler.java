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
	 * ���� ���� �� ȣ��ȴ�.
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("FoodSAXHandler starts.");
	}

	/**
	 * ���� ���� �� ȣ��ȴ�.
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("FoodSAXHandler ends.");
	}

	/**
	 * Element ���� �� ȣ��ȴ�.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = qName.trim(); // ���� parsing ���� ������ ����
		if(temp.equals("food"))
			food = new Food();
	}
	/**
	 * Text ���� �� ȣ��ȴ�.
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
	 * Element ���� �� ȣ��ȴ�.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) { // �� ���� food ������ ��� �����Ͽ��� ��� ����Ʈ�� �߰�
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
