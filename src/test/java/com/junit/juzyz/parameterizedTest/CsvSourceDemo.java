package com.junit.juzyz.parameterizedTest;

import com.junit.juzyz.example.StringHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvSourceDemo {

    @ParameterizedTest
    @CsvSource({
            "car, rac",
            "test, tset"
    })
    public void csvSourceDemoTest(String input, String expect) {
        StringHelper stringHelper = new StringHelper();
        assertEquals(expect, stringHelper.reverse(input));
    }

    @ParameterizedTest
    @CsvSource({
            "car, 'my, car'",  //take '' if a source contains ,
            "test, ''",        // take '' to pass empty param
            "book, "           // failed since the second param = null
    })
    public void csvSourceDemoWithSingleQuotesTest(String first, String second) {
        assertNotNull(first);
        assertNotNull(second);
    }

    @ParameterizedTest
    @CsvSource({
            "One, 3" // passed
    })
    public void csvSourceDemoWithIntegersTest(String first, Integer second) {
        assertNotNull(first);
        assertNotNull(second);
    }
}
