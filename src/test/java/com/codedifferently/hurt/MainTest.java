package com.codedifferently.hurt;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainTest {

    @Test
    public void testMain() throws Exception {
        Main main = new Main();
        String result = new Main().readRawDataToString();
        String[] items = result.split("##");
        for (String s : items) {
           s = s.replaceAll("(?i)n..e", "name")
           .replaceAll("(?i)b...d", "Bread")
           .replaceAll("(?i)m.lk", "Milk")
           .replaceAll("(?i)c..k..s", "Cookies")
           .replaceAll("(?i)a..l.s", "Apples")
           .replaceAll("(?i)p..ce", "Price")
           .replaceAll("[\\^%*!@]", ";")
           .replaceAll(";", ",")
           .replaceAll(":,", ":null,");
           System.out.println(s);
        }
    }

    @Test
    public void testCleanItUp() throws Exception {

        Map<String, Integer> itemMap = new HashMap<>();

        String result = new Main().readRawDataToString();
        String[] s = new Main().cleanItUp(result);





   /* @Test
    public void testMain2() throws Exception {
        int appleCount = 0;
        int cookieCount = 0;
        int breadCount = 0;
        int milkCount = 0;
        Map<String, Integer> itemMap = new HashMap<>();
        String result = new Main().readRawDataToString();

            String[] s = result.replaceAll("(?i)n..e", "name")
                    .replaceAll("(?i)b...d", "Bread")
                    .replaceAll("(?i)m.lk", "Milk")
                    .replaceAll("(?i)c..k..s", "Cookies")
                    .replaceAll("(?i)a..l.s", "Apples")
                    .replaceAll("(?i)p..ce", "Price")
                    .replaceAll("[\\^%*!@]", ";")
                    .replaceAll(";", ",")
                    .replaceAll(":,", ":null,").split("##");

        for (int i = 0; i < s.length; i++) {
            String[] temp = s[i].split(",");
            String tempString = "";
            for (String z : temp) {
                if (z.startsWith("name") || z.startsWith("Price")) {
                    tempString += z + " ";
                }
            }

            Integer currentValue = itemMap.get(tempString);
            if (currentValue == null) {
                itemMap.put(tempString, 1);
            }
            else {
                int newValue = currentValue + 1;
                itemMap.replace(tempString, newValue);
            }
        }
        for (String qKey : itemMap.keySet()) {
            int qValue = itemMap.get(qKey);
            System.out.println(qKey + qValue);
            if (qKey.contains("Apples"))
                appleCount += qValue;
            if (qKey.contains("Cookies"))
                cookieCount += qValue;
            if (qKey.contains("Bread"))
                breadCount += qValue;
            if (qKey.contains("Milk"))
                if (!qKey.contains("null"))
                milkCount += qValue;
        }
        System.out.println(milkCount);
        System.out.println(breadCount);
        System.out.println(cookieCount);
        System.out.println(appleCount);
    }*/
    }}

