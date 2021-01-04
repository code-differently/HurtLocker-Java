package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class ProductParserTest {
    private String sampleItem= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
    @Test
    public void findFieldByKeyValue(){
        ProductParser productParser =new ProductParser();

        String expected ="naMe:Milk";
        String actual = productParser.findFieldByKeyValue("naMe",sampleItem);
        Assert.assertEquals(expected,actual);
    }
}
