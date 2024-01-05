package com.mockito.juzyz.testdoubletypes.fake;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;


/* Creating BookRepository instance with BookRepository.
Unit test for  bookService.findNumberOfBook() method */
public class FakeTest {
    @Test
    public void testFakeWithoutMockito() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("123", "Mockito In Action", 250, LocalDate.now()));
        bookService.addBook(new Book("234", "JUnit 5 In Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }

    @Test
    public void testFakeWithMockito() {

        Collection<Book> books = Arrays.asList(
                new Book("123", "Mockito In Action", 250, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 200, LocalDate.now())
        );

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBook());

    }
}
