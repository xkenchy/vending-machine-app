package com.techelevator;

import com.techelevator.productclasses.Candy;
import com.techelevator.productclasses.Chip;
import org.junit.Assert;
import org.junit.Test;

public class CandyTest {






    @Test
    public void doesReturnSound() {

        Candy fakeCandy = new Candy();

        String result = fakeCandy.getSound();

        Assert.assertEquals("Munch Munch, Yum!", result);

    }
}


