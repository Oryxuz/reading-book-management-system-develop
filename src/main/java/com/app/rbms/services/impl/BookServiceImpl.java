package com.app.rbms.services.impl;

import com.app.rbms.daos.BookDAO;
import com.app.rbms.entities.Book;
import com.app.rbms.services.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public Book getBookById(long id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void saveOrUpdate(Book book) {
        bookDAO.saveOrUpdate(book);
    }

    @Override
    public boolean delete(long id) {
        return bookDAO.delete(id);
    }

    @Override
    public List<Book> getBooks(String keyword, String condition) {
        return bookDAO.getBooks(keyword, condition);
    }

    @Override
    public List<Book> getBooks(long bookCaseID) {
        return bookDAO.getBooks(bookCaseID);
    }
}
