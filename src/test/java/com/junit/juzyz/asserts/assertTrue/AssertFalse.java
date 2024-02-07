package com.junit.juzyz.asserts.assertTrue;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertFalse {
    @Test
    public void assertFalseWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(bookList.isEmpty());
    }

    @Test
    public void assertFalseWithBooleanSupplierNoMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(() ->bookList.isEmpty());
    }

    @Test
    public void assertFalseWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
//        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(bookList.isEmpty(), "List of book is empty.");
    }

    @Test
    public void assertFalseWithBooleanSupplierWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
//        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(() ->bookList.isEmpty(), "List of book is  empty.");
    }
    @Test
    public void assertFalseWithMessageSupplier (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
//        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(bookList.isEmpty(), () -> "List of book is empty.");
    }

    @Test
    public void assertFalseWithBooleanSupplierAndMessageSupplier (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
//        bookService.addBook(headFirstJavaBook);
        List<Book> bookList = bookService.getAllBooks();
        assertFalse(()-> bookList.isEmpty(), () -> "List of book is empty.");
    }
}
