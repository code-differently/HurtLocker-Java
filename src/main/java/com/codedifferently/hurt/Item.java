package com.codedifferently.hurt;

/* Step 1: create private fields for name, price, type and date
     Step 2: Create constructor that takes in a mapcreate getters and setters
     Step 3: Solid principle the class(Item) has the single responsibility for each set of string?
     Step 4: Create constructor that takes in a map


   */

import java.util.Map;

public class Item {

    private String name;
    private String price;
    private String type;
    private String date;

    public Item(Map<String, String> rawDataMap) {
        this.name = rawDataMap.get("name");
        this.price = rawDataMap.get("price");
        this.price = rawDataMap.get("type");
        this.price = rawDataMap.get("date");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {

        return name + " " + price + " " + type + " " + date + " ";
    }
}