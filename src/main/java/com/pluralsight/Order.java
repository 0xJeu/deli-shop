package com.pluralsight;

import com.pluralsight.products.Sandwich;

import java.util.List;

public class Order {
    private List<Sandwich> sandwich;
    private String drink, chips;

    public Order(List<Sandwich> sandwich, String drink, String chips) {
        this.sandwich = sandwich;
        this.drink = drink;
        this.chips = chips;
    }



    public List<Sandwich> getSandwich() {
        return sandwich;
    }

    public void setSandwich(List<Sandwich> sandwich) {
        this.sandwich = sandwich;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getChips() {
        return chips;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }
}
