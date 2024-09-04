package com.app.rbms.daos;

import com.app.rbms.entities.User;

public interface UsersDAO {
   User getUser(String username, String password);

   User addUser(User user);
}
