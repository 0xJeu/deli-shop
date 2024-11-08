package com.pluralsight.products;

import java.util.List;

public class Sandwich {
    protected List<String> bread;
    protected List<String> meatToppings, cheeseToppings, regularToppings, sauces, sides;
    protected boolean isToasted;
    private String sandwichSize;
    private double extraMeat, extraCheese;

    public Sandwich(List<String> bread, List<String> meatToppings, List<String> cheeseToppings, List<String> regularToppings, List<String> sauces, List<String> sides) {
        this.bread = bread;
        this.meatToppings = meatToppings;
        this.cheeseToppings = cheeseToppings;
        this.regularToppings = regularToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted();
    }

    public void getPrice() {

    }


    //Getters and Setters
    public List<String> getBread() {
        return bread;
    }

    public void setBread(List<String> bread) {
        this.bread = bread;
    }

    public List<String> getMeatToppings() {
        return meatToppings;
    }

    public void setMeatToppings(List<String> meatToppings) {
        this.meatToppings = meatToppings;
    }

    public List<String> getCheeseToppings() {
        return cheeseToppings;
    }

    public void setCheeseToppings(List<String> cheeseToppings) {
        this.cheeseToppings = cheeseToppings;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public List<String> getSides() {
        return sides;
    }

    public void setSides(List<String> sides) {
        this.sides = sides;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}

