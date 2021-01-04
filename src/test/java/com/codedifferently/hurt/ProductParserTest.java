package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class ProductParserTest {
    private String sampleItem= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
    @Test
    public void findFieldByKeyValueTest1() throws ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();

        String expected ="Milk";
        String actual = productParser.findFieldByKeyValue("naMe",sampleItem);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findFieldByKeyValueTest2() throws ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();

        Double expected =3.23;
        Double actual = Double.parseDouble(productParser.findFieldByKeyValue("price",sampleItem));
        Assert.assertEquals(expected,actual,0.00);
    }

    @Test(expected = ProductParserMissingKeyException.class)
    public void findFieldByKeyValueTest3() throws ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();
        String missingValue = "naMe:;price:3.23;type:Food;expiration:1/25/2016";
        productParser.findFieldByKeyValue("naMe",missingValue);

    }
}
