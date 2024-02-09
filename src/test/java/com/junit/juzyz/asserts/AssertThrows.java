package com.junit.juzyz.asserts;

import com.junit.juzyz.bookstore.exeption.BookNotFoundException;
import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrows {
    @Test
    public void assertThrowsWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        assertThrows(BookNotFoundException.class, () -> bookService.getBookByTitle("Head First Spring"));
//        assertThrows(NullPointerException.class, () -> bookService.getBookByTitle("Head First Spring"));  // fails
    }

    @Test
    public void assertThrowsWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

//        assertThrows(BookNotFoundException.class, () -> bookService.getBookByTitle("Head First Spring")); // passes
        assertThrows(NullPointerException.class, () -> bookService.getBookByTitle("Head First Spring"), "Different type of exception throws");
    }

    @Test
    public void assertThrowsWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);

        assertThrows(RuntimeException.class, () -> bookService.getBookByTitle("Head First Spring"), () -> "Different type of exception throws");
//        assertThrows(NullPointerException.class, () -> bookService.getBookByTitle("Head First Spring"), () -> "Different type of exception throws"); // fails
    }
}
