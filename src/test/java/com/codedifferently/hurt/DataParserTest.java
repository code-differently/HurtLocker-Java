package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DataParserTest {
    DataParser dataParser;
    String rawData;
    Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
        rawData = main.readRawDataToString();
        dataParser = new DataParser();
    }

    @Test
    public void parse() {
        String actual = Arrays.toString(dataParser.parse(rawData));
        String expected = "[name:milk;price:3.23;type:food;expiration:1/25/2016, name:bread;price:1.23;type:food;expiration:1/02/2016, name:bread;price:1.23;type:food;expiration:2/25/2016, name:milk;price:3.23;type:food^expiration:1/11/2016, name:cookies;price:2.25;type:food%expiration:1/25/2016, name:cookies;price:2.25;type:food*expiration:1/25/2016, name:cookies;price:2.25;type:food;expiration:3/22/2016, name:cookies;price:2.25;type:food;expiration:1/25/2016, name:milk;price:3.23;type:food;expiration:1/17/2016, name:milk;price:1.23;type:food!expiration:4/25/2016, name:apples;price:0.25;type:food;expiration:1/23/2016, name:apples;price:0.23;type:food;expiration:5/02/2016, name:bread;price:1.23;type:food;expiration:1/25/2016, name:;price:3.23;type:food;expiration:1/04/2016, name:milk;price:3.23;type:food;expiration:1/25/2016, name:bread;price:1.23;type:food@expiration:1/02/2016, name:bread;price:1.23;type:food@expiration:2/25/2016, name:milk;price:;type:food;expiration:1/11/2016, name:cookies;price:2.25;type:food;expiration:1/25/2016, name:co0kies;price:2.25;type:food;expiration:1/25/2016, name:cookies;price:2.25;type:food;expiration:3/22/2016, name:cookies;price:2.25;type:food;expiration:1/25/2016, name:milk;price:3.23;type:food;expiration:1/17/2016, name:milk;price:;type:food;expiration:4/25/2016, name:apples;price:0.25;type:food;expiration:1/23/2016, name:apples;price:0.23;type:food;expiration:5/02/2016, name:bread;price:1.23;type:food;expiration:1/25/2016, name:;price:3.23;type:food^expiration:1/04/2016]";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

}