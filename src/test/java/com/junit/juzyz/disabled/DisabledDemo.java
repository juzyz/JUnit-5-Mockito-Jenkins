package com.junit.juzyz.disabled;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Disabled("skipped until #50 issue has been fixed") // required maven-surefire-plugin settings
public class DisabledDemo {

    @Test
    @Disabled("skipped until #95 issue has been fixed")
    public void assertEqualsWithoutMessage (){ // got skipped
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
