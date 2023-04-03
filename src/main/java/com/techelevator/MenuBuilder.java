package com.techelevator;

import com.techelevator.productclasses.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class MenuBuilder {



    //Display main menu
    public void displayMainMenu(Scanner userInput, VendingMachine vendingMachine, InventoryClass inventoryClass,Map<String,Product> map) throws FileNotFoundException {

        System.out.println("");
        System.out.println("");
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");

        String userSelection = userInput.nextLine();

        switch (userSelection) {
            case "1":
                inventoryClass.printInventory(map);
                displayMainMenu(userInput, vendingMachine, inventoryClass, map);

            case "2":
                displayPurchaseMenu(userInput, vendingMachine, inventoryClass, map);

            case "3":
                System.exit(1);

            default:
                System.out.println("Please enter a valid selection");
                displayMainMenu(userInput, vendingMachine, inventoryClass, map);

        }
    }

        //    PURCHASE MENU
        public void displayPurchaseMenu(Scanner userInput, VendingMachine vendingMachine, InventoryClass inventoryClass,
             Map<String,Product> map) throws FileNotFoundException {


            System.out.println("Current Money Provided: $" + vendingMachine.getBalance());
            System.out.println(" ");
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");

            String userSelection = userInput.nextLine();


            switch (userSelection) {
                case "1":
                    System.out.print("How much are you adding?  ");
                    String feedMoney = userInput.nextLine();
                    try {
                        BigDecimal moneyAdded = new BigDecimal(feedMoney);
                        vendingMachine.addValue(moneyAdded);
                        System.out.println("");
                        System.out.println("");
                        displayPurchaseMenu(userInput, vendingMachine, inventoryClass, map);
                    } catch (NumberFormatException wrong) {
                        System.out.println("Please Enter A Valid Amount");
                    }
                    System.out.println("");
                    System.out.println("");
                    displayPurchaseMenu(userInput,vendingMachine, inventoryClass, map);

                case "2":
                    for(Map.Entry<String, Product> entry : map.entrySet()){
                        Product value = entry.getValue();
                        System.out.print(value);
                    }

                    System.out.println("");
                    System.out.print("Select product code ");
                    String selectedCode = userInput.nextLine();
                    System.out.println("");
                    System.out.println("");
                    try {
                        if(map.get(selectedCode).getStock() == 0){
                            System.out.println("SOLD OUT");
                            System.out.println("");
                            System.out.println("");
                            displayPurchaseMenu(userInput, vendingMachine, inventoryClass, map);
                        }
                        if (map.get(selectedCode).getPrice().compareTo(vendingMachine.getBalance())> 0){
                            System.out.println("Insufficient Funds");
                            System.out.println("");
                            System.out.println("");
                            displayPurchaseMenu(userInput,vendingMachine,inventoryClass,map);
                        }
                        map.get(selectedCode).sellStock();
                        vendingMachine.subtractValue(map.get(selectedCode).getPrice(), map.get(selectedCode).getName(), map.get(selectedCode).getLocation());
                        System.out.println(map.get(selectedCode).getSound());
                        displayPurchaseMenu(userInput, vendingMachine, inventoryClass, map);
                    } catch(NullPointerException b){
                        System.out.println("Invalid Selection");
                        System.out.println("");
                        System.out.println("");
                        displayPurchaseMenu(userInput,vendingMachine,inventoryClass,map);
                    }

                case "3":
                    vendingMachine.giveChange();
                    displayMainMenu(userInput, vendingMachine, inventoryClass, map);

                default:
                    System.out.println("Please enter a valid selection");
                    displayPurchaseMenu(userInput, vendingMachine, inventoryClass, map);

            }


        }




    }




