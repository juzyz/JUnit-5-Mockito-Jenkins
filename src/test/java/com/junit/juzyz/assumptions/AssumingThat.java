package com.junit.juzyz.assumptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumingThat {
    @Test
    public void AssumingThatWithBooleanCondition() {
//        System.setProperty("ENV", "DEV"); // or -DENV=DEV
        System.out.println("Current ENV is " + System.getProperty("ENV"));
        assumingThat("DEV".equals(System.getProperty("ENV")), () -> {
            System.out.println("Dev environment !!!");
            assertEquals(5, 3+2);
        });
        //below code gets executed in any environment
        System.out.println("Executed in any environment.");
        assertEquals(3, 2+1);
    }

    @Test
    public void AssumingThatWithBooleanSupplier() {
//        System.setProperty("ENV", "DEV"); // or -DENV=DEV
        System.out.println("Current ENV is " + System.getProperty("ENV"));
        assumingThat(() -> "DEV".equals(System.getProperty("ENV")), () -> {
            System.out.println("Dev environment !!!");
            assertEquals(5, 3+2);
        });
        //below code gets executed in any environment
        System.out.println("Executed in any environment.");
        assertEquals(3, 2+1);
    }
}
