package com.app.rbms.daos.impl;

import com.app.rbms.daos.BookDAO;
import com.app.rbms.entities.Book;
import com.app.rbms.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    public static void main(String[] args) {
        BookDAOImpl bookDAO = new BookDAOImpl();
        bookDAO.getBooks(2).forEach(System.out::println);
    }

    @Override
    public List<Book> getBooks() {
        List<Book> books = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            books = session.createQuery("from Book").list();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book getBook(long id) {
        Book book = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            book = session.get(Book.class, id);
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public void saveOrUpdate(Book book) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(long id) {
        boolean result;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Book book = session.get(Book.class, id);
            session.delete(book);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            result = false;
            if (session != null) {
                session.close();
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Book> getBooks(String keyword, String condition) {
        List<Book> books = null;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Query query = null;
        try {
            switch (condition) {
                case "title":
                    query = session.createQuery("from Book where title =: keyword");
                    break;
                case "author":
                    query = session.createQuery("from Book where author =: keyword");
                    break;
                case "category":
                    query = session.createQuery("from Book where category =: keyword");
                    break;
            }
            query.setParameter("keyword", keyword);
            books = query.getResultList();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getBooks(long bookCaseID) {
        List<Book> books = null;
        Query query;
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            query = session.createQuery("select b from Book b inner join Contain c on b.id = c.book.id where c.bookCase.id =: bookCaseID");
            query.setParameter("bookCaseID", bookCaseID);
            books = query.getResultList();
        } catch (Exception e) {
            if (session != null) {
                session.close();
            }
            e.printStackTrace();
        }
        return books;
    }
}

