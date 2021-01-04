package com.codedifferently.hurt;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Map;

import static com.codedifferently.hurt.Main.*;

public class chartBuilder {
    ArrayList<String> milk = new ArrayList<>();
    ArrayList<String> bread = new ArrayList<>();
    ArrayList<String> cookies = new ArrayList<>();
    ArrayList<String> apples = new ArrayList<>();
    StringBuilder allCharts = new StringBuilder();
    String[] tempStrArray;
    String[] line1;
    String[] line2;
    String spacer = "        ";
    String rowDivider = "-------------";
    String headerLine = "=============";
    String header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
    String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
    String tempString = "";
    String tempString2 = "";
    String assemblerString = "";
    String assemblerString2 = "";
    String assemblerString3 = "";

    public String outputChart(Map<String, Integer> itemMap) {

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
        String errorString = String.format("\n%s       " + spacer + "seen: %d times", StringUtils.left("Errors", 13), errCount);
        allCharts.append(errorString);
        return allCharts.toString();
    }

    private void createMilkChart(ArrayList<String> milk) {

        for (int i = 0; i < milk.size(); i++) {
            if (i == 0) {
                tempStrArray = milk.get(i).split(",");
                tempString = tempStrArray[0];
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim() + ":";
                String priceName = line2[0].trim() + ":";

                assemblerString = String.format("\n%s   %s" + spacer + "seen: %d times", StringUtils.center(name, 6), StringUtils.center(line1[1].trim(), 4), milkCount);
                assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);

                allCharts.append(assemblerString + "\n")
                        .append(header + "\n")
                        .append(assemblerString2 + "\n")
                        .append(rowLine + "\n");
            }

            if (i > 0 && i < milk.size()) {
                tempStrArray = milk.get(i).split(",");
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");
                line2 = tempString2.split(":");
                String priceName = line2[0].trim() + ":";
                assemblerString3 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                allCharts.append(assemblerString3 + "\n");
            }
        }
    }

    private void createBreadChart(ArrayList<String> bread) {
        for (int i = 0; i < bread.size(); i++) {
            if (i == 0) {
                tempStrArray = bread.get(i).split(",");
                tempString = tempStrArray[0];
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim() + ":";
                String priceName = line2[0].trim() + ":";

                assemblerString = String.format("\n%s   %s" + spacer + "seen: %d times", StringUtils.center(name, 5), StringUtils.center(line1[1].trim(), 4), breadCount);
                header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
                assemblerString2 = String.format("%s   %s" + spacer + "seen: %s times", StringUtils.center(priceName, 6), StringUtils.center(line2[1].trim(), 4), priceCount);

                allCharts.append(assemblerString + "\n")
                        .append(header + "\n")
                        .append(assemblerString2 + "\n")
                        .append(rowLine + "\n");
            }

            if (i > 0 && i < bread.size()) {
                tempStrArray = bread.get(i).split(",");
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");
                line2 = tempString2.split(":");
                assemblerString3 = String.format("%s : %s" + spacer + "seen: %s times", StringUtils.center(line2[0], 6), StringUtils.center(line2[1], 4), priceCount);
                allCharts.append(assemblerString3 + "\n");
            }
        }
    }

    private void createCookiesChart(ArrayList<String> cookies) {

        for (int i = 0; i < cookies.size(); i++) {
            if (i == 0) {
                tempStrArray = cookies.get(i).split(",");
                tempString = tempStrArray[0];
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim() + ":";
                String priceName = line2[0].trim() + ":";

                assemblerString = String.format("\n%s %s" + spacer + "seen: %d times", StringUtils.center(name, 3), StringUtils.center(line1[1].trim(), 4), cookieCount);
                assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                allCharts.append(assemblerString + "\n")
                        .append(header + "\n")
                        .append(assemblerString2 + "\n")
                        .append(rowLine + "\n");
            }

            if (i > 0 && i < cookies.size()) {
                tempStrArray = cookies.get(i).split(",");
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");
                line2 = tempString2.split(":");
                String priceName = line2[0].trim() + ":";
                assemblerString3 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                allCharts.append(assemblerString3 + "\n");

            }
        }
    }

    private void createApplesChart(ArrayList<String> apples) {

        for (int i = 0; i < apples.size(); i++) {
            if (i == 0) {
                tempStrArray = apples.get(i).split(",");
                tempString = tempStrArray[0];
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim() + ":";
                String priceName = line2[0].trim() + ":";

                assemblerString = String.format("\n%s  %s" + spacer + "seen: %d times", StringUtils.center(name, 3), StringUtils.center(line1[1].trim(), 4), appleCount);
                assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);

                allCharts.append(assemblerString + "\n")
                        .append(header + "\n")
                        .append(assemblerString2 + "\n")
                        .append(rowLine + "\n");
            }

            if (i > 0 && i < apples.size()) {
                tempStrArray = apples.get(i).split(",");
                tempString2 = tempStrArray[1];
                String priceCount = tempStrArray[2].replace("=", "");
                line2 = tempString2.split(":");
                String priceName = line2[0].trim() + ":";
                assemblerString3 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                allCharts.append(assemblerString3 + "\n");
            }
        }
    }
}
