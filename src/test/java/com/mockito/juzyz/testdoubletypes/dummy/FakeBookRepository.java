package com.mockito.juzyz.testdoubletypes.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
This repository is used to show how to test
a dummy double WITHOUT using Mockito
*/
public class FakeBookRepository implements BookRepository {

    //In memory database, HashMap or List

    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
