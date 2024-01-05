package com.mockito.juzyz.testdoubletypes.dummy;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/* Creating BookService instance with DummyEmailService.
Unit test for  bookService.findNumberOfBook() method */
public class DummyTest {

    @Test
    public void testDummyWithoutMockito() {
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("123", "Mockito In Action", 250, LocalDate.now()));
        bookService.addBook(new Book("234", "JUnit 5 In Action", 200, LocalDate.now()));

        assertEquals(2, bookService.findNumberOfBook());
    }

    @Test
    public void testDummyWithMockito() {
        Collection<Book> books = Arrays.asList(
                new Book("123", "Mockito In Action", 250, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 200, LocalDate.now())
        );

        BookRepository bookRepository = mock(BookRepository.class);
        EmailService emailService = mock(EmailService.class);
        BookService bookService = new BookService(bookRepository, emailService);
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2, bookService.findNumberOfBook());
    }
}
