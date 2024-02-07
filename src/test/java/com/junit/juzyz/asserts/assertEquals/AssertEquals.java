package com.junit.juzyz.asserts.assertEquals;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEquals {
    @Test
    public void assertEqualsWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("1");
        assertEquals("1", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle());
    }

    @Test
    public void assertEqualsWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertEquals("2", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(), "Book title doesn't match.");
    }

    @Test
    public void assertEqualsWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertEquals("2", actualBook.getBookId());
        assertEquals("Head First Java", actualBook.getTitle(), () ->"Book title doesn't match.");
    }
}
