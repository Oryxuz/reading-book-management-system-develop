package com.app.rbms.services.impl;

import com.app.rbms.daos.UsersDAO;
import com.app.rbms.entities.User;
import com.app.rbms.services.UsersService;

public class UsersServiceImpl implements UsersService {

   private final UsersDAO usersDAO;

   public UsersServiceImpl(UsersDAO usersDAO) {
      this.usersDAO = usersDAO;
   }

   @Override
   public User login(String username, String password) {
      return usersDAO.getUser(username, password);
   }

   @Override
   public User register(User user) {
      return usersDAO.addUser(user);
   }
}
