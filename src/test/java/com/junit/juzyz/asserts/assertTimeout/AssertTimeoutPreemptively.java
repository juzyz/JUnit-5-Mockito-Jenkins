package com.junit.juzyz.asserts.assertTimeout;

import com.junit.juzyz.bookstore.module.Book;
import com.junit.juzyz.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTimeoutPreemptively {
    @Test
    public void assertTimeoutPreemptivelyWithoutMessage (){
        BookService bookService = new BookService();

        for (int i=0; i< 10000; i ++){
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }
        List<String> actualTitles = new ArrayList<>();

       assertTimeoutPreemptively(Duration.ofMillis(1), () ->{  // execution exceeded timeout of 1 ms by 2 ms
            actualTitles.addAll(bookService.getBookTitleByPublisher("Wrox")); //
        });
        assertEquals(10000, actualTitles.size());
    }

    @Test
    public void assertTimeoutPreemptivelyWithMessage (){
        BookService bookService = new BookService();

        for (int i=0; i< 10000; i ++){
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }
        List<String> actualTitles = new ArrayList<>();

       assertTimeoutPreemptively(Duration.ofMillis(1), () ->{  // execution exceeded timeout of 1 ms by 2 ms
            actualTitles.addAll(bookService.getBookTitleByPublisher("Wrox")); //
        }, "Performance issue with getBookTitleByPublisher() method");
        assertEquals(10000, actualTitles.size());
    }

    @Test
    public void assertTimeoutPreemptivelyWithSupplierMessage (){
        BookService bookService = new BookService();

        for (int i=0; i< 100000; i ++){
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }
        List<String> actualTitles = new ArrayList<>();

       assertTimeoutPreemptively(Duration.ofMillis(1), () ->{  // execution exceeded timeout of 1 ms by 2 ms
            actualTitles.addAll(bookService.getBookTitleByPublisher("Wrox")); //
        }, () -> "Performance issue with getBookTitleByPublisher() method");
        assertEquals(100000, actualTitles.size());
    }

}
