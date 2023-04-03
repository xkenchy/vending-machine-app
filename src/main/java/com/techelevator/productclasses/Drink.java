package com.techelevator.productclasses;

import java.math.BigDecimal;

public class Drink extends Product{


    public Drink(){

    }

    public Drink (String name, BigDecimal price, String location, String type){
        super(name, price, location, type);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
