package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to The Deli Den!");
        System.out.print("What is your name?:");
        String customerName = keyboard.nextLine().trim();
        UserInterface.setCustomerName(customerName);

        while (true) {

            UserInterface.homeScreen();
            int userInput = Integer.parseInt(keyboard.nextLine());

            switch (userInput) {
                case 1:
                    UserInterface.orderScreen();
                    break;
                case 0:
                    System.out.printf("Thank you for stopping by, %s!", UserInterface.customerName);
                    System.exit(0);
                default:
                    System.out.println("ERROR: INVALID OPTION. Please select an option from the home screen.");
            }
        }
    }
}
