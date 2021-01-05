package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class DataParserTest {
    private static String sampleInput = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    private static String sampleInput2 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
    @Test
    public void rawDataParser(){
        //Given:
        DataParser dataParser = new DataParser();

        //When:
         int expected = 3;
         int actual = dataParser.rawDataParser(sampleInput).size();

        //Assert:
        Assert.assertEquals(expected,actual);
    }
}
