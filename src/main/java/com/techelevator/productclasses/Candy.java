package com.techelevator.productclasses;

import java.math.BigDecimal;

public class Candy extends Product {


    //INSTANCE VARIABLES


    //CONSTRUCTORS

    public Candy(){

    }

    public Candy (String name, BigDecimal price, String location, String type){
        super(name, price, location, type);
    }

    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }







}


