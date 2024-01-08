package com.mockito.juzyz.spy;

public class BookManager {

    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public int applyDiscountOnBook (String bookId, int discountRate ) {
        Book book = bookService.findBook(bookId);  // need to mock
        int discountedPrice = bookService.getAppliedDiscount(book, discountRate); //need to actually call
        return discountedPrice;
    }
}
