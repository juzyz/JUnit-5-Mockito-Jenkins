package com.mockito.juzyz.mockfeatures;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookServiceBasicTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    //using when() -> thenReturn()
    @Test
    public void testAnnotations() {
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

    //using doReturn() -> when()
    @Test
    public void testCalculateTotalCost() {
        List<String> bookIds = Arrays.asList("123", "234");
        Book book1 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("234", "JUnit 5 In Action", 400, LocalDate.now());

        doReturn(book1).when(bookRepository).findBookById("123");
        doReturn(book2).when(bookRepository).findBookById("234");
//        doReturn(book2).when(bookRepository.findBookById("234")); // returns Unfinished StubbingException

        int actualCost = bookService.calculateTotalCost(bookIds);
        assertEquals(900, actualCost);
    }


    //using doNothing()
    @Test
    public void testSaveBook() {
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        doNothing().when(bookRepository).save(book);
        bookService.addBook(book);
    }

    //applying @override Book.equals(Object o) since BookService.addBook(bookRequest) creates a new book object
    @Test
    public void testSaveBookWithBookRequest() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        doNothing().when(bookRepository).save(book);
        bookService.addBook(bookRequest);
    }
}
