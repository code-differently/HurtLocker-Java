package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.util.Map;

import static com.codedifferently.hurt.DataBuilder.getPriceCountByType;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        Main main = new Main();
        DataParser dataParser = new DataParser();
        FoodContainers foodContainers = new FoodContainers();

        String rawData = main.readRawDataToString();
        dataParser.parse(rawData);

        // So now we need to build data from this set of food items
        //DataBuilder.getFoodItemsList().forEach(ele-> System.out.println(ele.getType()));

        System.out.println(DataBuilder.getAllNames());
        System.out.println(DataBuilder.getAllPricesForNames());

        Map<String, Long> map = getPriceCountByType(foodContainers.getApples());
        System.out.println(map);
    }
}
