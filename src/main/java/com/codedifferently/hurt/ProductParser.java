package com.codedifferently.hurt;

import com.codedifferently.hurt.Exception.ProductParserMissingKeyException;
import com.codedifferently.hurt.Exception.ProductParserMissingValueException;
import com.codedifferently.hurt.Exception.ProductParserProductCreationException;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductParser {
private ArrayList<String> ListOfKeys;
public ProductParser(){
    ListOfKeys = new ArrayList<>();

    ListOfKeys.add("naMe");
    ListOfKeys.add("price");
    ListOfKeys.add("type");
    ListOfKeys.add("expiration");
}


    public Product takeProductObjectFromString(String data) throws  ProductParserProductCreationException {
        HashMap<String,String> productData = new HashMap<>();
        try {
            for (String key : ListOfKeys) {
                String value =  findFieldByKeyValue(key,data);
                productData.put(key,value);
            }
            return new Product(productData);
        }catch(ProductParserMissingKeyException exception){
                throw new ProductParserProductCreationException();
        }
        catch(ProductParserMissingValueException exception){
            throw new ProductParserProductCreationException();
        }
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
