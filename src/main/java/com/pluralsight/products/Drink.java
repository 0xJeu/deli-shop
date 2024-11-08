package com.pluralsight.products;

public class Drink implements Product{

    private String name;
    private double price;
    private String size;

    public Drink(String name, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getDescription() {
        return "Drink";
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
