package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static int appleCount = 0;
    public static int cookieCount = 0;
    public static int breadCount = 0;
    public static int milkCount = 0;
    public static int errCount = 0;

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(Objects.requireNonNull(classLoader.getResourceAsStream("RawData.txt")));

    }

    public String[] cleanItUp(String output) {
        return output.replaceAll("(?i)n..e", "Name")
                .replaceAll("(?i)b...d", "Bread")
                .replaceAll("(?i)m.lk", "Milk")
                .replaceAll("(?i)c..k..s", "Cookies")
                .replaceAll("(?i)a..l.s", "Apples")
                .replaceAll("(?i)p..ce", "Price")
                .replaceAll("[\\^%*!@]", ";")
                .replaceAll(";", ",")
                .replaceAll(":,", ":null,")
                .split("##");
    }

    private Map<String, Integer> getItemMap(String[] cleanStringArray) {
        Map<String, Integer> itemMap = new HashMap<>();
        for (String value : cleanStringArray) {
            String[] tempArray = value.split(",");
            StringBuilder tempString = new StringBuilder();

            // the hash Map-uh will contain a representation of each distinct
            // occurrence of a item with it's price
            for (String z : tempArray) {
                if (z.contains("null"))
                    errCount++;
                if (z.startsWith("Name") || z.startsWith("Price")) {
                    tempString.append(z).append(",");
                }
            }

            // get the current int value to increment it conditionally
            Integer currentValue = itemMap.get(tempString.toString());
            if (currentValue == null) {
                itemMap.put(tempString.toString(), 1);
            } else {
                int newValue = currentValue + 1;
                itemMap.replace(tempString.toString(), newValue);
            }
        }

        // iterate the map and tally a sum (count) of each price-point tallied
        for (String currentKey : itemMap.keySet()) {
            int qValue = itemMap.get(currentKey);
            if (currentKey.contains("Apples"))
                appleCount += qValue;
            if (currentKey.contains("Cookies"))
                cookieCount += qValue;
            if (currentKey.contains("Bread"))
                breadCount += qValue;
            if (currentKey.contains("Milk"))
                if (!currentKey.contains("null"))
                    milkCount += qValue;
        }
        return itemMap;
    }

    public static void main(String[] args) throws Exception {
        String outputString = (new Main()).readRawDataToString();
        String[] cleanStringArray = new Main().cleanItUp(outputString);
        Map<String, Integer> itemMap = new Main().getItemMap(cleanStringArray);
        String chart = new chartBuilder().outputChart(itemMap);
        System.out.println(chart);
    }
}
