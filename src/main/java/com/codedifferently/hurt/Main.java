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

        // So now we need to build data from this set of food items
        DataBuilder.getFoodItemsList().forEach(ele-> System.out.println(ele.getName()));

        // this also shows that we need to standardize any cookie 0s
        // and if any blank names appear.. remove them or don't add them...
    }
}
