package com.techelevator;

import com.techelevator.productclasses.Chip;
import com.techelevator.productclasses.Drink;
import com.techelevator.productclasses.Gum;
import com.techelevator.productclasses.Product;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class InventoryClassTest {

    InventoryClass inventoryClass = new InventoryClass();

    BigDecimal expectedPrice = new BigDecimal("3.05");
    BigDecimal drinkExpectedPrice = new BigDecimal("1.25");
    BigDecimal gumExpectedPrice = new BigDecimal("0.75");

    Chip expectedChip = new Chip("Potato Crips", expectedPrice, "A1", "Chip");
    Drink expectedDrink = new Drink("Cola", drinkExpectedPrice, "C1", "Drink");
    Gum expectedGum = new Gum("Triplemint", gumExpectedPrice, "D4", "Gum");

    Map<String, Product> expectedMap = new TreeMap<>();



    @Test
    public void createMap_validDate_sizeShould_beEqual() {


        expectedMap.put("A1", expectedChip);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", expectedDrink);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);
        expectedMap.put("D1", null);
        expectedMap.put("D2", null);
        expectedMap.put("D3", null);
        expectedMap.put("D4", expectedGum);


        Assert.assertEquals(expectedMap.size(), inventoryClass.createMap().size());

    }


    @Test
    public void createMap_keyValueAccurate(){

        expectedMap.put("D4", expectedGum);
        Assert.assertEquals(expectedMap.get("D4"), inventoryClass.createMap().get("D4"));
    }




}
