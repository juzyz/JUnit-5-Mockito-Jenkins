package com.junit.juzyz.asserts.assertEquals;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class AssertIterableEquals {
    @Test
    public void AssertIterableEqualsWithoutMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First JavaScript", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitleByPublisher("Wrox");

        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First JavaScript");

        assertIterableEquals(expectedTitles, actualTitles);
    }

    @Test
    public void AssertIterableEqualsWithMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First JavaScript", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitleByPublisher("Wrox");

        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Design Pattern");
        expectedTitles.add("Head First JavaScript");

        assertIterableEquals(expectedTitles, actualTitles, " Book titles don't match."); //iterable contents differ at index [1]
    }

    @Test
    public void AssertIterableEqualsWithSupplierMessage (){
        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "Wrox");
        Book headFirstDesignPatternBook = new Book("2", "Head First Design Pattern", "Apress");
        Book headFirstJavascriptBook = new Book("3", "Head First JavaScript", "Wrox");

        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignPatternBook);
        bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitleByPublisher("Wrox");

        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Design Pattern");
        expectedTitles.add("Head First JavaScript");

        assertIterableEquals(expectedTitles, actualTitles, () -> "Book titles don't match."); //iterable contents differ at index [1]
    }
}
