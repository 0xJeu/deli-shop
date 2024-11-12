package com.pluralsight.products;

public class Chip implements Product{
    private String name;
    private double price;

    public Chip(String name) {
        this.name = name;
        this.price = 1.50;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getSize() {
        return "N/A";
    }

    @Override
    public String getDescription() {
        return "Chips";
    }

    //Getters and Setters
    public String getName() {
        return String.format("%s", name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
