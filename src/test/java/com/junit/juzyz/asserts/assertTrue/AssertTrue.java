package com.junit.juzyz.asserts.assertTrue;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrue {

    @Test
    public void assertTrueWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(bookList.isEmpty());
    }

    @Test
    public void assertTrueWithBooleanSupplierNoMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(() ->bookList.isEmpty());
    }

    @Test
    public void assertTrueWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(bookList.isEmpty(), "List of book is not empty.");
    }

    @Test
    public void assertTrueWithBooleanSupplierWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(() ->bookList.isEmpty(), "List of book is not empty.");
    }
    @Test
    public void assertTrueWithMessageSupplier (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(bookList.isEmpty(), () -> "List of book is not empty.");
    }

    @Test
    public void assertTrueWithBooleanSupplierAndMessageSupplier (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertTrue(()-> bookList.isEmpty(), () -> "List of book is not empty.");
    }
}
