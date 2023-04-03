package com.techelevator;

import com.techelevator.productclasses.Chip;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineTest {



    VendingMachine testVend = new VendingMachine();


    public VendingMachineTest() throws FileNotFoundException {
    }

    @Test
    public void addValue_validData_ShouldReturnEqual() throws FileNotFoundException {

        BigDecimal testValue = new BigDecimal("3.30");
        BigDecimal userTestValue = new BigDecimal("3.30");

        Assert.assertEquals(testValue, testVend.addValue(userTestValue));
    }

    @Test
    public void addValue_badData_ShouldReturnUnchangedBalance() throws FileNotFoundException {
        BigDecimal expectedBalance = new BigDecimal("0");
        BigDecimal negativeFeed = new BigDecimal("-5.00");

        Assert.assertEquals(expectedBalance, testVend.addValue(negativeFeed));
    }


    
}
