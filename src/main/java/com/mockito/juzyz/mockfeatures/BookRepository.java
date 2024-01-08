package com.mockito.juzyz.mockfeatures;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface BookRepository {


    Book findBookById(String id);

    void save(Book book);

    List<Book> findAllBooks() throws SQLException;

    void saveBookWithException(Book book) throws SQLException;

    List<Book> findNewBooks(int days);

    Book findBookByTitleAndPublishedDate(String title, LocalDate date);

    Book findBookByTitleAndPriceAndIsDigital(String title, int price, boolean isDigital);

    void saveAll(List<Book> books);

}
