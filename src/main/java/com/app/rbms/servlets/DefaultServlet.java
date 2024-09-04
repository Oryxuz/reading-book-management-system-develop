package com.app.rbms.servlets;

import com.app.rbms.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/waiting")
public class DefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute("loginedUser") != null) {
            User user = (User) session.getAttribute("loginedUser");
            request.setAttribute("loginedUser", user);
            if (user.getRole().getId() == 1) {
                response.sendRedirect(request.getContextPath().concat("/admin/book/list"));
            } else if (user.getRole().getId() == 2) {
                response.sendRedirect(request.getContextPath().concat("/user/book/list"));
            } else {
                response.sendRedirect(request.getContextPath().concat("/404"));
            }
        } else {
            response.sendRedirect(request.getContextPath().concat("/login"));
        }
    }

}
