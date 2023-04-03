package com.techelevator;

import com.techelevator.productclasses.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class InventoryClass {

    //    Read text file
//    line line make an array
//    create an object based on the indexes
//    add name and stock to inventory
    Map<String, Product> productMap = new TreeMap<>();

    public Map<String,Product> createMap() {

        File vendingOptions = new File("vendingmachine.csv");
//        Map<String, Product> productMap = new TreeMap<>();

        try (Scanner reader = new Scanner(vendingOptions)) {
            String currentLine;

            while (reader.hasNextLine()) {
                currentLine = reader.nextLine();
                String[] productArray = currentLine.split("\\|");

                if (productArray[3].equals("Chip")) {

                    String curKey = productArray[0];
                    Product curValue = new Chip(productArray[1], new BigDecimal(productArray[2]), productArray[0], productArray[3]);

                    productMap.put(curKey, curValue);
                } else if (productArray[3].equals("Candy")) {

                    String curKey = productArray[0];
                    Product curValue = new Candy(productArray[1], new BigDecimal(productArray[2]), productArray[0], productArray[3]);

                    productMap.put(curKey, curValue);
                } else if (productArray[3].equals("Drink")) {

                    String curKey = productArray[0];
                    Product curValue = new Drink(productArray[1], new BigDecimal(productArray[2]), productArray[0], productArray[3]);

                    productMap.put(curKey, curValue);
                } else if (productArray[3].equals("Gum")) {

                    String curKey = productArray[0];
                    Product curValue = new Gum(productArray[1], new BigDecimal(productArray[2]), productArray[0], productArray[3]);

                    productMap.put(curKey, curValue);
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry your file wasn't found");
        }
        return productMap;
    }

    public void printInventory(Map map){

        for(Map.Entry<String, Product> entry : productMap.entrySet()){
            Product value = entry.getValue();
            System.out.print(value);

        }
    }
}
