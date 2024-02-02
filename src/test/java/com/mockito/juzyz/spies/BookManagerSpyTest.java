package com.mockito.juzyz.spies;


import com.mockito.juzyz.spy.Book;
import com.mockito.juzyz.spy.BookManager;
import com.mockito.juzyz.spy.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;


import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookManagerSpyTest {

    @InjectMocks
    private BookManager bookManager;

    @Spy
    private BookService bookService;

    /*
    Spies allow us to call all the real methods while still tracking every interaction.
    Thus, it's used much less Test double as the actual external dependency is still involved
     */
    @Test
    public void testMockitoSpyViaMock() {
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());

        List mockedList = Mockito.mock(ArrayList.class);
        mockedList.add(book);
        Mockito.verify(mockedList).add(book);

        List spyList = Mockito.spy(new ArrayList());
        spyList.add(book);
        Mockito.verify(spyList).add(book);

        assertEquals(0, mockedList.size()); //adding an element into the mocked list doesn’t actually add anything
        assertEquals(1, spyList.size()); //When spy is called, then actual method of real object is called.
    }

    @Test
    public void testMockitoSpyStubbing() {
        //need to mock findBook because it is communicating with database or not implemented
        //need to call getAppliedDiscounted to calculate the discounted price
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        doReturn(book).when(bookService).findBook("123");
//        when(bookService.findBook("123")).thenReturn(book);// returns 'RuntimeException: Method is not implemented'
        int actualDiscount = bookManager.applyDiscountOnBook("123", 10);
        assertEquals(450, actualDiscount);
    }
}