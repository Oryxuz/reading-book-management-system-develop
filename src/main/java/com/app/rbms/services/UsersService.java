package com.app.rbms.services;

import com.app.rbms.entities.User;

public interface UsersService {
   User login(String username, String password);

   User register(User user);
}
