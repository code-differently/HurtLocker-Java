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
        ItemParser itemParser = new ItemParser();
        ArrayList<String> rawData = itemParser.rawDataReader(output);
        rawData.forEach((line) -> {
            /*
            arrange the value from rawData to their respective key
            in the item object
             */
            Item item = itemParser.convertStringToItem(line);
            System.out.println(item.toString());
            }
        );

    }
}
