package com.mockito.juzyz.mockfeatures;


import com.mockito.juzyz.mockfeatures.exceptions.DatabaseReadException;
import com.mockito.juzyz.mockfeatures.exceptions.DatabaseWriteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceExceptionTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBooksWithExceptionClassThrowing() throws SQLException {
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testTotalPriceOfBooksWithExceptionMessageThrowing() throws SQLException {
        when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database is not available."));
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testAddBookWithDoThrowing() throws SQLException {
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        doThrow(SQLException.class).when(bookRepository).saveBookWithException(book);
        assertThrows(DatabaseWriteException.class, () -> bookService.addBookWithException(book));
    }


}


