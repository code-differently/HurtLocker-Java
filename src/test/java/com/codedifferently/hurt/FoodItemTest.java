package com.codedifferently.hurt;

import junit.framework.TestCase;
import org.junit.Assert;


public class FoodItemTest extends TestCase {
    FoodItem foodItem = new FoodItem("milk", "3.23", "food", "1/25/2016");

    public void testTestGetName() {
        String actual = foodItem.getName();
        String expected = "milk";
        Assert.assertEquals(expected, actual);
    }

    public void testGetPrice() {
        String actual = foodItem.getPrice();
        String expected = "3.23";
        Assert.assertEquals(expected, actual);
    }

    public void testGetType() {
        String actual = foodItem.getType();
        String expected = "food";
        Assert.assertEquals(expected, actual);
    }

    public void testGetExpiration() {
        String actual = foodItem.getExpiration();
        String expected = "1/25/2016";
        Assert.assertEquals(expected, actual);
    }
}