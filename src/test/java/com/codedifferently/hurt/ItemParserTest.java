package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ItemParserTest {

	private static String sampleinput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
	private static String sampleinput2 = "naMe:;price:3.23;type:Food^expiration:1/04/2016";
	ItemParser itemParser;

	@Before
	public void before(){
		itemParser = new ItemParser();
	}

	@Test
	public void convertStringToItemTest(){
		HashMap<String, String> testMap = new HashMap<>();
		testMap.put("name","Milk");
		testMap.put("price","3.23");
		testMap.put("type","Food");
		testMap.put("expiration","1/25/2016");
		Item expected = new Item(testMap);
		Item actual = itemParser.convertStringToItem(sampleinput);
		Assert.assertTrue(expected.toString().contains(actual.toString()));
	}

	@Test
	public void convertStringToItemTest02() {
		HashMap<String, String> testMap = new HashMap<>();
		testMap.put("name",null);
		testMap.put("price","3.23");
		testMap.put("type","Food");
		testMap.put("expiration","1/04/2016");
		Item expected = new Item(testMap);
		Item actual = itemParser.convertStringToItem(sampleinput2);
		Assert.assertEquals(expected.toString(),actual.toString());
	}

	@Test
	public void findValueByKeyTest01() {

		String expected = "Milk";
		String actual = itemParser.findValueByKey("name",sampleinput);

		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest02() {
		String expected = "3.23";
		String actual = itemParser.findValueByKey("price",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest03() {
		String expected = "Food";
		String actual = itemParser.findValueByKey("type",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest04() {
		String expected = "1/25/2016";
		String actual = itemParser.findValueByKey("expiration",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest05() {
		String expected = "Food";
		String actual = itemParser.findValueByKey("type",sampleinput2);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest06() {
		String actual = itemParser.findValueByKey("name",sampleinput2);
		Assert.assertNull(actual);
	}



}