package com.springboot.juzyz.rest.controllers;

import com.springboot.juzyz.rest.models.Book;
import com.springboot.juzyz.rest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path="api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController (BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(value = "{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.getById(bookId) ;
    }

    @PostMapping
    public Book createBookRecord(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    @PutMapping
    public Book updateBookRecord(@RequestBody Book book)  {
        return bookService.updateBook(book);
    }

    @DeleteMapping(value = "{bookId}")
    public void deleteBookById(@PathVariable(value = "bookId") Long bookId)  {
        bookService.deleteBook(bookId);

    }
}
