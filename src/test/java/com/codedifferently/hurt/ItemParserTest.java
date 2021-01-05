package com.codedifferently.hurt;


import com.codedifferently.exceptions.ItemParserMissingKeyException;
import com.codedifferently.exceptions.ItemParserMissingValueException;
import org.junit.Assert;
import org.junit.Test;

public class ItemParserTest {

    private final String sampleItem = "name:bread;price:1.23";

    @Test
    public void findFieldByKeyValueTest01() throws ItemParserMissingValueException {
        //Given
        ItemParser itemParser = new ItemParser();

        //When
        String expected = "naMe:Milk";
        String actual = itemParser.findFieldByKeyValue("name", "sampleInput");

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findFieldByKeyValueTest02() throws Exception, ItemParserMissingValueException {
        // Given
        ItemParser itemParser = new ItemParser();

        //When
        String expected = "bread";
        String actual = itemParser.findFieldByKeyValue("name", sampleItem);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findFieldByKeyValueTest03() throws Exception {
        // Given
        ItemParser itemParser = new ItemParser();

        //When
        Double expected = 1.23;
        Double actual = Double.parseDouble(itemParser.findFieldByKeyValue("price", sampleItem));

        //Then
        Assert.assertEquals(expected, actual, 0.00);
    }

    /* Exception test
       We are checking for name, if name does not have a value it will throw an error so that we don't receive a null value
       need to add a try catch parser
    */
    @Test(expected = ItemParserMissingValueException.class)
    public void findFieldByKeyValue() throws Exception {
        ItemParser itemParser = new ItemParser();
        String missingValue = "name:;price:1.23";
        ItemParser.findFieldByKeyValue("name", missingValue);

    }

    @Test(expected = ItemParserMissingValueException.class)
    public void findFieldByKeyValue() throws Exception {
        ItemParser itemParser = new ItemParser();
        String missingValue = "price:1.23";
        ItemParser.findFieldByKeyValue("price", missingValue);
    }
}
