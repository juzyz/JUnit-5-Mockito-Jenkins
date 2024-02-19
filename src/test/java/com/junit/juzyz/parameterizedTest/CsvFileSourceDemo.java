package com.junit.juzyz.parameterizedTest;

import com.junit.juzyz.example.StringHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CsvFileSourceDemo {

    @ParameterizedTest
    @CsvFileSource(resources = "/reverse.csv")
    public void csvFileSourceDemoTest(String input, String expect) {
        StringHelper stringHelper = new StringHelper();
        assertEquals(expect, stringHelper.reverse(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/reverse.csv", numLinesToSkip = 1)
    public void csvFileSourceWithNumLinesToSkipTest(String input, String expect) {
        StringHelper stringHelper = new StringHelper();
        assertEquals(expect, stringHelper.reverse(input));
    }

}
