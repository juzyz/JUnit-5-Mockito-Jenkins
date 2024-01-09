package com.mockito.juzyz.bddstub;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceBDDTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testInTraditionalMockitoStyle() {
        List<Book> newBooks = Arrays.asList(
                new Book("123", "Mockito In Action", 500, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 400, LocalDate.now())
        );
        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    @DisplayName("Given- тew books, When - get new books with applied discount method is called, Then - new books with applied discount returned.")
    public void test_Given_NewBooks_When_getNewBooksWithAppliedDiscount_Then_NewBooksWithAppliedDiscountReturned(){
        //Arrange -Given
        List<Book> newBooks = Arrays.asList(
                new Book("123", "Mockito In Action", 500, LocalDate.now()),
                new Book("234", "JUnit 5 In Action", 400, LocalDate.now())
        );
        given(bookRepository.findNewBooks(7)).willReturn(newBooks);
//        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(newBooks);
        //Act - When
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);
        //Assert - Then
        assertEquals(2, newBooksWithAppliedDiscount.size());
        assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice());

        //AssertJ - BDDAssertions
        then(newBooksWithAppliedDiscount).isNotNull();
        then(newBooksWithAppliedDiscount.size()).isEqualTo(2);
        then( newBooksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
        then( newBooksWithAppliedDiscount.get(1).getPrice()).isEqualTo(360);

    }

    //Behavior verification
    @Test
    public  void testUpdatePrice (){
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        when(bookRepository.findBookById("123")).thenReturn(book);
        bookService.updatePrice("123", 500);
        verify(bookRepository).findBookById("123");
        verify(bookRepository).save(book);
    }

    @Test
    public void test_Given_book_When_updatePriceIsCalledWithNewPRice_Then_BookPriceIsUpdated (){
        //Given
        Book book = new Book("123", "Mockito In Action", 500, LocalDate.now());
        given(bookRepository.findBookById("123")).willReturn(book);
        //When
        bookService.updatePrice("123", 500);
        //Then
        org.mockito.BDDMockito.then(bookRepository).should().save(book);
    }

    @Test
    public void test_When_getTotalPriceOfBooks_Then_trowsDatabaseReadException() throws SQLException {
        //Given
        given(bookRepository.findAllBooks()).willThrow(SQLException.class);
        //When & Then
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());
    }
}
