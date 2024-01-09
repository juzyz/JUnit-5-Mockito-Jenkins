package com.mockito.juzyz.bddstub;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days);

    Book findBookById(String bookId);

    void save(Book book);

    List< Book> findAllBooks () throws SQLException;
//    Collection<Book> findAll();
}
