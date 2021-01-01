package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;


public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        DataParser dataParser = new DataParser();

        String rawData = main.readRawDataToString();
        dataParser.parse(rawData);
    }
}
