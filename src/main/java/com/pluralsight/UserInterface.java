package com.pluralsight;

import com.pluralsight.products.EightInchSandwich;
import com.pluralsight.products.FourInchSandwich;
import com.pluralsight.products.Sandwich;
import com.pluralsight.products.TwelveInchSandwich;

import java.util.*;
import java.util.regex.Pattern;

public class UserInterface {
    static final Scanner keyboard = new Scanner(System.in);

    public static List<Sandwich> sandwichOrder = new ArrayList<>();
    public static Order customerOrder = new Order(sandwichOrder, processAddDrinkRequest(), "Chips");

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

    public static void homeScreen() {
        System.out.print("""
                1 - Find vehicles within a price range
                0 - Exit
                Please enter your selection:""");
    }

    public static void orderScreen() {
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
                break;
            case 3:
                break;
            case 4:
                break;
            case 0:
                break;
        }



    }

    public static void processAddSandwichRequest() {
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

        //cheese topping input
        System.out.println("Cheese Toppings:");
        System.out.println("The available cheese toppings options are: " + String.join(", ", cheeseToppings));
        System.out.print("Enter your desired toppings (separated by commas):");
        String cheeseResponse = keyboard.nextLine().toLowerCase();
        List<String> userCheeseToppings = Arrays.asList(cheeseResponse.split(Pattern.quote(",")));

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
                FourInchSandwich fourInchSandwich = new FourInchSandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                if (userToastedResponse.equalsIgnoreCase("yes")) {
                    fourInchSandwich.setToasted(true);
                }
                sandwichOrder.add(fourInchSandwich);
            case 8:
                EightInchSandwich eightInchSandwich = new EightInchSandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                if (userToastedResponse.equalsIgnoreCase("yes")) {
                    eightInchSandwich.setToasted(true);
                }
                sandwichOrder.add(eightInchSandwich);
            case 12:
                TwelveInchSandwich twelveInchSandwich = new TwelveInchSandwich(userBread, userMeatToppings, userCheeseToppings, userSauces, userVeggieToppings, userSides);
                if (userToastedResponse.equalsIgnoreCase("yes")) {
                    twelveInchSandwich.setToasted(true);
                }
                sandwichOrder.add(twelveInchSandwich);

        }
    }

    public static String  processAddDrinkRequest() {
        System.out.println("Drink Sizes: Small, Medium, or Large");
        System.out.print("What size of drink would you like?:");
        String drinkSize = keyboard.nextLine();

        System.out.println("Drink Flavors: Coca-Cola, Sprite, Dr. Pepper, Water,  or Sweet Tea");
        System.out.print("What flavor of drink would you like?:");
        String drinkFlavor = keyboard.nextLine();

        return String.format("%s %s", drinkSize, drinkFlavor);
    }

}
