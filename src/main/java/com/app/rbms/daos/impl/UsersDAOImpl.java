package com.app.rbms.daos.impl;

import com.app.rbms.daos.UsersDAO;
import com.app.rbms.entities.User;
import com.app.rbms.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UsersDAOImpl implements UsersDAO {

   @Override
   public User getUser(String username, String password) {
      User user = null;
      Session session = HibernateUtils.getSessionFactory().openSession();
      try {
         Query query = session.createQuery("from Users where userName = :username and password = :password");
         query.setParameter("username", username);
         query.setParameter("password", password);
         user = (User) query.uniqueResult();
      } catch (Exception e) {
         if (session != null) {
            session.close();
         }
         e.printStackTrace();
      }
      return user;
   }

   public User addUser(User user) {
      Session session = HibernateUtils.getSessionFactory().openSession();
      session.beginTransaction();
      try {
         session.save(user);
         session.getTransaction().commit();
      } catch (Exception e) {
         if (session != null) {
            session.close();
         }
         e.printStackTrace();
      }
      return user;
   }
}
