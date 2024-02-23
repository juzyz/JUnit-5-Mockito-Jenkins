package com.junit.juzyz.display.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(" DisplayName annotation demo")
public class DisplayNameDemo {

    @Test
    @DisplayName("DisplayName demo test")
    public void displayNameDemoTest(){
        assertEquals(3, 2+1);
    }

    @Test
    @DisplayName("DisplayName demo with spaces")
    public void displayNameDemoWithSpaces(){
        assertEquals(3, 2+1);
    }

    @Test
    @DisplayName("DisplayName demo with β\uF08A\uF0BF\" @!~ special characters")
    public void displayNameDemoWithSpecialCharacters(){
        assertEquals(3, 2+1);
    }

    @Test
    @DisplayName("DisplayName demo with emojis - (smiley)")
    public void displayNameDemoWithEmojis(){
        assertEquals(3, 2+1);
    }
}
