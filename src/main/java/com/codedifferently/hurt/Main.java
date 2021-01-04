package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int appleCount = 0;
    public static int cookieCount = 0;
    public static int breadCount = 0;
    public static int milkCount = 0;
    public static int errCount = 0;

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public String[] cleanItUp(String output) {
        String[] s = output.replaceAll("(?i)n..e", "name")
                .replaceAll("(?i)b...d", "Bread")
                .replaceAll("(?i)m.lk", "Milk")
                .replaceAll("(?i)c..k..s", "Cookies")
                .replaceAll("(?i)a..l.s", "Apples")
                .replaceAll("(?i)p..ce", "Price")
                .replaceAll("[\\^%*!@]", ";")
                .replaceAll(";", ",")
                .replaceAll(":,", ":null,")
                .split("##");
        return s;
    }

    public Map getItemMap(String[] s) {
        Map<String, Integer> itemMap = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            String[] temp = s[i].split(",");
            String tempString = "";
            for (String z : temp) {
                if (z.contains("null"))
                    this.errCount++;
                if (z.startsWith("name") || z.startsWith("Price")) {
                    tempString += z + ",";
                }
            }

            Integer currentValue = itemMap.get(tempString);
            if (currentValue == null) {
                itemMap.put(tempString, 1);
            }
            else { int newValue = currentValue + 1;
                itemMap.replace(tempString, newValue);
            }
        }

        for (String qKey : itemMap.keySet()) {

            int qValue = itemMap.get(qKey);

            if (qKey.contains("Apples"))
                this.appleCount += qValue;
            if (qKey.contains("Cookies"))
                this.cookieCount += qValue;
            if (qKey.contains("Bread"))
                this.breadCount += qValue;
            if (qKey.contains("Milk"))
                if (!qKey.contains("null"))
                    this.milkCount += qValue;

        }

        System.out.println(milkCount);
        System.out.println(breadCount);
        System.out.println(cookieCount);
        System.out.println(appleCount);
        System.out.printf("Errors = %d%n", errCount);
        return itemMap;
    }

    public int getMilkCount() {
        return this.milkCount;
    }

    public int getBreadCount() {
        return this.breadCount;
    }

    public int getAppleCount() {
        return this.appleCount;
    }

    public int getCookieCount() {
        return this.cookieCount;
    }

    public int getErrCount() {
        return this.errCount;
    }



    public static void main(String[] args) throws Exception{
        String outputString = (new Main()).readRawDataToString();
        String[] s = new Main().cleanItUp(outputString);
        Map itemMap = new Main().getItemMap(s);
        String output = new chartBuilder().outputChart(itemMap);
    }
}
