package com.mockito.juzyz.mockfeatures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceVerificationTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    //check that bookRepository.save() was invoked
    @Test
    public void testAddBookWithInvokeVerification() {
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(book);
        verify(bookRepository).save(book);
    }

    //explanation of times()
    @Test
    public void testSaveBookWithBookRequestWithNeverInvoke() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 400, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 400, LocalDate.now());
        bookService.addBook(bookRequest);
//        verify(bookRepository, times(0)).save(book);
        verify(bookRepository, never()).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithDefaultInvoke() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
//        verify(bookRepository, times(1)).save(book);
        verify(bookRepository).save(book); // default times = 1
    }

    @Test
    public void testSaveBookWithBookRequestWittSeveralInvoke() {
        BookRequest bookRequest = new BookRequest("Mockito In Action", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        verify(bookRepository, atLeast(1)).save(book);//called 2 times
        verify(bookRepository, atLeastOnce()).save(book);//called 2 times
        verify(bookRepository, atMost(3)).save(book);//called 2 times
//        verify(bookRepository, atMostOnce()).save(book);// returned MoreThanAllowedActualInvocations
    }

    //check that methods of bookRepository were not called
    @Test
    public void testUpdatePriceWithVerifyNoInteractions() {
        bookService.updatePrice(null, 500);
        verifyNoInteractions(bookRepository);
    }

    //check that only findBookById() method of bookRepository was called and used "123" parameter.
    @Test
    public void testUpdatePriceWithVerificationOfParameter() {
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("123")).thenReturn(book);
        bookService.updatePrice("123", 500);
        verify(bookRepository).findBookById("123");
        verifyNoMoreInteractions(bookRepository);
    }

    //check the order of method invoking in BookRepository class
    @Test
    public void testUpdatePriceWithVerificationOfInvokingOrder() {

        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("123")).thenReturn(book);
        bookService.updatePrice("123", 400);

        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findBookById("123");
        inOrder.verify(bookRepository).save(book);
    }
}


