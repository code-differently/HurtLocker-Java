package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemParserTest {

	private static String sampleinput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
	ItemParser itemParser;

	@Before
	public void before(){
		itemParser = new ItemParser();
	}

	@Test
	public void convertStringToItemTest(){

	}

	@Test
	public void findValueByKeyTest01(){

		String expected = "naMe:Milk";
		String actual = itemParser.findValueByKey("name",sampleinput);

		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest02(){
		String expected = "price:3.23";
		String actual = itemParser.findValueByKey("price",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest03(){
		String expected = "type:Food";
		String actual = itemParser.findValueByKey("type",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest04(){
		String expected = "expiration:1/25/2016";
		String actual = itemParser.findValueByKey("expiration",sampleinput);
		Assert.assertEquals(expected,actual);
	}

	@Test
	public void findValueByKeyTest05(){
		String expected = "naMe:Milk";
		String actual = itemParser.findValueByKey("Milk",sampleinput);
		Assert.assertNotEquals(expected,actual);
	}

}