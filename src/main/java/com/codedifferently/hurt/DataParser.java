package com.codedifferently.hurt;

import java.util.ArrayList;
import java.util.Arrays;

public class DataParser {
    /* Step 1: use input as a parameter to split on the ##
       Step 2: convert the [] to an []list that takes in type <string> name it inputList
       Step 3: we can ingest data and individually break it into chunks

     */
    public ArrayList<String> rawDataParser(String input) {
        String[] inputArray = input.split("##");
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(inputArray));
        String inputSpecialChars = input.replaceAll("[^a-zA-Z0-9]+","");
        inputSpecialChars = inputSpecialChars.toLowerCase();
        return inputList;

       }
    }S


