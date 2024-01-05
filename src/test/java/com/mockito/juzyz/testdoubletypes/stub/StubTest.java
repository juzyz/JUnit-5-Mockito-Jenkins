package com.mockito.juzyz.testdoubletypes.stub;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


/* BookRepositoryStub returns pre-defined data (list of new books)
Unit test for  bookService.getNewBooksWithAppliedDiscount() method */
public class StubTest {
    @Test
    public void testStubWithoutMockito() {

        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void testStubWithMockito() {

        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        //previously BookRepositoryStub findNewBooks() created the newBooks list
        List<Book> newBooks = Arrays.asList(
                new Book("123", "Mockito In Action", 500, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 400, LocalDate.now())
        );
        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }
}
