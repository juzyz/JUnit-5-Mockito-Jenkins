package com.mockito.juzyz.spy;


public class BookService {
    public Book findBook(String bookId) {
        throw new RuntimeException("Method is not implemented.");
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (discountRate * price / 100);
        return newPrice;
    }
}
