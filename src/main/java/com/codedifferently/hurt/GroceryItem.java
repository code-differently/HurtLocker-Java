package com.codedifferently.hurt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItem {

    public String name;
    public String price;
    public String type;
    public String expiration;

    public GroceryItem(String str) {
        name = takeName(str);
        price = takePrice(str);
        type = takeType(str);
        expiration = takeExpiration(str);

    }

   public String takeName(String str) {
        Matcher nameData = Pattern.compile("[nN][aA][mM][eE]:([^;]+);").matcher(str);
        StringBuilder returnName = new StringBuilder();
        while(nameData.find()){
            returnName.append(rewrite(nameData.group(1)));
        }
        return returnName.toString();
    }

    public String takePrice(String str) {
        Matcher priceData = Pattern.compile("[pP][rR][iI][cC][eE]:([^;]+);").matcher(str);
        StringBuilder returnPrice = new StringBuilder();
        while(priceData.find()){
            returnPrice.append(priceData.group(1));
        }
        return returnPrice.toString();
    }

    public String takeType(String str) {
        Matcher foodTypeData = Pattern.compile("type:([^;\\^%*!@]+)[;\\^%*!@]").matcher(str);
        StringBuilder returnFoodType = new StringBuilder();
        while(foodTypeData.find()){
            returnFoodType.append(foodTypeData.group(1));
        }
        return returnFoodType.toString();
    }

    public String takeExpiration(String str) {
        Matcher expirationData = Pattern.compile("expiration:([0-9]/[0-9]{2}/[0-9]{4})").matcher(str);
        StringBuilder returnExpirationDate = new StringBuilder();
        while(expirationData.find()){
            returnExpirationDate.append(expirationData.group(1));
        }
        return returnExpirationDate.toString();
    }


    public static String rewrite(String name) {
        if(name.matches("(?i)m.lk")){
            return "Milk";
        }else if(name.matches("(?i)br.+d")){
          return "Bread";
        }else if(name.matches("(?i)c.+s")){
            return "Cookies";
        }else if(name.matches("(?i)a.+s")){
            return "Apples";
        }else{
            return "";
        }
    }
}
