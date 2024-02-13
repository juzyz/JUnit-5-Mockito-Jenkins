package com.junit.juzyz.assumptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

public class AssumeFalse {

    @Test
    public void assumeFalseWithoutMessage() {
        assumeFalse("DEV".equals(System.getProperty("ENV")));
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }

    @Test
    public void assumeFalseWithMessage() {   //skipped
        System.setProperty("ENV", "DEV");
        assumeFalse("DEV".equals(System.getProperty("ENV")), "Assumption Failed"); //failed -> System.getProperty("ENV") == "DEV"
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }

    @Test
    public void assumeFalseWithSupplierMessage() {    //skipped
        System.setProperty("ENV", "DEV");
        assumeFalse("DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed"); //failed -> System.getProperty("ENV") == "DEV"
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }
}
