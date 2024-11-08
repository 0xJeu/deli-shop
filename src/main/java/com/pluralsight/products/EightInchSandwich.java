package com.pluralsight.products;

import java.util.List;

public class EightInchSandwich extends Sandwich {
    private String sandwichSize;
    private double extraMeat, extraCheese;

    public EightInchSandwich(List<String> bread, List<String> toppings, List<String> cheese, List<String> regularToppings, List<String> sauces, List<String> sides) {
        super(bread, toppings, cheese, regularToppings, sauces, sides);
        this.sandwichSize = "8 Inches";
        this.extraCheese = getExtraMeat();
        this.extraMeat = getExtraMeat();
    }

    @Override
    public void getPrice() {

    }

    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public double getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(double extraMeat) {
        this.extraMeat = extraMeat;
    }

    public double getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(double extraCheese) {
        this.extraCheese = extraCheese;
    }
}
