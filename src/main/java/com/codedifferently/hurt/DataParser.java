package com.codedifferently.hurt;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {

    public void parse(String input) {
        input = input.toLowerCase();

        System.out.println(input); //data before parsing
        String[] strArr = input.split("##");

        System.out.println(Arrays.toString(strArr)); //each item split into an array
        Arrays.stream(strArr).forEach(this::createData); //run our below function on each element in our array.
    }

    public void createData(String str) {
        String result = "";

        Matcher m = Pattern.compile("\\w+.*\\w+").matcher(str);
        while (m.find()) {
            String data = m.group();
            DataBuilder.buildClass(data); // takes each formatted line and creates an object in DataBuilder
        }
        DataBuilder.createLogFile();
    }

}