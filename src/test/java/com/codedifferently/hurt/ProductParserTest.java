package com.codedifferently.hurt;

import com.codedifferently.hurt.Exception.ProductParserMissingKeyException;
import com.codedifferently.hurt.Exception.ProductParserMissingValueException;
import org.junit.Assert;
import org.junit.Test;

public class ProductParserTest {
    private String sampleItem= "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
    @Test
    public void findFieldByKeyValueTest1() throws ProductParserMissingValueException, ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();

        String expected ="Milk";
        String actual = productParser.findFieldByKeyValue("naMe",sampleItem);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findFieldByKeyValueTest2() throws ProductParserMissingValueException, ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();

        Double expected =3.23;
        Double actual = Double.parseDouble(productParser.findFieldByKeyValue("price",sampleItem));
        Assert.assertEquals(expected,actual,0.00);
    }

    @Test(expected = ProductParserMissingKeyException.class)
    public void findFieldByKeyValueTest3() throws ProductParserMissingValueException, ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();
        String missingKey = "naMe:;price:3.23;type:Food;expiration:1/25/2016";
        productParser.findFieldByKeyValue("naMe",missingKey);

    }

    @Test(expected = ProductParserMissingValueException.class)
    public void findFieldByKeyValueTest4() throws  ProductParserMissingValueException, ProductParserMissingKeyException {
        ProductParser productParser =new ProductParser();
        String missingValue = "price:;type:Food;expiration:1/25/2016";
        productParser.findFieldByKeyValue("naMe",missingValue);

    }
}
