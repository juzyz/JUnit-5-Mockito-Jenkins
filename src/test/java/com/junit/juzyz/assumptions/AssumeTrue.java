package com.junit.juzyz.assumptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumeTrue {

    @Test
    public void assumeTrueWithoutMessage() {
        assumeTrue("18.0.2".equals(System.getProperty("java.version")));
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }

    @Test
    public void assumeTrueWithMessage() {   //skipped
//        System.setProperty("ENV", "DEV");
        assumeTrue("DEV".equals(System.getProperty("ENV")), "Assumption Failed"); //failed -> System.getProperty("ENV") == null
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }

    @Test
    public void assumeTrueWithSupplierMessage() {    //skipped
        assumeTrue("DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed"); //failed -> System.getProperty("ENV") == null
        System.out.println("Assumption passed!");

        assertEquals(3, 2+1);
    }
}
