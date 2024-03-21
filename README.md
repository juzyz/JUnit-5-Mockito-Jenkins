# JUnit-5-Mockito-Jenkins

A comprehensive Java project developed with the primary goal of showcasing examples of unit testing using a variety of test frameworks. This project serves as an educational resource and practical guide for developers looking to understand and implement unit testing best practices.

## Table of Contents
- [Introduction](#introduction)
- [Framework Versions](#framework-versions)
- [Features](#features)
  - [1. Test Doubles](#1-test-doubles)
  - [2. Mock features](#2-mock-features)
  - [3. Spy](#3-spy)
  - [4. Behavior Driven Development](#4-behavior-driven-development)
  - [5. Integration Testing with Spring Boot Test](#5-integration-testing-with-spring-boot-test)
  - [6. Junit Tests](#6-junit-tests)
- [Getting Started](#getting-started)
- [Contributing](#contributing)


## Introduction

Welcome to JUnit-5-Mockito-Jenkins, a Java project designed to showcase the practical usage of testing frameworks such as JUnit, Mockito, and Spring Boot Test.  This project serves as a hands-on exploration of best practices in testing Java applications, demonstrating how to write reliable and maintainable code through a series of examples and real-world scenarios. Additionally, a jenkinsfile configuration file has been added to automate unit test integration with Jenkins and execute tests consistently in a CI/CD environment.

## Framework Versions

- **Java Development Kit (JDK):** Version 17
  
- **Mockito:5.7** Demonstrates the power of Mockito for creating mock objects, verifying interactions, and improving test coverage.

- **Spring Boot Test:3.2.1** Explores the integration of testing into Spring Boot applications, showcasing how to test components, controllers, and services.
  
- **JUnit:5.10** Illustrates the creation of effective unit tests using JUnit, covering various aspects of code functionality.

## Features

### 1. Test Doubles
 
The project package **com.mockito.juzyz.testdoubletypes** contains examples of the usage of the following test doubles:

**Fakes** are objects that have working implementations, but not same as production one. Usually, they take some shortcut and have simplified version of production code.

**Dummy** — When we use an object to stand in place of a real object, but never make of the object, then the object is called a Dummy. It’s usually done to fill the parameter list, so that the code compiles and the compiler stays happy.

**Stub** is an object that holds predefined data and uses it to answer calls during tests. It is used when we cannot or don’t want to involve objects that would answer with real data or have undesirable side effects.

**Spy** objects are those that, in addition to being Stubs (that is, they return the desired predefined information) also record data on how they were called in some way.

**Mocks** are objects that register calls they receive and analyze the behavior. In test assertion we can verify on Mocks that all expected actions were performed.


### 2. Mock features

The project package **com.mockito.juzyz.mockfeatures** contains examples of the usage of mock features such as:

2.1 Basic features like when() -> thenReturn(), doReturn() -> when(), doNothing() and overriding equals method for stubbing purpose.

2.2 Exception testing for negative scenarios with assertThrow, doThrow and assertThrows methods.

2.3 Behavior verification involves checking whether a method is invoked or not,

```
verify(bookRepository).save(book);
 verifyNoMoreInteractions(bookRepository);
```

counting the number of invocations, 

``` 
verify(bookRepository, never()).save(book);
verify(bookRepository, atLeast(1)).save(book);
```

and examining the values of input parameters used during invocation

```
verify(bookRepository).findBookById("123");
```

2.4 Argument Captor that used to capture argument values for further assertions

```
@Captor
private ArgumentCaptor<Book> bookArgumentCaptor;

verify(bookRepository).save(bookArgumentCaptor.capture());
Book book = bookArgumentCaptor.getValue();
assertEquals("Mockito In Action", book.getTitle());
```

2.5 Argument Matchers are used as wildcards to specify a range of input types rather than a specific input.

```
when(bookRepository.findBookById(any())).thenReturn(book1);
when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
when(bookRepository.findBookByTitleAndDescriptopn(startsWith("Mockito"), contains("action"),)).thenReturn(book);
```

### 3. Spy 
The project package **com.mockito.juzyz.spies** contains examples of the usage of spies that allow to call all real methods of the object while still tracking every interaction using Mockito.spy() and doReturn() methods.

### 4. Behavior Driven Development

The project package **com.mockito.juzyz.bddstub**  contains examples writing tests in a natural, human readable language that have in **given, when, then** format. Mockito library contains a class by name BDDMockito, which introduced BDD style API's and applied for tests in this project package.

### 5. Integration Testing with Spring Boot Test

The project package com.springboot.juzyz.rest contains examples of integration tests for the BookController class, demonstrating how to validate the behavior of RESTful endpoints using MockMvcResultMatchers from the Spring Boot Test module

```
mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/book")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
        .andExpect(jsonPath("$[2].name", is("Grokking Algorithms")));
```
### 6. Junit Tests

Not yet implemented. 


## Getting Started

1. Clone the repository:

```
 git clone https://github.com/juzyz/JUnit-5-Mockito-Jenkins.git
```

2. Navigate to the project directory:

```
cd JUnit 5-Mockito-Jenkins
```

3. Build the project using Maven:
   
```
mvn clean install
```

4. To run the tests, execute the following command:
   
```
mvn test
```

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. 
