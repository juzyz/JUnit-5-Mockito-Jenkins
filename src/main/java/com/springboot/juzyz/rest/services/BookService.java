package com.springboot.juzyz.rest.services;

import com.springboot.juzyz.rest.models.Book;
import com.springboot.juzyz.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book bookRecord) {
        if (bookRecord == null && bookRecord.getBookId() == null) {
            throw new NoSuchElementException("BookRecord or ID must not be null");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
        if (!optionalBook.isPresent()) {
            throw new NoSuchElementException("Book with ID " + bookRecord.getBookId() + "does not exist.");
        }
        Book existingBookRecord = optionalBook.get();
        existingBookRecord.setName(bookRecord.getName());
        existingBookRecord.setSummary(bookRecord.getSummary());
        existingBookRecord.setRating(bookRecord.getRating());

        return bookRepository.save(existingBookRecord);
    }

    public void deleteBook(Long bookId) {
        if (!bookRepository.findById(bookId).isPresent()) {
            throw new NoSuchElementException("bookId " + bookId + " not present");
        }
        bookRepository.deleteById(bookId);
    }
}
