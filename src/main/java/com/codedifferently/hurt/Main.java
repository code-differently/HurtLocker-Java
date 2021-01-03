package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        DataReader dataReader = new DataReader();
        ArrayList<String> rawData = dataReader.rawDataReader(output);
        ItemParser itemParser = new ItemParser();
        rawData.forEach((line) -> {

            System.out.println(
                    itemParser.findValueByKey("name",line) +"\n"+
                    itemParser.findValueByKey("price",line) + "\n"+
                    itemParser.findValueByKey("type",line) + "\n"+
                    itemParser.findValueByKey("expiration",line)
            );

        });

    }
}
