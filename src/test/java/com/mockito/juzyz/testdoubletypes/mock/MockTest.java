package com.mockito.juzyz.testdoubletypes.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

/*
BookRepositoryMock has verify() method to check how many times
the save() method was called and what the last saved object is.
testMockWithMockito() and testSpyWithMockito() methods are equal.
Unit test for  bookService.addBook() method.
*/
public class MockTest {

    @Test
    public void testMockWithoutMockito() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("234", "JUnit 5 In Action", 400, LocalDate.now());
        bookService.addBook(book1);  //return
        bookService.addBook(book2);  //save will be called

        bookRepositoryMock.verify(book2, 1);
    }

    @Test
    public void testMockWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("234", "JUnit 5 In Action", 400, LocalDate.now());
        bookService.addBook(book1);  //return
        bookService.addBook(book2);  //save will be called

//        bookRepositoryMock.verify(book2, 1);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book2);
        Mockito.verify(bookRepository, Mockito.times(0)).save(book1);

    }
}
