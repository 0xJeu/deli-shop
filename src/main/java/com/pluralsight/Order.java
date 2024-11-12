package com.pluralsight;

import com.pluralsight.products.Chip;
import com.pluralsight.products.Drink;
import com.pluralsight.products.Sandwich;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private List<Sandwich> sandwich;
    private String customerName;
    Drink drink;
    Chip chips;
    private String dateTime;

    //Constructors
    public Order(String customerName) {
        this.customerName = customerName;
        this.drink = getDrink();
        this.chips = getChips();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Order(String customerName, List<Sandwich> sandwich, Drink drink, Chip chips) {
        this.sandwich = sandwich;
        this.customerName = customerName;
        this.drink = drink;
        this.chips = chips;
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public double totalPrice() {
        double totalPrice = 0;

        // Calculate sandwich subtotal, skipping any null sandwiches
        if (sandwich != null) {
            totalPrice += sandwich.stream()
                    .mapToDouble(Sandwich::getPrice)
                    .sum();
        }

        // Add drink price if not null
        if (drink != null) {
            totalPrice += drink.getPrice();
        }

        // Add chips price if not null
        if (chips != null) {
            totalPrice += chips.getPrice();
        }

        return totalPrice;
    }

    //Getters and Setters
    public List<Sandwich> getSandwich() {
        return sandwich;
    }

    public void setSandwich(List<Sandwich> sandwich) {
        this.sandwich = sandwich;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Chip getChips() {
        return chips;
    }

    public void setChips(Chip chips) {
        this.chips = chips;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
