package com.pluralsight.products;

import java.util.List;

public class Sandwich implements Product {
    private final String description;
    private List<String> bread;
    private List<String> meatToppings, cheeseToppings, veggieToppings, sauces, sides;
    private boolean isToasted;
    private String sandwichSize;
    private boolean extraMeat, extraCheese;
    private double price;

    public Sandwich(List<String> bread, List<String> meatToppings, List<String> cheeseToppings, List<String> veggieToppings, List<String> sauces, List<String> sides) {
        this.description = "Sandwich";
        this.sandwichSize = getSize();
        this.bread = bread;
        this.meatToppings = meatToppings;
        this.cheeseToppings = cheeseToppings;
        this.veggieToppings = veggieToppings;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted();
    }

    @Override
    public double getPrice() {
        double sandwichPrice = this.price;

        switch (sandwichSize) {
            case "4 Inches":
                sandwichPrice += isExtraMeat() ? .50 : 0;
                sandwichPrice += isExtraCheese() ? .30 : 0;
                break;
            case "8 Inches":
                sandwichPrice += isExtraMeat() ? 1.00 : 0;
                sandwichPrice += isExtraCheese() ? .60 : 0;
                break;
            case "12 Inches":
                sandwichPrice += isExtraMeat() ? 1.50 : 0;
                sandwichPrice += isExtraCheese() ? .90 : 0;
                break;
        }

        return sandwichPrice;
    }

    /**
    *Method that prints sandwich object details i.e. bread, meat, cheese, etc.
    */
    public void printSandwichDetails() {

        System.out.println("Sandwich Size: " + this.sandwichSize);
        this.bread.forEach(bread -> System.out.printf("Bread: %s\n", bread));

        System.out.print("Meat Toppings: ");
        this.meatToppings.forEach(meat -> System.out.printf("%s%s", meat, this.meatToppings.indexOf(meat) == this.meatToppings.size() - 1 ? "\n" : ", "));

        System.out.print("Cheese Toppings: ");
        this.cheeseToppings.forEach(cheese -> System.out.printf("%s%s", cheese, this.cheeseToppings.indexOf(cheese) == this.cheeseToppings.size() - 1 ? "\n" : ", "));

        System.out.print("Veggie Toppings: ");
        this.veggieToppings.forEach(veggie -> System.out.printf("%s%s", veggie, this.veggieToppings.indexOf(veggie) == this.veggieToppings.size() - 1 ? "\n" : ", "));

        System.out.print("Sauces: ");
        this.sauces.forEach(sauces -> System.out.printf("%s%s", sauces, this.sauces.indexOf(sauces) == this.sauces.size() - 1 ? "\n" : ", "));

        System.out.print("Sides: ");
        this.sides.forEach(sides -> System.out.printf("%s%s", sides, this.sides.indexOf(sides) == this.sides.size() - 1 ? "\n" : ", "));
    }

    public String sandwichDetails() {
        return String.format(
                "Sandwich Size: %s\n%s\n%s\n%s\n%s\n%s\n%s",
                this.sandwichSize,
                formatList("Bread", this.bread),
                formatList("Meat Toppings", this.meatToppings),
                formatList("Cheese Toppings", this.cheeseToppings),
                formatList("Veggie Toppings", this.veggieToppings),
                formatList("Sauces", this.sauces),
                formatList("Sides", this.sides)
        );
    }

    private String formatList(String label, List<String> items) {
        return String.format("%s: %s", label, String.join(", ", items));
    }

    //Getters and Setters
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSize() {
        return sandwichSize;
    }

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

    public List<String> getVeggieToppings() {
        return veggieToppings;
    }

    public void setVeggieToppings(List<String> veggieToppings) {
        this.veggieToppings = veggieToppings;
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

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

}

