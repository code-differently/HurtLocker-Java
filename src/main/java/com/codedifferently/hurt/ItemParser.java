package com.codedifferently.hurt;


import com.codedifferently.exceptions.ItemParserMissingValueException;

public class ItemParser {


    public static String findFieldByKeyValue(String key, String input) throws ItemParserMissingValueException, ItemParserMissingValueException {
        //Split the data into an array
        String[] inputArray = input.split(";");
        //search array for key
        String value = null;
        for (String item : inputArray) {
            if (item.contains(key)) {
                String[] itemArray = item.split(":");
                // if itemArray is less than 2 = to null throw new
                if(itemArray.length < 2) throw new ItemParserMissingValueException();
                value = itemArray[1];


            }

        }
        return value;
    }

    }


