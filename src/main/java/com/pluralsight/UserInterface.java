package com.pluralsight;

import com.pluralsight.products.Chip;
import com.pluralsight.products.Drink;
import com.pluralsight.products.Sandwich;

import java.util.*;
import java.util.regex.Pattern;

public class UserInterface {
    static final Scanner keyboard = new Scanner(System.in);
    static String customerName = "";

    public static List<Sandwich> sandwichOrder = new ArrayList<>();
    public static Order customerOrder = new Order(customerName);

    public static List<String> bread = new ArrayList<>();
    public static List<String> meatToppings = new ArrayList<>();
    public static List<String> cheeseToppings = new ArrayList<>();
    public static List<String> veggieToppings = new ArrayList<>();
    public static List<String> sauces = new ArrayList<>();
    public static List<String> sides = new ArrayList<>();

    //Add sandwich options into lists
    static {
        bread.add("white");
        bread.add("wheat");
        bread.add("rye");
        bread.add("wrap");

        meatToppings.add("steak");
        meatToppings.add("ham");
        meatToppings.add("salami");
        meatToppings.add("roast beef");
        meatToppings.add("chicken");
        meatToppings.add("bacon");

        cheeseToppings.add("american");
        cheeseToppings.add("provolone");
        cheeseToppings.add("cheddar");
        cheeseToppings.add("swiss");

        veggieToppings.add("lettuce");
        veggieToppings.add("peppers");
        veggieToppings.add("onions");
        veggieToppings.add("tomatoes");
        veggieToppings.add("jalapenos");
        veggieToppings.add("cucumbers");
        veggieToppings.add("pickles");
        veggieToppings.add("guacamole");
        veggieToppings.add("guacamole");
        veggieToppings.add("mushrooms");

        sauces.add("mayo");
        sauces.add("mustard");
        sauces.add("ketchup");
        sauces.add("ranch");
        sauces.add("thousand islands");
        sauces.add("vinaigrette");

        sides.add("au jus");
        sides.add("sauce");


    }

    public static void getCustomerName(String name) {
        customerName = name;
    }

    public static void homeScreen() {
        System.out.print("""
                1 - New Order
                0 - Exit
                Please enter your selection:""");
    }

