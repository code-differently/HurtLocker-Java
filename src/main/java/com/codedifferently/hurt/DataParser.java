package com.codedifferently.hurt;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {

    private static TreeMap<String, ArrayList<String>> dataForFinal(TreeMap<String, ArrayList<String>> groceryData, String name, String price, String type, String expiration, String occurrence){
        try{if(!groceryData.get(name).get(0).equals(price))
            name = name+ "2";}catch (NullPointerException e){}
        try{if(name.contains("2"))
            occurrence = Integer.toString(Integer.parseInt(groceryData.get(name).get(3)) + 1);}catch (NullPointerException e){occurrence = "1";}
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(price,type,expiration,occurrence));
        groceryData.put(name, arrayList);
        return groceryData;
    }

    private static TreeMap<String, ArrayList<String>> arrangeData (TreeMap<String, ArrayList<String>> groceryData, String name, String price, String type, String expiration){
        if(!price.isEmpty() && !name.isEmpty() && !type.isEmpty() && !expiration.isEmpty()){
            if(groceryData.containsKey(name)){
                groceryData = dataForFinal(groceryData, name,price,type,expiration, Integer.toString(Integer.parseInt(groceryData.get(name).get(3)) + 1));
            }else{
                groceryData = dataForFinal(groceryData, name, price, type, expiration,"1");
            }
        }else{
            try{
                groceryData.containsKey("Error");
                groceryData = dataForFinal(groceryData,"Error", "", "", "", Integer.toString(Integer.parseInt(groceryData.get("Error").get(3)) +1));
            }catch (NullPointerException e){groceryData = dataForFinal(groceryData, "Error", "","","","1");}
        }
        return groceryData;
    }

    private static void printDataWithHeader(TreeMap<String, ArrayList<String>> groceryData, String key, ArrayList<String> value){
        int itemTwo = 0;
        try{itemTwo = Integer.parseInt(groceryData.get(key+"2").get(3));}
        catch (NullPointerException e){}
        System.out.printf("\nname:%8s\t\tseen:%2s times\n", key, Integer.toString(Integer.parseInt(value.get(3)) + itemTwo));
        System.out.printf("=============\t\t=============\n");
        printMainData(key, value);
    }

    private static void printMainData(String key, ArrayList<String> value) {
        System.out.printf("Price:%7s\t\tseen:%2s times\n", value.get(0), value.get(3));
        if(!key.contains("2"))
            System.out.printf("-------------\t\t-------------\n");
    }

    private static void diplayMainData(TreeMap<String, ArrayList<String>> groceryData, String key, ArrayList<String> value){
        if(!key.equals("Error")){
            if(!key.contains("2")){
                printDataWithHeader(groceryData,key,value);
            }else{
                printMainData(key, value);
            }
        }
    }

    public static String displayError(TreeMap<String, ArrayList<String>> groceryData){
        for(Map.Entry<String,ArrayList<String>> error : groceryData.entrySet()){
            diplayMainData(groceryData, error.getKey(), error.getValue());
        }
        System.out.printf("\nErrors\t\t\t\tseen:%2s times\n", groceryData.get("Error").get(3));
        return null;
    }

    public static String dataReader(String str){
        Matcher finalData = Pattern.compile("([^#]+#)#").matcher(str);
        TreeMap<String, ArrayList<String>> groceryData = new TreeMap<String, ArrayList<String>>();
        while(finalData.find()){
            GroceryItem item = new GroceryItem(finalData.group(1));
            groceryData = arrangeData(groceryData,item.name,item.price, item.type, item.expiration);
        }
        displayError(groceryData);
        return groceryData.toString();
    }

}
