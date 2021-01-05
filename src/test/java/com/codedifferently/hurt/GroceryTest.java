package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class GroceryTest {
    String inputToTest = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
    @Test
    public void testTakeName(){
        GroceryItem groceryItem = new GroceryItem(inputToTest);
        String expected = "Milk";
        String actual = groceryItem.takeName(inputToTest);

        Assert.assertEquals(expected,actual);
        System.out.println(actual);
    }
    @Test
    public void testTakePrice(){
        GroceryItem groceryItem = new GroceryItem(inputToTest);
        String expected = "3.23";
        String actual = groceryItem.takePrice(inputToTest);

        Assert.assertEquals(expected,actual);
        System.out.println(actual);
    }
    @Test
    public void testTakeType(){
        GroceryItem groceryItem = new GroceryItem(inputToTest);
        String expected = "Food";
        String actual = groceryItem.takeType(inputToTest);

        Assert.assertEquals(expected,actual);
        System.out.println(actual);
    }
    @Test
    public void testTakeExpiration(){
        GroceryItem groceryItem = new GroceryItem(inputToTest);
        String expected = "1/25/2016";
        String actual = groceryItem.takeExpiration(inputToTest);

        Assert.assertEquals(expected,actual);
        System.out.println(actual);
    }
}
