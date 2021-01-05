package com.codedifferently.hurt;

import java.util.Map;

public class Product {
    private String name;
    private Double price;
    private String type;
    private String expiration;

    public Product(Map<String,String> rawDataMap) {
        this.name = rawDataMap.get("name");
        this.price = Double.parseDouble(rawDataMap.get("price"));
        this.type = rawDataMap.get("type");
        this.expiration = rawDataMap.get("expiration");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", expiration='" + expiration + '\'' +
                '}';
    }
}
