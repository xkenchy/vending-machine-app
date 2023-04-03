package com.techelevator;

import com.techelevator.productclasses.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Objects;

public class VendingMachine {

    File log = new File("log.txt");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
    LocalDateTime timeNow = LocalDateTime.now();


    private BigDecimal balance = BigDecimal.valueOf(0);

    public VendingMachine() throws FileNotFoundException {
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachine that = (VendingMachine) o;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    public BigDecimal addValue(BigDecimal userInput) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))) {

            if (userInput.compareTo(new BigDecimal("0")) > 0) {
                balance = balance.add(userInput);
                writer.println((timeNow.format(formatter) + " FEED MONEY: $" + userInput.setScale(2) + " $" + balance.setScale(2)));
                return balance;
            }
            System.out.println("Added Value Needs To Be Greater Than $0.00");
            return balance;

        }
    }



    public BigDecimal subtractValue(BigDecimal productPrice, String productName, String productLocation) throws FileNotFoundException{
       
        balance =  balance.subtract(productPrice);
       try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))){
            writer.println(timeNow.format(formatter)+ " " + productName + " " + productLocation + " $" + productPrice.setScale(2) + " $" + balance.setScale(2));
        } return balance;
    }


    public BigDecimal giveChange() throws FileNotFoundException {
        BigDecimal zero = new BigDecimal("0");

        BigDecimal totalChange = balance;
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickle = new BigDecimal("0.05");
        BigDecimal remainder = new BigDecimal("0");

        BigDecimal quarterCount = new BigDecimal("0") ;
        BigDecimal dimeCount = new BigDecimal("0") ;
        BigDecimal nickelCount = new BigDecimal("0") ;

        System.out.println("Your change is $" + totalChange);

        if (balance.compareTo(zero) > 0 ) {

            remainder = balance.remainder(quarter);
            quarterCount = (balance.subtract(remainder)).divide(quarter);
            System.out.print(quarterCount + " quarter(s), ");
            balance = remainder;

            if (balance.compareTo(zero) > 0) {

                remainder = balance.remainder(dime);
                dimeCount = (balance.subtract(remainder)).divide(dime);
                System.out.print(dimeCount + " dime(s), ");
                balance = remainder;

                if (balance.compareTo(zero) > 0) {

                    remainder = balance.remainder(nickle);
                    nickelCount = (balance.subtract(remainder)).divide(nickle);
                    System.out.print(nickelCount + " nickle(s).");

                }
                balance = balance.subtract(balance);

            }

        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(log, true))){
            writer.println(timeNow.format(formatter) + " GIVE CHANGE: $" + totalChange.setScale(2) + " $" + balance.setScale(2));
        }
        return balance;
    }
}
