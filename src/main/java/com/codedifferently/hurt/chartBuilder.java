package com.codedifferently.hurt;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Map;

public class chartBuilder {
    ArrayList milk = new ArrayList();
    ArrayList bread = new ArrayList();
    ArrayList cookies = new ArrayList();
    ArrayList apples = new ArrayList();
    StringBuilder milkChart = new StringBuilder();
    String spacer = "        ";
    String rowDivider = "-------------";
    String headerLine = "=============";
    int milkCount = (new Main()).getMilkCount();

    public String outputChart(Map itemMap) {
        //System.out.println(itemMap);
        // iterate the map and add
        for (Object entry : itemMap.entrySet()) {
            String entryString = entry.toString();
            if (!entryString.contains("null")) {
                if (entryString.contains("Milk"))
                    milk.add(entryString);
                if (entryString.contains("Bread"))
                    bread.add(entryString);
                if (entryString.contains("Cookies"))
                    cookies.add(entryString);
                if (entryString.contains("Apples"))
                    apples.add(entryString);
            }
        }
        createMilkChart(milk);
        createBreadChart(bread);
        createCookiesChart(cookies);
        createApplesChart(apples);
        return null;
    }

    public String createMilkChart(ArrayList milk) {
        String[] tempStrArray = new String[milk.size()];
        String[] line1 = new String[milk.size()];
        String[] line2 = new String[milk.size()];

        String tempString = "";
        String tempString2 = "";
        String assemblerString = "";
        String assemblerString2 = "";
        String assemblerString3 = "";
        String assemblerString4 = "";

        for (int i =0; i < milk.size(); i++) {
            if (i == 0) {
                tempStrArray = milk.get(i).toString().split(",");
                tempString = String.format(tempStrArray[0]);
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");

                assemblerString = String.format("%s: %s" + spacer + "seen: %d times", StringUtils.center(line1[0].trim(), 6), StringUtils.center(line1[1].trim(), 5), milkCount);
                System.out.println(assemblerString);

                String header = StringUtils.center(headerLine + spacer + headerLine, 32);
                System.out.println(header);

                assemblerString2 = String.format("%s: %s" + spacer + "seen: %s times", StringUtils.center(line2[0].trim(), 6), StringUtils.center(line2[1].trim(), 5), priceCount);

                String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
                System.out.println(assemblerString2);
                System.out.println(rowLine);
            }

            if (i > 0 && i < milk.size()) {
                tempStrArray = milk.get(i).toString().split(",");
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line2 = tempString2.split(":");

                assemblerString4 = String.format("%s: %s" + spacer + "seen: %s times", StringUtils.center(line2[0], 6), StringUtils.center(line2[1], 5), priceCount);
                System.out.println(assemblerString4);
            }
        }
        return null;
    }

    public String createBreadChart(ArrayList bread) {
        return null;
    }

    public String createCookiesChart(ArrayList cookies) {
        //System.out.println(cookies.toString());

        return null;
    }

    public String createApplesChart(ArrayList apples) {
        //System.out.println(apples.toString());

        return null;
    }


}
