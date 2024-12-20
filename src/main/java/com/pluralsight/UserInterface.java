package com.pluralsight;

import com.pluralsight.products.Chip;
import com.pluralsight.products.Drink;
import com.pluralsight.products.Sandwich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInterface {
    static final Scanner keyboard = new Scanner(System.in);
    static String customerName = "";

    public static void setCustomerName(String name) {
        customerName = name;
        customerOrder.setCustomerName(name);
    }

    //Instantiate Objects that will be used to manage customer's orders
    public static List<Sandwich> sandwichOrder = new ArrayList<>();
    public static Order customerOrder = new Order(customerName);

    //Lists that will hold the ingredients for the sandwich
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
        meatToppings.add("n/a");

        cheeseToppings.add("american");
        cheeseToppings.add("provolone");
        cheeseToppings.add("cheddar");
        cheeseToppings.add("swiss");
        cheeseToppings.add("n/a");

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
        veggieToppings.add("n/a");


        sauces.add("mayo");
        sauces.add("mustard");
        sauces.add("ketchup");
        sauces.add("ranch");
        sauces.add("thousand islands");
        sauces.add("vinaigrette");
        sauces.add("n/a");


        sides.add("au jus");
        sides.add("sauce");
        sides.add("n/a");


    }

    public static void homeScreen() {
        System.out.print("""
                1 - New Order
                0 - Exit
                Please enter your selection:""");
    }

    public static void orderScreen() {
        while (true) {
            System.out.println("------------");
            System.out.println("ORDER SCREEN");
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
                    System.out.println("------------");
                    break;
                case 2:
                    processAddDrinkRequest();
                    System.out.println("------------");
                    break;
                case 3:
                    processAddChipRequest();
                    System.out.println("------------");
                    break;
                case 4:
                    processCheckoutRequest();
                    System.out.println("------------");
                    return;
                case 0:
                    return;
                default:
                    System.out.println("ERROR: INVALID OPTION. Please select an option from the order screen.");
            }
        }
    }

    public static void processAddSandwichRequest() {
        while (true) {
            //Bread input
            List<String> userBread = null;
            while (userBread == null) {
                System.out.println("The available bread options are: " + String.join(", ", bread));
                System.out.print("Please select the type of bread you want:");
                String breadInput = keyboard.nextLine().toLowerCase();

                if (bread.contains(breadInput)) {
                    userBread = List.of(breadInput);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("------------");

            //Meat topping input
            List<String> userMeatToppings = null;
            while (userMeatToppings == null) {
                System.out.println("Meat Toppings:");
                System.out.println("The available meat toppings options are: " + String.join(", ", meatToppings));
                System.out.print("Enter your desired toppings (separated by commas):");
                String meatResponse = keyboard.nextLine().toLowerCase();

                String[] selectedToppings = meatResponse.split(Pattern.quote(","));
                boolean valid = true;

                for (String topping : selectedToppings) {
                    if (!meatToppings.contains(topping)) {
                        valid = false;
                        System.out.println("Invalid Topping: " + topping);
                    }
                }

                if (valid) {
                    userMeatToppings = Arrays.asList(selectedToppings);
                }
            }
            System.out.println("------------");

            String userExtraMeat = null;
            if (!userMeatToppings.contains("n/a")) {
                while (userExtraMeat == null) {
                    System.out.print("Would you like extra meat? yes or no:");
                    String input = keyboard.nextLine().toLowerCase();
                    if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                        userExtraMeat = input;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                }
                System.out.println("------------");
            }

            //Cheese topping input
            List<String> userCheeseToppings = null;
            while (userCheeseToppings == null) {
                System.out.println("Cheese Toppings:");
                System.out.println("The available cheese toppings options are: " + String.join(", ", cheeseToppings));
                System.out.print("Enter your desired toppings (separated by commas):");
                String cheeseResponse = keyboard.nextLine().toLowerCase();

                String[] selectedToppings = cheeseResponse.split(Pattern.quote(","));
                boolean valid = true;

                for (String topping : selectedToppings) {
                    if (!cheeseToppings.contains(topping)) {
                        valid = false;
                        System.out.println("Invalid Topping: " + topping);
                    }
                }

                if (valid) {
                    userCheeseToppings = Arrays.asList(selectedToppings);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("------------");

            String userExtraCheese = null;
            if (!userCheeseToppings.contains("n/a")) {
                while (userExtraCheese == null) {
                    System.out.print("Would you like extra cheese? yes or no:");
                    String input = keyboard.nextLine().toLowerCase();
                    if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                        userExtraCheese = input;
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                }
                System.out.println("------------");
            }

            //Veggie topping input
            List<String> userVeggieToppings = null;
            while (userVeggieToppings == null) {
                System.out.println("Veggie Toppings:");
                System.out.println("The available veggie toppings options are: " + String.join(", ", veggieToppings));
                System.out.print("Enter your desired toppings (separated by commas):");
                String veggieResponse = keyboard.nextLine().toLowerCase();

                String[] selectedToppings = veggieResponse.split(Pattern.quote(","));
                boolean valid = true;

                for (String topping : selectedToppings) {
                    if (!veggieToppings.contains(topping)) {
                        valid = false;
                        System.out.println("Invalid Topping: " + topping);
                    }
                }

                if (valid) {
                    userVeggieToppings = Arrays.asList(selectedToppings);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("------------");

            //Sauce input
            List<String> userSauces = null;
            while (userSauces == null) {
                System.out.println("Sauces:");
                System.out.println("The available sauce options are: " + String.join(", ", sauces));
                System.out.print("Enter your desired sauces (separated by commas):");
                String sauceResponse = keyboard.nextLine().toLowerCase();

                String[] selectedToppings = sauceResponse.split(Pattern.quote(","));
                boolean valid = true;

                for (String topping : selectedToppings) {
                    if (!sauces.contains(topping)) {
                        valid = false;
                        System.out.println("Invalid Topping: " + topping);
                    }
                }

                if (valid) {
                    userSauces = Arrays.asList(selectedToppings);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("------------");

            //Sides input
            List<String> userSides = null;
            while (userSides == null) {
                System.out.println("Sides:");
                System.out.println("The available side options are: " + String.join(", ", sides));
                System.out.print("Enter your desired sauces (separated by commas):");
                String sidesResponse = keyboard.nextLine().toLowerCase();

                String[] selectedToppings = sidesResponse.split(Pattern.quote(","));
                boolean valid = true;

                for (String topping : selectedToppings) {
                    if (!sides.contains(topping)) {
                        valid = false;
                        System.out.println("Invalid Topping: " + topping);
                    }
                }

                if (valid) {
                    userSides = Arrays.asList(selectedToppings);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            System.out.println("------------");

            //Toasted input
            String userToastedResponse = null;
            while (userToastedResponse == null) {
                System.out.print("WWould you like your sandwich toasted? yes or no:");
                String input = keyboard.nextLine().toLowerCase();
                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                    userToastedResponse = input;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }
            System.out.println("------------");

            int sandwichSize = 0;
            while (sandwichSize == 0) {
                System.out.print("what size sandwich would you like to order? (4)inches, (8)inches, or  (12)inches:");
                int input = Integer.parseInt(keyboard.nextLine().toLowerCase());
                if (input == 4 || input == 8 || input == 12) {
                    sandwichSize = input;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }

            double priceSubtotal;

            //Switch statements controls the creation of the sandwich objects dependent on the user's selection
            switch (sandwichSize) {
                case 4, 8 , 12:
                    Sandwich sandwich = createSandwich(
                            sandwichSize,
                            userBread,
                            userMeatToppings,
                            userCheeseToppings,
                            userVeggieToppings,
                            userSauces,
                            userSides,
                            userToastedResponse,
                            userExtraMeat,
                            userExtraCheese
                    );

                    sandwichOrder.add(sandwich);
                    break;
            }

            //Prompt user for additional sandwich
            System.out.println("Your sandwich has been added to the cart");
            System.out.println("------------");
            System.out.print("Would you like to add another sandwich? yes or no:");
            String addAnother = keyboard.nextLine();

            if (!addAnother.equalsIgnoreCase("yes")) {
                if (addAnother.equalsIgnoreCase("no")) {
                    customerOrder.setSandwich(sandwichOrder);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
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
        System.out.println("Your drink has been added to the cart.");

    }

    public static void processAddChipRequest() {
        List<String> chipNames = List.of("Lays", "Doritos", "Pringles", "Ruffles", "Cheetos");

        System.out.println("Chip options: " + String.join(", ", chipNames));
        System.out.print("What bag of chips would you like?:");
        String chipChoice = keyboard.nextLine();

        Chip userChip = new Chip(chipChoice);

        customerOrder.setChips(userChip);
        System.out.println("Your chips has been added to the cart.");
    }

    public static void processCheckoutRequest() {
        // Display the order summary
        System.out.println("Order Summary:");

        // Display sandwiches
        if (customerOrder.getSandwich() != null && !customerOrder.getSandwich().isEmpty()) {
            System.out.println("Sandwiches:");
            System.out.println("------------");
            int count = 1;
            for (Sandwich sandwich : customerOrder.getSandwich()) {
                if (customerOrder.getSandwich().size() > 1) {
                    System.out.println("Sandwich #" + count++);
                }

                sandwich.printSandwichDetails();
                System.out.println(sandwich.isExtraMeat() ? "Extra Meat: Yes" : "Extra Meat: No");
                System.out.println(sandwich.isExtraCheese() ? "Extra Cheese: Yes" : "Extra Cheese: No");
                System.out.println(sandwich.isToasted() ? "Toasted: Yes" : "Toasted: No");
            }
        }

        // Display drink
        if (customerOrder.getDrink() != null) {
            System.out.println("------------");
            System.out.println("Drink:");
            System.out.println(customerOrder.getDrink().getName());
        }

        // Display chips
        if (customerOrder.getChips() != null) {
            System.out.println("------------");
            System.out.println("Chips:");
            System.out.println(customerOrder.getChips().getName());
        }

        // Calculate total price
        System.out.println("------------");
        System.out.println("Total Price: $" + customerOrder.totalPrice());

        // Prompt for confirmation
        System.out.print("Would you like to confirm your order? (yes or no): ");
        String confirm = keyboard.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            FileManager.createReceipt(customerOrder);
            System.out.println("Thank you for your order!");
        } else {
            //Clear customer order
            customerOrder.clearOrder();
            sandwichOrder.clear();

            System.out.println("Order canceled.");
        }
    }

    private  static Sandwich createSandwich(int sandwichSize, List<String> userBread, List<String> userMeatToppings,
                                    List<String> userCheeseToppings, List<String> userVeggieToppings,
                                    List<String> userSauces, List<String> userSides,
                                    String userToastedResponse, String userExtraMeat,
                                    String userExtraCheese) {

        String sizeString = sandwichSize + " Inches";
        Sandwich sandwich = new Sandwich(userBread, userMeatToppings, userCheeseToppings, userVeggieToppings, userSauces, userSides);
        sandwich.setSandwichSize(sizeString);

        sandwich.setToasted(userToastedResponse.equalsIgnoreCase("yes"));
        sandwich.setExtraMeat(userExtraMeat != null && userExtraMeat.equalsIgnoreCase("yes"));
        sandwich.setExtraCheese(userExtraCheese != null && userExtraCheese.equalsIgnoreCase("yes"));

        double basePrice = 0, meatPrice = 0, cheesePrice = 0;

        switch (sandwichSize) {
            case 4:
                basePrice = 5.50;
                meatPrice = 1.00;
                cheesePrice = 0.75;
                break;
            case 8:
                basePrice = 7.00;
                meatPrice = 2.00;
                cheesePrice = 1.50;
                break;
            case 12:
                basePrice = 8.50;
                meatPrice = 3.00;
                cheesePrice = 2.25;
                break;
            default:
                System.out.println("Invalid sandwich size");
        }

        double priceSubtotal = basePrice;

        if (!userMeatToppings.contains("n/a")) {
            priceSubtotal += !userMeatToppings.isEmpty() ? meatPrice : 0;
        }
        if (!userCheeseToppings.contains("n/a")) {
            priceSubtotal += !userCheeseToppings.isEmpty() ? cheesePrice : 0;
        }

        sandwich.setPrice(priceSubtotal);

        return sandwich;
    }
}
