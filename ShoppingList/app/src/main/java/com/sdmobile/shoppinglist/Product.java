package com.sdmobile.shoppinglist;

public class Product {
    private String name;
    private boolean isBought;

    public Product(String name) {
        this.name = name;
        this.isBought = false;
    }

    public String getName() { return name; }
    public boolean isBought() { return isBought; }
    public void setBought(boolean bought) { isBought = bought; }
}