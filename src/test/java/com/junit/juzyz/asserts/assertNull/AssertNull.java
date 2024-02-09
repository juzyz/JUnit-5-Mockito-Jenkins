package com.junit.juzyz.asserts.assertNull;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertNull {

    @Test
    public void assertNullWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("3");
        assertNull(actualBook);
    }

    @Test
    public void assertNullWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertNull(actualBook, "Book is not null" );
    }

    @Test
    public void assertNullWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        Book actualBook = bookService.getBookBuId("2");
        assertNull(actualBook, () -> "Book is not null" );
    }
}
