package com.codedifferently.hurt;

import org.apache.commons.io.IOUtils;

public class Main {


    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = Main.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) {
        try{
            Main main = new Main();
            String dataString = Main.readRawDataToString();
        }catch (Exception e){
            System.out.println("File not found");
        }
    }
}
