package com.pluralsight;


import com.pluralsight.products.Sandwich;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

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
        String fileName = String.format("src/main/resources/%s-%s.txt", date, time);

        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(fileName));

            String allSandwichDetails = customerorder.getSandwich()
                    .stream()
                    .map(Sandwich::sandwichDetails)
                    .collect(Collectors.joining("\n\n"));




                bufWriter.write(allSandwichDetails);

            //Release file
            bufWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

