package com.mockito.juzyz.testdoubletypes.stub;

import java.util.List;

public interface BookRepository {
    List<Book> findNewBooks(int days);
}
