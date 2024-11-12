package com.pluralsight.products;

public class Drink implements Product{

    private String name;
    private String size;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public double getPrice() {
        double drinkPrice = 0;

        switch (size) {
            case "small":
                drinkPrice = 2.00;
            case "medium":
                drinkPrice = 2.50;
            case "large":
                drinkPrice = 3.00;
        }

        return drinkPrice;
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
        return String.format("%s %s", size,name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
