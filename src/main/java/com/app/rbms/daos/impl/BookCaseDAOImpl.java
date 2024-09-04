package com.app.rbms.daos.impl;

import com.app.rbms.daos.BookCaseDAO;
import com.app.rbms.entities.BookCase;
import com.app.rbms.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class BookCaseDAOImpl implements BookCaseDAO {

    public static void main(String[] args) {
        BookCaseDAOImpl bookCaseDAO = new BookCaseDAOImpl();
        System.out.println(bookCaseDAO.getBookCase(3).getName());
    }

    @Override
    public BookCase getBookCase(long userID) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        BookCase bookCase = null;
        Query query;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("select bc from BookCase bc inner join Users u on bc.id = u.bookCase.id where u.id =: userID");
            query.setParameter("userID", userID);
            bookCase = (BookCase) query.getSingleResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return bookCase;
    }
}
