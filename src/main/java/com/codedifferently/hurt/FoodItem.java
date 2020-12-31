package com.codedifferently.hurt;

public class FoodItem {
    private String name;
    private String price;
    private String type;
    private String expiration;

    public FoodItem(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }
}