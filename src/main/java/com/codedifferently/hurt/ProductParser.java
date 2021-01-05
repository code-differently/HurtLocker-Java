package com.codedifferently.hurt;

import com.codedifferently.hurt.Exception.ProductParserMissingKeyException;

public class ProductParser {
    public String findFieldByKeyValue(String key,String data) throws ProductParserMissingKeyException {
        //  split the data into an array
        String[] dataArray = data.split("[^0-9a-zA-Z#./;]+");
        //search array for key.
        String value = null;
        for(String product:dataArray){
            if(product.contains(key)){
                String[] productArray = product.split(":");
                if(productArray.length < 2 ) throw new ProductParserMissingKeyException();
                value=productArray[1];
                if(value == null) throw new ProductParserMissingKeyException();
            }
        }
        //if we find key split string by :
        //save to return value at index 1
        return value;
    }
}
