package com.app.rbms.daos;

import com.app.rbms.entities.BookCase;

public interface BookCaseDAO {
    BookCase getBookCase(long userID);
}
