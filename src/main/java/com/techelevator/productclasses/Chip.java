package com.techelevator.productclasses;

import java.math.BigDecimal;

public class Chip extends Product {

    //INSTANCE VARIABLES;

    //CONSTRUCTORS

    public Chip(){
    }



    public Chip (String name, BigDecimal price, String location, String type){
        super(name, price, location, type);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}