    public static void orderScreen() {
        while (true) {
            System.out.print("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order - This will return to home screen
                    
                    Please enter your selection:""");
            int userInput = Integer.parseInt(keyboard.nextLine());

            switch (userInput) {
                case 1:
                    processAddSandwichRequest();
                    break;
                case 2:
                    processAddDrinkRequest();
                    break;
                case 3:
                    processAddChipRequest();
                    break;
                case 4:
                    break;
                case 0:
                    break;
            }
        }


    }

    public static void processAddSandwichRequest() {
        while (true) {
            double priceSubtotal = 0;

            //bread input
            System.out.println("The available bread options are: " + String.join(", ", bread));
            System.out.print("Please select the type of bread you want:");
            List<String> userBread = Collections.singletonList(keyboard.nextLine().toLowerCase());

            //meat topping input
            System.out.println("Meat Toppings:");
            System.out.println("The available meat toppings options are: " + String.join(", ", meatToppings));
            System.out.print("Enter your desired toppings (separated by commas):");
            String meatResponse = keyboard.nextLine().toLowerCase();
            List<String> userMeatToppings = Arrays.asList(meatResponse.split(Pattern.quote(",")));

            System.out.print("Would you like extra meat? yes or no:");
            String userExtraMeat = keyboard.nextLine();

            //cheese topping input
            System.out.println("Cheese Toppings:");
            System.out.println("The available cheese toppings options are: " + String.join(", ", cheeseToppings));
            System.out.print("Enter your desired toppings (separated by commas):");
            String cheeseResponse = keyboard.nextLine().toLowerCase();
            List<String> userCheeseToppings = Arrays.asList(cheeseResponse.split(Pattern.quote(",")));

            System.out.print("Would you like extra cheese? yes or no:");
            String userExtraCheese = keyboard.nextLine();

            //Veggie topping input
            System.out.println("Cheese Toppings:");
            System.out.println("The available cheese toppings options are: " + String.join(", ", veggieToppings));
            System.out.print("Enter your desired toppings (separated by commas):");
            String veggieResponse = keyboard.nextLine().toLowerCase();
            List<String> userVeggieToppings = Arrays.asList(veggieResponse.split(Pattern.quote(",")));

            //Sauce input
            System.out.println("Sauces:");
            System.out.println("The available cheese toppings options are: " + String.join(", ", sauces));
            System.out.print("Enter your desired sauces (separated by commas):");
            String sauceResponse = keyboard.nextLine().toLowerCase();
            List<String> userSauces = Arrays.asList(sauceResponse.split(Pattern.quote(",")));

            //Sides input
            System.out.println("Sauces:");
            System.out.println("The available cheese toppings options are: " + String.join(", ", sides));
            System.out.print("Enter your desired sauces (separated by commas):");
            String sidesResponse = keyboard.nextLine().toLowerCase();
            List<String> userSides = Arrays.asList(sauceResponse.split(Pattern.quote(",")));

            //Toasted input
            System.out.print("Would you like your sandwich toasted? yes or no:");
            String userToastedResponse = keyboard.nextLine();

            System.out.println("what size sandwich would you like to order? (4)inches, (8)inches, or  (12)inches: ");
            int sandwichSize = Integer.parseInt(keyboard.nextLine().toLowerCase());

            switch (sandwichSize) {
                case 4:
                    Sandwich fourInchSandwich = new Sandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                    fourInchSandwich.setSandwichSize("4 Inches");

                    fourInchSandwich.setToasted(userToastedResponse.equalsIgnoreCase("yes"));
                    fourInchSandwich.setExtraMeat(userExtraMeat.equalsIgnoreCase("yes"));
                    fourInchSandwich.setExtraCheese(userExtraCheese.equalsIgnoreCase("yes"));

                    priceSubtotal = 5.50;

                    priceSubtotal += !userMeatToppings.isEmpty() ? 1.00 : 0;
                    priceSubtotal += !userCheeseToppings.isEmpty() ? 0.75 : 0;

                    fourInchSandwich.setPrice(priceSubtotal);

                    sandwichOrder.add(fourInchSandwich);
                case 8:
                    Sandwich eightInchSandwich = new Sandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                    eightInchSandwich.setSandwichSize("8 Inches");

                    eightInchSandwich.setToasted(userToastedResponse.equalsIgnoreCase("yes"));
                    eightInchSandwich.setExtraMeat(userExtraMeat.equalsIgnoreCase("yes"));
                    eightInchSandwich.setExtraCheese(userExtraCheese.equalsIgnoreCase("yes"));

                    priceSubtotal = 7.00;

                    priceSubtotal += !userMeatToppings.isEmpty() ? 2.00 : 0;
                    priceSubtotal += !userCheeseToppings.isEmpty() ? 1.50 : 0;

                    eightInchSandwich.setPrice(priceSubtotal);

                    sandwichOrder.add(eightInchSandwich);
                case 12:
                    Sandwich twelveInchSandwich = new Sandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                    twelveInchSandwich.setSandwichSize("12 Inches");

                    twelveInchSandwich.setToasted(userToastedResponse.equalsIgnoreCase("yes"));
                    twelveInchSandwich.setExtraMeat(userExtraMeat.equalsIgnoreCase("yes"));
                    twelveInchSandwich.setExtraCheese(userExtraCheese.equalsIgnoreCase("yes"));

                    priceSubtotal = 8.50;

                    priceSubtotal += !userMeatToppings.isEmpty() ? 3.00 : 0;
                    priceSubtotal += !userCheeseToppings.isEmpty() ? 2.25 : 0;

                    twelveInchSandwich.setPrice(priceSubtotal);

                    sandwichOrder.add(twelveInchSandwich);

            }
            System.out.print("Would you like to add another sandwich? yes or no:");
            String addAnother = keyboard.nextLine();

            if (addAnother.equalsIgnoreCase("yes")) {
                return;
            } else {
                break;
            }
        }
    }

    public static void processAddDrinkRequest() {
        List<String> drinkFlavors = List.of("Coca-Cola", "Sprite", "Dr. Pepper", "Water", "Sweet Tea");

        System.out.println("Drink Sizes: Small, Medium, or Large");
        System.out.print("What size of drink would you like?:");
        String drinkSize = keyboard.nextLine().toLowerCase();

        System.out.println("Drink Flavors: " + String.join(", ", drinkFlavors));
        System.out.print("What flavor of drink would you like?:");
        String drinkChoice = keyboard.nextLine().toLowerCase();

        Drink userDrink = new Drink(drinkChoice, drinkSize);

        customerOrder.setDrink(userDrink);
    }

    public static void processAddChipRequest() {
        List<String> chipNames = List.of("Lays", "Doritos", "Pringles", "Ruffles", "Cheetos");

        System.out.println("Chip options: " + String.join(", ", chipNames));
        System.out.print("What bag of chips would you like?:");
        String chipChoice = keyboard.nextLine();

        Chip userChip = new Chip(chipChoice);

        customerOrder.setChips(userChip);

    }

    public static void processCheckoutRequest() {

    }

}
