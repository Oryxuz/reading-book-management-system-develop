package com.app.rbms.daos.impl;

import com.app.rbms.daos.ContainDAO;
import com.app.rbms.entities.Contain;
import com.app.rbms.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ContainDAOImpl implements ContainDAO {

    @Override
    public boolean saveOrUpdate(Contain contain) {
        boolean flag;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(contain);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    @Override
    public boolean delete(Contain contain) {
        boolean flag;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(contain);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }

    @Override
    public boolean delete(long id) {
        boolean flag;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        Query query;
        try {
            tx = session.beginTransaction();
            query = session.createQuery("delete from Contain where bookCase.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return flag;
    }
}
