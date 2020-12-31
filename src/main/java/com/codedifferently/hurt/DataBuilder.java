package com.codedifferently.hurt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBuilder {

    static List<FoodItem> foodItemList = new ArrayList<>();
    static int errorsCount = 0;

    public static List<FoodItem> getFoodItemsList() {
        return foodItemList;
    }

    public static void buildClass(String dataStr) {
        List<String> properties = getPair(dataStr); // Creates a List of strings generated with our getPair method below...

        FoodItem foodItem = new FoodItem(properties.get(0), properties.get(1), properties.get(2), properties.get(3));
        //uses our strings to create a new FoodItem from each one | Name, Price, Type, Expiration |
        foodItemList.add(foodItem); // add the objects to our getDataList above...
    }

    private static List<String> getPair(String data) {
        List<String> properties = new ArrayList<>();

        String[] dataArr = data.split("(;|:|\\^|%|\\*|@|!)");
        for (int i = 0; i < dataArr.length; i += 2) {
            try {
                System.out.println(dataArr[i] + ": " + dataArr[i + 1]);
                properties.add(dataArr[i + 1]);
            } catch (IndexOutOfBoundsException e) {
                errorsCount++;
            }
        }
        System.out.println("\n");
        return properties;
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
        Map<String, Integer> names = getAllNames();
        for (String name : names.keySet()) {
            Map<String, Integer> prices = getAllPricesForNames(name);
        }
//        for (Data data : dataList) {
//            if (data.getName() == "") {
//                System.out.println("YES THIS IS BROKEN");
//                break;
//            }
//
//            output += " " + data.getName();
//            output += " " + data.getPrice();
//            output += " " + data.getType();
//            output += " " + data.getExpiration();
//            output += "\n";
//        }
        return output;
    }

    private static Map<String, Integer> getAllNames() {
        // Name, times appeared
        Map<String, Integer> map = new HashMap<>();

        for (FoodItem foodItem : foodItemList) {
            if (foodItem.getName() == "") continue;

            if (map.containsKey(foodItem.getName())) {
                int timesAppeared = map.get(foodItem.getName());
                map.put(foodItem.getName(), ++timesAppeared);
            } else {
                map.put(foodItem.getName(), 1);
            }
        }
        return map;
    }

    private static Map<String, Integer> getAllPricesForNames(String name) {
        // Price, times appeared
        Map<String, Integer> map = new HashMap<>();

        for (FoodItem foodItem : foodItemList) {
            if (foodItem.getPrice() == "") continue;

            if (map.containsKey(foodItem.getPrice())) {
                int timesAppeared = map.get(foodItem.getPrice());
                map.put(foodItem.getPrice(), ++timesAppeared);
            } else {
                map.put(foodItem.getPrice(), 1);
            }
        }
        return map;
    }

//    public static Map<String, Integer> getNames() {
//
//    }

}


