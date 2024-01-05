package com.mockito.juzyz.testdoubletypes.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

/* BookRepositorySpy remembers how many times the save() method
was called and what the last saved object is.
Unit test for  bookService.addBook() method */
public class SpyTest {

    @Test
    public void testSpyWithoutMockito() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("123", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new Book("234", "JUnit 5 In Action", 400, LocalDate.now());
        bookService.addBook(book1);
        assertEquals(0, bookRepositorySpy.timesCalled());
        bookService.addBook(book2);

        assertEquals(1, bookRepositorySpy.timesCalled());
        assertTrue(bookRepositorySpy.calledWith(book2));
    }

    @Test
    public void testSpyWithMockito() {
       BookRepository bookRepositorySpy = spy(BookRepository.class);
         BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new  Book("123", "Mockito In Action", 500, LocalDate.now());
        Book book2 = new  Book("234", "JUnit 5 In Action", 400, LocalDate.now());
        bookService.addBook(book1);  //return
        bookService.addBook(book2);  //save will be called

        Mockito.verify(bookRepositorySpy, Mockito.times(1)).save(book2);
        Mockito.verify(bookRepositorySpy, Mockito.times(0)).save(book1);

    }
}
