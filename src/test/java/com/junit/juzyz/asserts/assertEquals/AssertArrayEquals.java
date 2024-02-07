package com.junit.juzyz.asserts.assertEquals;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class AssertArrayEquals {
    @Test
    public void assertArrayEqualsWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First Java", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);

        String [] actualBooks = bookService.getBookByPublisher("Wrox");
        
        assertArrayEquals(new String []{"1", "3"}, actualBooks);
    }

    @Test
    public void assertArrayEqualsWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First Java", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);

        String [] actualBooks = bookService.getBookByPublisher("Wrox");

        assertArrayEquals(new String []{"3", "1"}, actualBooks, "bookIds don't match.");
    }

    @Test
    public void assertArrayEqualsWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First Java", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);

        String [] actualBooks = bookService.getBookByPublisher("Wrox");

        assertArrayEquals(new String []{"1", "3", "5"}, actualBooks, () -> "bookIds don't match.");  //==> array lengths differ,
    }
}
