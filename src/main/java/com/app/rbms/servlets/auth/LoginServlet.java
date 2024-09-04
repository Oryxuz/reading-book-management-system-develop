package com.app.rbms.servlets.auth;

import com.app.rbms.daos.impl.UsersDAOImpl;
import com.app.rbms.entities.User;
import com.app.rbms.services.UsersService;
import com.app.rbms.services.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", description = "This is login servlet")
public class LoginServlet extends HttpServlet {

    UsersService usersService = new UsersServiceImpl(new UsersDAOImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String message;
        int statusCode;
        try {
            User user = usersService.login(userName, password);
            if (user != null) {
                session = req.getSession(true);
                session.setAttribute("loginedUser", user);
                message = "Success !";
                statusCode = 200;
            } else {
                message = "Invalid username or password !";
                statusCode = 401;
            }
            resp.addHeader("X-Message", message);
            resp.setStatus(statusCode);
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath().concat("/404"));
        }
    }
}
