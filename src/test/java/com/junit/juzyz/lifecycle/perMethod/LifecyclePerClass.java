package com.junit.juzyz.lifecycle.perMethod;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LifecyclePerClass {

    /*
    Constructor got executed!
    @BeforeAll got executed!
    @BeforeEach got executed!
    testOne() got executed!
    @AfterEach got executed!
    @BeforeEach got executed!
    testTwo() got executed!
    @AfterEach got executed!
    @afterAll got executed!
    */

    @BeforeAll
    public void beforeAll() {  //non-static
        System.out.println("@BeforeAll got executed!");
    }

    public LifecyclePerClass() {
        System.out.println("Constructor got executed!");
    }

    @BeforeEach
    public void BeforeEach() {
        System.out.println("@BeforeEach got executed!");
    }

    @Test
    public void testOne() {
        System.out.println("testOne() got executed!");
    }

    @Test
    public void testTwo() {
        System.out.println("testTwo() got executed!");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("@AfterEach got executed!");
    }
    @AfterAll
    public void afterAll() {  //non-static
        System.out.println("@afterAll got executed!");
    }

}
