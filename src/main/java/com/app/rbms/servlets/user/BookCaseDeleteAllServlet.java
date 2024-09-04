package com.app.rbms.servlets.user;

import com.app.rbms.daos.impl.ContainDAOImpl;
import com.app.rbms.entities.User;
import com.app.rbms.services.ContainService;
import com.app.rbms.services.impl.ContainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/bookcase/deleteAll"})
public class BookCaseDeleteAllServlet extends HttpServlet {

    private final ContainService containService = new ContainServiceImpl(new ContainDAOImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        int statusCode;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginedUser");
        if (containService.deleteContain(user.getBookCase().getId())) {
            message = "Delele all succesfully !";
            statusCode = 200;
        } else {
            message = "Can't delete :)))";
            statusCode = 401;
        }
        resp.addHeader("X-Message", message);
        resp.setStatus(statusCode);
    }
}
