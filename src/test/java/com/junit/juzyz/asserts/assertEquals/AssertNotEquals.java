package com.junit.juzyz.asserts.assertEquals;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEquals {
    @Test
    public void assertNotEqualsWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("1");
        assertNotEquals("2", actualBook.getBookId());
        assertNotEquals("Head First Java", actualBook.getTitle());
    }

    @Test
    public void assertNotEqualsWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertNotEquals("2", actualBook.getBookId(), "BookId matches to expected value.");
    }

    @Test
    public void assertNotEqualsWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertNotEquals("2", actualBook.getBookId(), () -> "BookId matches to expected value.");

    }
}
