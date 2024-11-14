package com.pluralsight;


import com.pluralsight.products.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    //This file will control the buffer writer that will write the receipts for the customer orders

    public static void createReceipt(Order customerorder) {

        //Format date and time
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        //Obtain date and time, then implement into file path
        LocalDateTime today = LocalDateTime.now();
        String date = today.format(formattedDate);
        String time = today.format(formattedTime);
        String filePath = String.format("src/main/resources/%s-%s.txt", date, time);

        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(filePath));

            bufWriter.write("=== ORDER RECEIPT ===\n");
            bufWriter.write("Date: "+ date + "\n");
            bufWriter.write("Time: "+ time + "\n");
            bufWriter.write("Customer: " + customerorder.getCustomerName() + "\n");

            bufWriter.write("=== ORDER DETAILS ===\n");

            //Sandwich details
            if (customerorder.getSandwich() != null) {
                bufWriter.write("SANDWICHES:\n");
                for (Sandwich sandwich : customerorder.getSandwich()) {
                    bufWriter.write(sandwich.sandwichDetails() + "\n");

                    bufWriter.write(sandwich.isExtraMeat() ? "Extra Meat: Yes\n" : "Extra Meat: No\n");

                    bufWriter.write(sandwich.isExtraCheese() ? "Extra Cheese: Yes\n" : "Extra Cheese: No\n");

                    bufWriter.write(sandwich.isToasted() ? "Toasted: Yes\n" : "Toasted: No\n");

                    bufWriter.write(String.format("\nPrice: $%.2f", sandwich.getPrice()));
                    bufWriter.write("\n----------------\n");
                }
            }

            //Drink details
            if (customerorder.getDrink() != null) {
                bufWriter.write("DRINKS:\n");
                bufWriter.write(customerorder.getDrink().getName() + "\n");
                bufWriter.write("Price: $" + customerorder.getDrink().getPrice());
                bufWriter.write("\n----------------\n");
            }

            //Chip details
            if (customerorder.getChips() != null) {
                bufWriter.write("CHIPS:\n");
                bufWriter.write(customerorder.getChips().getName()+ "\n");
                bufWriter.write("Price: $" + customerorder.getChips().getPrice());
                bufWriter.write("\n----------------\n");
            }


            bufWriter.write("\nTOTAL PRICE: " + String.format("$%.2f\n", customerorder.totalPrice()));
            bufWriter.write("=== THANK YOU FOR YOUR ORDER ===\n");

            //Release file
            bufWriter.close();

            System.out.println("Receipt created at: " + filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

