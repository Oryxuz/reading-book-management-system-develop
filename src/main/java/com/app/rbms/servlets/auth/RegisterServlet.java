package com.app.rbms.servlets.auth;

import com.app.rbms.daos.impl.UsersDAOImpl;
import com.app.rbms.entities.BookCase;
import com.app.rbms.entities.Role;
import com.app.rbms.entities.User;
import com.app.rbms.services.UsersService;
import com.app.rbms.services.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final UsersService usersService = new UsersServiceImpl(new UsersDAOImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Role role = new Role();
        BookCase bookCase = new BookCase();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        user.setUserName(username);
        user.setPassword(password);
        role.setId(2L);
        bookCase.setId(user.getId());
        bookCase.setName(username);
        user.setRole(role);
        user.setBookCase(bookCase);
        if (usersService.register(user) != null) {
            resp.addHeader("X-Message", "User registered successfully !");
        } else {
            resp.addHeader("X-Message", "Something went wrong !");
        }
    }
}
