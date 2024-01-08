package com.mockito.juzyz.mockfeatures;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BookServiceArgumentMatchersTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testUpdatePriceWithAnyArgument() {
        Book book1 = new Book("123", "Mockito In Action", 600, LocalDate.now());
        Book book2 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById(any())).thenReturn(book1);
        bookService.updatePrice("xyz", 500); //with any bookId findBookById() returns book1
        verify(bookRepository).save(book2);

    }

    //Type argument matchers
    @Test
    public void testUpdatePriceWithSpecificClassArgument() {
        Book book1 = new Book("123", "Mockito In Action", 600, LocalDate.now());
        Book book2 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById(any(String.class))).thenReturn(book1);
        bookService.updatePrice("xyz", 500); //with any STRING bookId findBookById() returns book1
        verify(bookRepository).save(book2);
    }

    //Argument matchers should be provided for all arguments.
    //Argument Matchers can't be used outside stubbing/verification
    @Test
    public void testInvalidUseOfArgumentMatchers() {
        Book book = new Book("123", "Mockito In Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPublishedDate(eq("Mockito In Action"), any())).thenReturn(book);
//        Book actualBook = bookRepository.findBookByTitleAndPublishedDate(eq("Mockito In Action"), any());//returns NullPointerException
        Book actualBook = bookService.getBookByTitleAndPublishedDate("Mockito In Action", LocalDate.now());
        assertEquals("Mockito In Action", actualBook.getTitle());
    }


    @Test
    public void testSpecificTypeOfArgumentMatchers() {
        Book book = new Book("123", "Mockito In Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true);
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testStringTypeOfArgumentMatchers() {
        Book book = new Book("123", "Mockito In Action", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(startsWith("Mockito"), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("Mockito In Action", 600, true);
        assertEquals("Mockito In Action", actualBook.getTitle());
    }

    @Test
    public void testCollectionTypeArgumentMatchers() {
        List<Book> books = Arrays.asList(
                new Book("123", "Mockito In Action", 500, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 400, LocalDate.now())
        );
        Book book1 = new Book("123", "Mockito In Action", 600, LocalDate.now());
        Book book2 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        bookService.addBooks(books);
        verify(bookRepository).saveAll(anyList());
    }

}
