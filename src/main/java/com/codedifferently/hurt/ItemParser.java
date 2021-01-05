package com.codedifferently.hurt;


public class ItemParser {


    public String findValueByKey(String key, String input){
        //Split the data into an array
        String[] inputArray = input.split(";");
        //search array for key
        String value = null;
        for(String item: inputArray){
            if(item.contains(key)){
                String[] itemArray = item.split(":");
                value = itemArray[1];

            }

        }
        return value;
    }

}
