package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DataBuilderTest {
    public FoodContainers foodContainers;
    DataParser dataParser;
    Main main;
    String rawData;

    @Before
    public void setUp() throws Exception {
        main = new Main();
        dataParser = new DataParser();
        foodContainers = new FoodContainers();
        rawData = main.readRawDataToString();
        dataParser.parse(rawData);
    }

    @Test
    public void getFoodItemsList() throws Exception {
        DataBuilder.getFoodItemsList().forEach(foodItem -> System.out.println(foodItem.getName()));

        String actual = DataBuilder.getFoodItemsList().get(0).getName();
        String expected = "milk";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void buildClass() {
        String actual = DataBuilder.buildClass("name:milk;price:3.23;type:food;expiration:1/25/2016").toString(); // Parsed line of data
        String expected = "FoodItem{name='milk', price='3.23', type='food', expiration='1/25/2016'}";
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOddStrings() {
    }

    @Test
    public void createLogFile() {
    }

    @Test
    public void getPriceCountByType() {
    }
}