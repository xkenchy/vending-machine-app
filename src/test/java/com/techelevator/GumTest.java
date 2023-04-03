package com.techelevator;

import com.techelevator.productclasses.Chip;
import com.techelevator.productclasses.Gum;
import org.junit.Assert;
import org.junit.Test;

public class GumTest {








    @Test
    public void doesReturnSound() {

        Gum fakeGum = new Gum();
        String result = fakeGum.getSound();

        Assert.assertEquals("Chew Chew, Yum!", result);

    }
}