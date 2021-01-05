package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        OutputFormater outputFormater = new OutputFormater(output);
        System.out.println(outputFormater.report());

    }
}
