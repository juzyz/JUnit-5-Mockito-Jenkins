package com.junit.juzyz.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class JreConditionsDemo {

    @Test
    @EnabledOnJre(value ={JRE.JAVA_18, JRE.JAVA_16})
    public void enableOnJava18() {
        System.out.println("Enable only on JRE 18!");
    }

    @Test
    @DisabledOnJre(JRE.JAVA_18)
    public void disableOnJava18() {
        System.out.println("Disable  on JRE 18!");
    }
}
