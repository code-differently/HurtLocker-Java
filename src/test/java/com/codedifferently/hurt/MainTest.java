package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testCleanItUp() throws Exception {
        // Given
        new Main().readRawDataToString();
        String dirtyString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String expected = "name:Milk,Price:3.23,type:Food,expiration:1/25/2016";

        // When
        String[] s = new Main().cleanItUp(dirtyString);
        String actual = s[0];

        // Then
        Assert.assertEquals(expected, actual);
    }
}

