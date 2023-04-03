package com.techelevator.productclasses;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {

//Constant Variables
    final int FULL = 5;

//Instance Variables
    private String name;
    private BigDecimal price;
    private String location;
    private String type;
    private int stock = FULL;

//Constructors
    public Product() {

    }

    public Product(String name, BigDecimal price, String location, String type) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.type = type;
    }

//Getters
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public int getStock() {
        return stock;
    }

    public abstract String getSound();


    public void sellStock() {
        this.stock = stock - 1;
    }

    @Override
    public String toString() {
        return location+ ": "+ name + " $" + getPrice() + " "+ getStock() + "/5"+"\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock == product.stock && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(location, product.location) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, location, type, stock);
    }
}