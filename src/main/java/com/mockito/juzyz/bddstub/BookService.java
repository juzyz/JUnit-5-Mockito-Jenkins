package com.mockito.juzyz.bddstub;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        //500 apply 10% -> 10% of 500 = 50 -> 500-50 -> 450
        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = price -(discountRate * price / 100);
            book.setPrice(newPrice);
        }
        return newBooks;
    }

    public void updatePrice (String bookId, int updatedPrice){
        Book book = bookRepository.findBookById(bookId);
        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            //log exception
            throw new DatabaseReadException("Unable to read from database due to " + e.getMessage());
        }
        int total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
}
