package com.app.rbms.services.impl;

import com.app.rbms.daos.BookCaseDAO;
import com.app.rbms.entities.BookCase;
import com.app.rbms.services.BookCaseService;

public class BookCaseServiceImpl implements BookCaseService {

    private final BookCaseDAO bookCaseDAO;

    public BookCaseServiceImpl(BookCaseDAO bookCaseDAO) {
        this.bookCaseDAO = bookCaseDAO;
    }

    @Override
    public BookCase getBookCase(long userID) {
        return bookCaseDAO.getBookCase(userID);
    }
}
