package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataReaderTest {

	private static String sampleinput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
	private static String sampleinput2 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
	@Test
	public void rawDataReader(){
		//Given
		DataReader dataReader = new DataReader();

		//When
		int expected = 3;
		int actual =  dataReader.rawDataReader(sampleinput).size();
		//Assert
		Assert.assertEquals(expected,actual);
	}
}