package com.techelevator;

import com.techelevator.productclasses.Chip;
import com.techelevator.productclasses.Drink;
import org.junit.Assert;
import org.junit.Test;

public class DrinkTest {






    @Test
    public void doesReturnSound() {

        Drink fakeDrink = new Drink();
        String result = fakeDrink.getSound();

        Assert.assertEquals("Glug Glug, Yum!", result);

    }


}
