package com.mockito.juzyz.testdoubletypes.mock;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() > 400) {
            return;
        }
        bookRepository.save(book);
    }
}
