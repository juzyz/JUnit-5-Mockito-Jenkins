package com.mockito.juzyz.mockfeatures;

import com.mockito.juzyz.mockfeatures.exceptions.DatabaseReadException;
import com.mockito.juzyz.mockfeatures.exceptions.DatabaseWriteException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() <= 450) {
            return;
        }
        bookRepository.save(book);
    }

    public void addBookWithException(Book book) throws DatabaseWriteException {
        try {
            bookRepository.saveBookWithException(book);
        } catch (SQLException e) {
            //log  exception
            throw new DatabaseWriteException("Unable to write from database due to " + e.getMessage());
        }

    }

    public void addBook(BookRequest bookRequest) {
        if (bookRequest.getPrice() <= 450) {
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }

    public void addBooks(List<Book> books) {
        bookRepository.saveAll(books);
    }

    public Book getBookByTitleAndPublishedDate(String title, LocalDate date) {
        return bookRepository.findBookByTitleAndPublishedDate(title, date);
    }

    public Book getBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital) {
        return bookRepository.findBookByTitleAndPriceAndIsDigital(title, price, isDigital);
    }

    public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        //500 apply 10% -> 10% of 500 = 50 -> 500-50 -> 450
        for (Book book : newBooks) {
            int price = book.getPrice();
            int newPrice = price - (discountRate * price / 100);
            book.setPrice(newPrice);
        }
        return newBooks;
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

    public int calculateTotalCost(List<String> bookIds) {

        int total = 0;
        for (String id : bookIds) {
            Book book = bookRepository.findBookById(id);
            total += book.getPrice();
        }
        return total;
    }


    public void updatePrice(String bookId, int updatedPrice) {
        if (bookId == null) {
            return;
        }
        Book book = bookRepository.findBookById(bookId);
        if (book.getPrice() == updatedPrice) {
            return;
        }
        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }


}
