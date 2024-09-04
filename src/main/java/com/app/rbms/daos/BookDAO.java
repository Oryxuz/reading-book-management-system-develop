package com.app.rbms.daos;

import com.app.rbms.entities.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    Book getBook(long id);

    void saveOrUpdate(Book book);

    boolean delete(long id);

    List<Book> getBooks(String keyword, String condition);

    List<Book> getBooks(long bookCaseID);
}
