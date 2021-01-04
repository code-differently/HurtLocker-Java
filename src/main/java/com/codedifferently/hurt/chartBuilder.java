package com.codedifferently.hurt;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Map;

public class chartBuilder {
    ArrayList<String> milk = new ArrayList<>();
    ArrayList<String> bread = new ArrayList<>();
    ArrayList<String> cookies = new ArrayList<String>();
    ArrayList<String> apples = new ArrayList<String>();
    StringBuilder milkChart = new StringBuilder();
    String spacer = "        ";
    String rowDivider = "-------------";
    String headerLine = "=============";
    int milkCount = (new Main()).getMilkCount();

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
        String errorString = String.format("\n%s       " + spacer + "seen: %d times", StringUtils.left("Errors", 13), milkCount);
        System.out.println(errorString);

        return null;
    }

    public String createMilkChart(ArrayList<String> milk) {
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
                String name = line1[0].trim()+":";
                String priceName = line2[0].trim()+":";
                String segmentOne = String.format(StringUtils.center( name + "%s", 13), line1[1].trim());

                assemblerString = String.format("\n%s   %s" + spacer + "seen: %d times", StringUtils.center(name, 6), StringUtils.center(line1[1].trim(), 4), milkCount);
                System.out.println(assemblerString);

                String header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
                System.out.println(header);

                assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);

                String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
                System.out.println(assemblerString2);
                System.out.println(rowLine);
            }

            if (i > 0 && i < milk.size()) {
                tempStrArray = milk.get(i).toString().split(",");
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line2 = tempString2.split(":");

                String priceName = line2[0].trim()+":";

                assemblerString4 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                System.out.println(assemblerString4);
            }
        }
        return null;
    }

    public String createBreadChart(ArrayList<String> bread) {
        String[] tempStrArray = new String[bread.size()];
        String[] line1 = new String[bread.size()];
        String[] line2 = new String[bread.size()];

        String tempString = "";
        String tempString2 = "";
        String assemblerString = "";
        String assemblerString2 = "";
        String assemblerString3 = "";
        String assemblerString4 = "";

        for (int i =0; i < bread.size(); i++) {
            if (i == 0) {
                tempStrArray = bread.get(i).toString().split(",");
                tempString = String.format(tempStrArray[0]);
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim()+":";
                String priceName = line2[0].trim()+":";


                assemblerString = String.format("\n%s   %s" + spacer + "seen: %d times", StringUtils.center(name, 5), StringUtils.center(line1[1].trim(), 4), milkCount);
                System.out.println(assemblerString);

                String header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
                System.out.println(header);

                assemblerString2 = String.format("%s   %s" + spacer + "seen: %s times", StringUtils.center(priceName, 6), StringUtils.center(line2[1].trim(), 4), priceCount);

                String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
                System.out.println(assemblerString2);
                System.out.println(rowLine);
            }

            if (i > 0 && i < bread.size()) {
                tempStrArray = bread.get(i).toString().split(",");
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line2 = tempString2.split(":");

                assemblerString4 = String.format("%s : %s" + spacer + "seen: %s times", StringUtils.center(line2[0], 6), StringUtils.center(line2[1], 4), priceCount);
                System.out.println(assemblerString4);
            }
        }
        return null;
    }

    public String createCookiesChart(ArrayList<String> cookies) {
            String[] tempStrArray = new String[cookies.size()];
            String[] line1 = new String[cookies.size()];
            String[] line2 = new String[cookies.size()];

            String tempString = "";
            String tempString2 = "";
            String assemblerString = "";
            String assemblerString2 = "";
            String assemblerString3 = "";
            String assemblerString4 = "";

            for (int i =0; i < cookies.size(); i++) {
                if (i == 0) {
                    tempStrArray = cookies.get(i).toString().split(",");
                    tempString = String.format(tempStrArray[0]);
                    tempString2 = String.format(tempStrArray[1]);
                    String priceCount = tempStrArray[2].replace("=", "");

                    line1 = tempString.split(":");
                    line2 = tempString2.split(":");
                    String name = line1[0].trim()+":";
                    String priceName = line2[0].trim()+":";

                    assemblerString = String.format("\n%s %s" + spacer + "seen: %d times", StringUtils.center(name, 3), StringUtils.center(line1[1].trim(), 4), milkCount);
                    System.out.println(assemblerString);

                    String header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
                    System.out.println(header);

                    assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);

                    String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
                    System.out.println(assemblerString2);
                    System.out.println(rowLine);
                }

                if (i > 0 && i < cookies.size()) {
                    tempStrArray = cookies.get(i).toString().split(",");
                    tempString2 = String.format(tempStrArray[1]);
                    String priceCount = tempStrArray[2].replace("=", "");

                    line2 = tempString2.split(":");

                    String priceName = line2[0].trim()+":";

                    assemblerString4 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                    System.out.println(assemblerString4);
                }
            }
            return null;
    }

    public String createApplesChart(ArrayList<String> apples) {
        String[] tempStrArray = new String[apples.size()];
        String[] line1 = new String[apples.size()];
        String[] line2 = new String[apples.size()];

        String tempString = "";
        String tempString2 = "";
        String assemblerString = "";
        String assemblerString2 = "";
        String assemblerString3 = "";
        String assemblerString4 = "";

        for (int i =0; i < apples.size(); i++) {
            if (i == 0) {
                tempStrArray = apples.get(i).toString().split(",");
                tempString = String.format(tempStrArray[0]);
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line1 = tempString.split(":");
                line2 = tempString2.split(":");
                String name = line1[0].trim()+":";
                String priceName = line2[0].trim()+":";

                assemblerString = String.format("\n%s  %s" + spacer + "seen: %d times", StringUtils.center(name, 3), StringUtils.center(line1[1].trim(), 4), milkCount);
                System.out.println(assemblerString);

                String header = StringUtils.center(StringUtils.center(headerLine, 13) + StringUtils.center(spacer, 8) + StringUtils.center(headerLine, 13), 34);
                System.out.println(header);

                assemblerString2 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);

                String rowLine = StringUtils.center(rowDivider + spacer + rowDivider, 32);
                System.out.println(assemblerString2);
                System.out.println(rowLine);
            }

            if (i > 0 && i < apples.size()) {
                tempStrArray = apples.get(i).toString().split(",");
                tempString2 = String.format(tempStrArray[1]);
                String priceCount = tempStrArray[2].replace("=", "");

                line2 = tempString2.split(":");

                String priceName = line2[0].trim()+":";

                assemblerString4 = String.format("%s  %s" + spacer + "seen: %s times", StringUtils.center(priceName, 7), StringUtils.center(line2[1].trim(), 4), priceCount);
                System.out.println(assemblerString4);
            }
        }
        return null;
    }
}
