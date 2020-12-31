package com.codedifferently.hurt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class DataBuilder {

    static int count = 0;

    static List<FoodItem> foodItemList = new ArrayList<>();
    static int errorsCount = 0;

    public static List<FoodItem> getFoodItemsList() {
        return foodItemList;
    }
    public static FoodContainers foodContainers = new FoodContainers();

    public static void buildClass(String dataStr) {
        List<String> properties = getPair(dataStr); // Creates a List of strings generated with our getPair method below...

        FoodItem foodItem = new FoodItem(properties.get(0), properties.get(1), properties.get(2), properties.get(3)); //uses our strings to create a new FoodItem from each one | Name, Price, Type, Expiration |
        foodItemList.add(foodItem); // add the objects to our getDataList above...
    }

//    public static void countOccurances(FoodItem foodItem) {
//
//    }

    private static List<String> getPair(String data) {
        List<String> properties = new ArrayList<>();

        String[] sections = data.split("(;|:|\\^|%|\\*|@|!)");
        String[] dataArr = removeOddStrings(sections);             //// TODO: 12/31/20 changed this to call removeOddStrings

        for (int i = 0; i < dataArr.length; i += 2) {
            try {
                System.out.println(dataArr[i] + ": " + dataArr[i + 1]);

                properties.add(dataArr[i + 1]);
            } catch (IndexOutOfBoundsException e) {
                errorsCount++;
            }
        }
        System.out.println(count++);
        return properties;
    }

    public static String[] removeOddStrings(String[] strings) { // // TODO: 12/31/20 this just removed co0kies, improve?
        for(int i = 0; i < strings.length; i++) {
            if(strings[i].equals("co0kies")) strings[i] = "cookies";
            if(strings[i].equals("")) strings[i] = "ERROR";
        }
        return strings;
    }

    public static void createLogFile() {
        File file = new File("output2.txt");

        try {
            String output = getPrintedText();

            FileWriter writer = new FileWriter(file);
            writer.write(output);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("FAILED");
        }
    }

    private static String getPrintedText() {
        String output = "";

        foodContainers.fillContainers(getFoodItemsList());

        Map<String, Long> names = getAllNames();
        Map<String, Long> prices = getAllPricesForNames(); //// TODO: 12/31/20 THIS NEEDS TO ONLY GET BACK MILK< COOKIES< APPLES< OR BREAD not ALL.

        for(Map.Entry<String, Long> header : names.entrySet()) {
            if(header.getKey().equals("ERROR")) {
                continue;
            }
            output += String.format("Name:  %7s    Seen: %d  Times\n", header.getKey(), header.getValue()); //Header for each item
            output += String.format("==============    ==============\n");

            for(Map.Entry<String, Long> price : prices.entrySet()) {
                if(price.getKey().equals("ERROR")) {
                    continue;
                }
                output += String.format("Price:  %6s    Seen: %d  Times\n", price.getKey(), price.getValue());
                output += String.format("--------------    --------------\n");
            }
            output += "\n";
        }

        System.out.println(output);
        return output;
    }

    public static Map<String, Long> getAllNames() {
        return  foodItemList
                .stream()
                .map(FoodItem::getName)
                //.filter(name-> !name.equals("ERROR"))
                .collect(Collectors.groupingBy(
                        name->name,
                        Collectors.counting()
                ));
    }

    public static Map<String, Long> getAllPricesForNames() {
        return  foodItemList
                .stream()
                .map(FoodItem::getPrice)
                //.filter(price-> !price.equals("ERROR"))
                .collect(Collectors.groupingBy(
                        price->price,
                        Collectors.counting()
                ));
    }

    public static Map<String, Long> getNameCountByType(String type) {
        return  foodItemList
                .stream()
                .map(FoodItem::getName)
                .filter(name-> name.equals(type))
                .collect(Collectors.groupingBy(
                        types->types,
                        Collectors.counting()
                ));
    }

    public static Map<String, Long> getPriceCountByType() {
        return  foodItemList
                .stream()
                .map(FoodItem::getName)
                .collect(Collectors.groupingBy(
                        prices->prices,
                        Collectors.counting()
                ));
    }



}


