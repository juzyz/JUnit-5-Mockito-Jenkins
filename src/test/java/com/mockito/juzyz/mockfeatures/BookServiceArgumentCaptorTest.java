package com.mockito.juzyz.mockfeatures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceArgumentCaptorTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    //ArgumentCaptor allows us to capture an argument passed to a method to inspect it
    @Test
    public void testSaveBookWithArgumentCaptorWithCaptorAnnotation() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        assertEquals("Mockito In Action", book.getTitle());
    }

    @Test
    public void testSaveBookWithArgumentCaptorWithoutCaptorAnnotation() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 600, LocalDate.now());
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class); //instead of  @Captor
        bookService.addBook(bookRequest);
        verify(bookRepository).save(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        assertEquals("Mockito In Action", book.getTitle());
    }


}


