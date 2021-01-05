package com.codedifferently.hurt;

import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {

    public static String sampleInput = "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##\n" +
            "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##\n" +
            "naMe:;price:3.23;type:Food^expiration:1/04/2016##";

    public static String sampleInput1 = "naMe:;price:3.23;type:Food^expiration:1/04/2016";
    @Test
    public void rawDataReader(){
        //Given
        DataReader dataReader = new DataReader();

        //When
        int expected = 3;
        int actual = dataReader.rawDataReader(sampleInput).size();

        //Then
        Assert.assertEquals(expected, actual);

    }
}
