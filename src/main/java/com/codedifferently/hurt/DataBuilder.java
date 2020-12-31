package com.codedifferently.hurt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataBuilder {
    static int count = 0;
    static int errorsCount = 0;

    static List<FoodItem> foodItemList = new ArrayList<>();

    public static List<FoodItem> getFoodItemsList() {
        return foodItemList;
    }

    public static FoodContainers foodContainers = new FoodContainers();

    public static void buildClass(String dataStr) {
        List<String> properties = getPair(dataStr); // Creates a List of strings generated with our getPair method below...
        FoodItem foodItem = new FoodItem(properties.get(0), properties.get(1), properties.get(2), properties.get(3)); //uses our strings to create a new FoodItem from each one | Name, Price, Type, Expiration |
        foodItemList.add(foodItem); // add the objects to our getDataList above...
    }

    private static List<String> getPair(String data) {
        List<String> properties = new ArrayList<>();

        String[] sections = data.split("(;|:|\\^|%|\\*|@|!)");
        String[] dataArr = removeOddStrings(sections);

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

    public static String[] removeOddStrings(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("co0kies")) strings[i] = "cookies";
            if (strings[i].equals("")) strings[i] = "ERROR";
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

        output += printOuter(foodContainers.getApples());
        output += printOuter(foodContainers.getBread());
        output += printOuter(foodContainers.getCookies());
        output += printOuter(foodContainers.getMilk());

        output += String.format("Errors            Seen:  %d Times\n", foodContainers.getErrors().size());

        output += "\n";
        System.out.println(output);
        return output;
    }

    private static String printOuter(List<FoodItem> foodItems) {
        String outerOutput = "";
        outerOutput += String.format("Name:  %7s    Seen: %d  Times\n", foodItems.get(0).getName(), foodItems.size());
        outerOutput += String.format("==============    ==============\n");
        outerOutput += printInner(foodItems);
        return outerOutput;
    }

    private static String printInner(List<FoodItem> foodItems) {
        String innerOutput = "";
        Map<String, Long> map = getPriceCountByType(foodItems);
        for(Map.Entry<String, Long> price : map.entrySet()) {
            if(price.getKey().equals("ERROR")) continue;
            innerOutput += String.format("Price:  %6s    Seen: %d  Times\n", price.getKey(), price.getValue());
            innerOutput += String.format("--------------    --------------\n");
            System.out.println(price);
        }
        innerOutput += "\n";
        return innerOutput;
    }


    public static Map<String, Long> getPriceCountByType(List<FoodItem> foodItemList) {
        return  foodItemList
                .stream()
                .map(FoodItem::getPrice)
                .collect(Collectors.groupingBy(
                        prices->prices,
                        Collectors.counting()
                ));
    }



}


