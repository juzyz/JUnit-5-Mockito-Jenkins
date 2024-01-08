package com.mockito.juzyz.testdoubletypes.stub;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/*
This repository is used to show how to test
a stub double WITHOUT using Mockito
*/
public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        return Arrays.asList(
                new Book("123", "Mockito In Action", 500, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 400, LocalDate.now())
        );
    }
}
