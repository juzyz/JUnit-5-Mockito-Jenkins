package com.mockito.juzyz.testdoubletypes.fake;

import com.mockito.juzyz.testdoubletypes.fake.Book;
import com.mockito.juzyz.testdoubletypes.fake.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
This repository is used to show how to test
a fake double WITHOUT using Mockito
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
