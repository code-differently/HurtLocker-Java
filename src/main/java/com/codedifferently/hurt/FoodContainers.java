package com.codedifferently.hurt;

import java.util.ArrayList;
import java.util.List;

public class FoodContainers implements ContainerMethods{

    private List<FoodItem> apples;
    private List<FoodItem> bread;
    private List<FoodItem> cookies;
    private List<FoodItem> milk;
    private List<FoodItem> errors;

    public FoodContainers() {
        apples = new ArrayList<>();
        bread = new ArrayList<>();
        cookies = new ArrayList<>();
        milk = new ArrayList<>();
        errors = new ArrayList<>();
    }

    public List<FoodItem> getApples() {
        return apples;
    }

    public List<FoodItem> getBread() {
        return bread;
    }


    public List<FoodItem> getCookies() {
        return cookies;
    }


    public List<FoodItem> getMilk() {
        return milk;
    }

    public List<FoodItem> getErrors() {
        return errors;
    }

    @Override
    public void fillContainers(List<FoodItem> foodItems) {
        for(FoodItem item : foodItems) {
            if(item.getName().equals("milk")) {
                milk.add(item);
            }
            else if(item.getName().equals("apples")) {
                apples.add(item);
            }
            else if(item.getName().equals("bread")) {
                bread.add(item);
            }
            else if(item.getName().equals("cookies")) {
                cookies.add(item);
            }
            else errors.add(item);
        }
    }

}

