package com.junit.juzyz.bookstore.service;

import com.junit.juzyz.bookstore.exeption.BookNotFoundException;
import com.junit.juzyz.bookstore.module.Book;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class BookService {
    private List<Book> bookList = new ArrayList<>();


    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(bookList);
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Book getBookBuId(String bookId) {
        for (Book book : bookList) {
            if (bookId == book.getBookId()) {
                return book;
            }
        }
        return null;
    }

    public Book getBookByTitle (String title) {

        for (Book book : bookList) {
            if (title.equals(book.getPublisher())) {
                return book;
            }
        }
        throw  new BookNotFoundException("Book is not found im bookstore.");
    }

    public String[] getBookByPublisher(String publisher) {
        List<String> bookIds = new ArrayList<>();
        for (Book book : bookList) {
            if (publisher.equals(book.getPublisher())) {
                bookIds.add(book.getBookId());
            }
        }
        return bookIds.toArray(new String[bookIds.size()]);
    }

    public List<String> getBookTitleByPublisher(String publisher) {
        List<String> bookTitles = new ArrayList<>();
        for (Book book : bookList) {
            if (publisher.equals(book.getPublisher())) {
                bookTitles.add(book.getTitle());
            }
        }
        return bookTitles;
    }



}
