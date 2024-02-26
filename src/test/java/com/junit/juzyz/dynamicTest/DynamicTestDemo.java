package com.junit.juzyz.dynamicTest;

import com.junit.juzyz.example.StringHelper;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestDemo {

    StringHelper stringHelper = new StringHelper();

    @TestFactory
    public DynamicTest testReverse() {
        return dynamicTest("Dynamic Test for reverse method", () -> {
            assertEquals("god", stringHelper.reverse("dog"));
        });

    }

    /* returns JUnitException: @TestFactory method [public java.lang.String..)
    must return a single org.junit.jupiter.api.DynamicNode or a Stream, Collection,
    Iterable, Iterator, or array of org.junit.jupiter.api.DynamicNode.
    */
    @TestFactory
    public String testReverseWithString() {
        return "dynamic test";
    }

    @TestFactory
    public Collection<DynamicTest> dynamicTestCollection() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutnputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse (): input - " + input, () -> {
                assertEquals(output, stringHelper.reverse(input));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    @TestFactory
    public Iterable<DynamicTest> dynamicTestFromIterable() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutnputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse (): input - " + input, () -> {
                assertEquals(output, stringHelper.reverse(input));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests;
    }

    @TestFactory
    public Iterator<DynamicTest> dynamicTestFromIterator() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutnputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse (): input - " + input, () -> {
                assertEquals(output, stringHelper.reverse(input));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.iterator();
    }

    @TestFactory
    public Stream<DynamicTest> dynamicTestFromStream() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutnputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse (): input - " + input, () -> {
                assertEquals(output, stringHelper.reverse(input));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.stream();
    }

    @TestFactory
    public  DynamicTest[] dynamicTestFromArray() {
        List<String> inputList = createInputList();
        List<String> outputList = createOutnputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse (): input - " + input, () -> {
                assertEquals(output, stringHelper.reverse(input));
            });
            dynamicTests.add(dynamicTest);
        }
        return dynamicTests.toArray(new DynamicTest[dynamicTests.size()]);
    }

    private List<String> createOutnputList() {
        return Arrays.asList("ecar", "mom", "dad", "tset");
    }

    private List<String> createInputList() {
        return Arrays.asList("race", "mom", "dad", "test");
    }

}
