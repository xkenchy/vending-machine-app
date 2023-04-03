package com.techelevator;

import com.techelevator.productclasses.Chip;
import org.junit.Assert;
import org.junit.Test;

public class ChipTest {









    @Test
    public void doesReturnSound(){

        Chip chip = new Chip();
        String result = chip.getSound();

        Assert.assertEquals("Crunch Crunch, Yum!",result);


    }


}
