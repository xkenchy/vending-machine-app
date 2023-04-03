package com.techelevator.productclasses;

import java.math.BigDecimal;

public class Gum extends Product {


    //CONSTRUCTORS

    public Gum() {
    }

    public Gum(String name, BigDecimal price, String location, String type) {
        super(name, price, location, type);
    }


    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }

}
