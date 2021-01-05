package com.codedifferently.hurt;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemParserTest {

    private String sampleItem = "name:bread;price:1.23";

    @Test
    public void findValueByKeyTest01(){
        //Given
        ItemParser itemParser = new ItemParser();

        //When
        String expected = "naMe:Milk";
        String actual = itemParser.findValueByKey("name", "sampleInput");

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void findValueByKeyTest02(){
       // Given
        ItemParser itemParser = new ItemParser();

       //When
        String expected = "bread";
        String actual = itemParser.findValueByKey("name", sampleItem);

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void findValueByKeyTest03(){
        // Given
        ItemParser itemParser = new ItemParser();

        //When
       Double expected = 1.23;
       Double actual = Double.parseDouble(itemParser.findValueByKey("price",sampleItem));

        //Then
        Assert.assertEquals(expected, actual,0.00);
    }

}
