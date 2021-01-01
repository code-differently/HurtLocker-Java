package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemParserTest {

	private static String sampleinput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

	@Test
	public void convertStringToItemTest(){

	}

	@Test
	public void findValueByKeyTest01(){

		ItemParser itemParser = new ItemParser();

		String expected = "naMe:Milk";
		String actual = itemParser.findValueByKey("name",sampleinput);

		Assert.assertEquals(expected,actual);
	}
}