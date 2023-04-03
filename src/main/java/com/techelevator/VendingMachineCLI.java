package com.techelevator;

import com.techelevator.productclasses.Product;
import com.techelevator.util.ConsoleUtility;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	// Use this for keyboard input - it is initialized in the constructor
	private Scanner userInput;

	public VendingMachineCLI(Scanner userInput) {
		this.userInput = userInput;
	}

	public void run() throws FileNotFoundException {

		File log = new File("log.txt");
		InventoryClass inventoryClass = new InventoryClass();
		VendingMachine vendingMachine = new VendingMachine();
		MenuBuilder menuBuilder = new MenuBuilder();
		Map<String, Product> menuMap = inventoryClass.createMap();

		menuBuilder.displayMainMenu(userInput, vendingMachine, inventoryClass, menuMap);
		}



			// Add a loop here for your menu



	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		VendingMachineCLI cli = new VendingMachineCLI(input);
		cli.run();
	}
}




