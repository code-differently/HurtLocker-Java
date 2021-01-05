package com.codedifferently.hurt;

import java.util.*;

import org.apache.commons.io.IOUtils;

public class Main {
    //how are we going to store the products?  LinkedHashMap
    static Map<String , Map<String, Integer>> products = new LinkedHashMap<>();
    //COokIes price 2.25 type Food expiration 3/22/2016
    //COokIes price 2.35 type Food expiration 3/22/2016

    //how are we going to keep track of error? We need to keep track of initial length and final of the array
    static int initialSize = 0;
    static int finalSize = 0;

    public  String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        new ItemParser();
  /*      String output = (new Main()).readRawDataToString();
        System.out.println(output);*/
        //here we need an arrayList to use and where we will do the operations
     /*   ArrayList<String> finalized = trimList(convertToArray(output));
        populateLinkedMap(finalized);
        System.out.println(products);*/
        //formatOutput();
    }

    /* First method: Turn the product string into an arrayList separated
      by the delimiter [^. @....etc] */

    public static ArrayList<String> convertToArray(String str){
        //What do we need to do to the String before we operate on it?
        //Remove the special characters except for the # , . and / (why? we need these
        // to determine the price and elimination and date)
        //Replace them with a " "
        String string = str.replaceAll("[^0-9a-zA-Z-#./]+", " ");


        //Convert everything into lowerCase

        string = string.toLowerCase();

        //Initialize return arrayList as a list split by the ##
        ArrayList<String> list = new ArrayList<>(Arrays.asList(string.split("##")));


        //Operate on the arrayList so that we remove the "name" signature from each element
        for(int i = 0; i < list.size(); i++){
            //naMe COokIes price 2.25 type Food expiration 3/22/2016
            list.set(i, list.get(i).substring(5));
            //COokIes price 2.25 type Food expiration 3/22/2016
        }

        //set the initialSze to the size of the arrayList (This will be the true count of products)
        initialSize = list.size();

        //return the arrayList
        return list;
    }

    /* Second method:Remove the list elements that are not starting with the name of the product. This denotes an
    error */

    public static ArrayList<String> trimList(ArrayList<String> arr){
        //Loop through each of the elements in arr
        for(int i = 0; i < arr.size(); i++){
            String[] arrElement = arr.get(i).split(" ");
            if(arrElement[0] == "price"){
                arr.remove(i);
            }
            else if(arrElement[2] == "type"){
                arr.remove(i);
            }
        }
        finalSize = arr.size();
        //In each list element, create a string array split by the " "
        //(This separates the element into smaller elements like price, type, expiration etc)

        //if the first element in the String array is equal to price remove it

        //else if the third element in the String array doesn't have a number but says "type" then remove it


        //set the finalSze to the size of the new list

        //return the list
        return arr;
    }


    /*Third method: Put the information into a LinkedHashmap, this will help us count everything */
    public static void populateLinkedMap(ArrayList<String> arr){
        //loop through each string in the list
        for(String arrInput : arr) {
            String[] category = arrInput.split((" "));
            category[0] = category[0].replace('0', 'o');
            String key = category[0];
            String price = category[2];
            if(products.containsKey(key)){

            } else {
                products.put(key, new LinkedHashMap<String, Integer>());
            }
            if(products.get(key).containsKey(price)){
                products.get(key).put(price, products.get(key).get(price) + 1);
            } else {
                products.get(key).put(price, 1);
            }
        }
        //COokIes price 2.25 type Food expiration 3/22/2016
        //split the list into categories
        //Then check the c00kie input replace all names that have 0 with o

        //add the elements to the map
        // Map:
        //category ->
        //3rd category (price)  : count
        //3rd category (price)  : count
        /* Example of what a String arr list element looks like:
            arr[0] = "Co0kieS pRice 2.25"
        */

    }

    /* Fourth method: format output to match the output text*/
    public static void formatOutput(){

    }


}