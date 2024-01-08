package com.mockito.juzyz.testdoubletypes.spy;

/*
This repository is used to show how to test
a spy double WITHOUT using Mockito
*/
public class BookRepositorySpy implements BookRepository {
    int saveCalled = 0;
    Book lastAddedBook =  null;

    @Override
    public void save(Book book) {
        saveCalled ++;
        lastAddedBook = book;
    }

    public int timesCalled () {
        return saveCalled;
    }

    public boolean calledWith (Book book){
        return lastAddedBook.equals(book);
    }
}
