package com.mockito.juzyz.testdoubletypes.dummy;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);
    Collection<Book> findAll();
}
