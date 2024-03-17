package com.junit.juzyz.parameterizedTest;

import com.junit.juzyz.example.StringHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MethodSourceDemo {

    @ParameterizedTest
    @MethodSource("stringProvider")
    public void methodSourceTest (String value){
        assertNotNull(value);
    }

    public static Stream<String> stringProvider (){
        return Stream.of("dog", "cat", "mouse");
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void methodSourceWithArgumentsTest(String input, String expected){
        StringHelper stringHelper = new StringHelper();
        assertEquals(expected, stringHelper.reverse(input));
    }

    public static Stream<Arguments> argumentProvider (){
        return Stream.of(
                Arguments.arguments("car", "rac"),
                Arguments.arguments("mom", "mom")
        );
    }
}
