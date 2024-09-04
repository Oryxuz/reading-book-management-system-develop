package com.app.rbms.services;

import com.app.rbms.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(long id);

    void saveOrUpdate(Book book);

    boolean delete(long id);

    List<Book> getBooks(String keyword, String condition);

    List<Book> getBooks(long bookCaseID);
}
