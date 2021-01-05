package com.codedifferently.hurt;

import com.codedifferently.hurt.Exception.ProductParserMissingKeyException;
import com.codedifferently.hurt.Exception.ProductParserMissingValueException;

public class ProductParser {

    public Product takeProductObjectFromString(String data){
        return null;
    }


    public String findFieldByKeyValue(String key,String data) throws ProductParserMissingKeyException, ProductParserMissingValueException {
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
        if(value==null) throw new ProductParserMissingValueException();
        //if we find key split string by :
        //save to return value at index 1
        return value;
    }
}
