package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;
// arrange the data into a readable state on the output tab
// Split the data on the ## marks and store in a string array
// loop through the first line using indexOf()
// Count the key and value pairs using a for loop (4)
// Throw an exception for missing key and value pairs
// Use parseObject() method to parse words


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{

        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

}
