package com.codedifferently.hurt;

import junit.framework.TestCase;
import org.junit.Assert;

public class FoodContainersTest extends TestCase {
    public FoodContainers foodContainers;
    DataParser dataParser;
    String rawData;
    Main main;


    public void setUp() throws Exception { //Tests FillContainers.
        main = new Main();
        dataParser = new DataParser();
        foodContainers = new FoodContainers();
        rawData = main.readRawDataToString();
        dataParser.parse(rawData);
    }

    public void testGetApples() {
        //given
        foodContainers.fillContainers(DataBuilder.getFoodItemsList());
        //when
        Integer actual = foodContainers.getApples().size();
        System.out.println(actual);
        Integer expected = 4;
        //then
        Assert.assertEquals(expected, actual);
    }

    public void testGetBread() {
        //given
        foodContainers.fillContainers(DataBuilder.getFoodItemsList());
        //when
        Integer actual = foodContainers.getBread().size();
        System.out.println(actual);
        Integer expected = 6;
        //then
        Assert.assertEquals(expected, actual);
    }

    public void testGetCookies() {
        //given
        foodContainers.fillContainers(DataBuilder.getFoodItemsList());
        //when
        Integer actual = foodContainers.getCookies().size();
        System.out.println(actual);
        Integer expected = 8;
        //then
        Assert.assertEquals(expected, actual);
    }

    public void testGetMilk() {
        //given
        foodContainers.fillContainers(DataBuilder.getFoodItemsList());
        //when
        Integer actual = foodContainers.getMilk().size();
        System.out.println(actual);
        Integer expected = 8;
        //then
        Assert.assertEquals(expected, actual);
    }

    public void testGetErrors() {
        //given
        foodContainers.fillContainers(DataBuilder.getFoodItemsList());
        //when
        Integer actual = foodContainers.getErrors().size();
        System.out.println(actual);
        Integer expected = 2;
        //then
        Assert.assertEquals(expected, actual);
    }

}