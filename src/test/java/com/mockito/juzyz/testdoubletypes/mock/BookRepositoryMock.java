package com.mockito.juzyz.testdoubletypes.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
This repository is used to show how to test
a mock double WITHOUT using Mockito
*/
public class BookRepositoryMock implements BookRepository {
    int saveCalled = 0;
    Book lastAddedBook =  null;

    @Override
    public void save( Book book) {
        saveCalled ++;
        lastAddedBook = book;
    }

    public void verify (Book book, int times) {
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);
    }

}
