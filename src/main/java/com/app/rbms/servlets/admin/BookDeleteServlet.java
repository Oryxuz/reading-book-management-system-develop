package com.app.rbms.servlets.admin;

import com.app.rbms.daos.impl.BookDAOImpl;
import com.app.rbms.services.BookService;
import com.app.rbms.services.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/book/delete"})
public class BookDeleteServlet extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl(new BookDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        int statusCode;
        if (bookService.delete(Integer.parseInt(req.getParameter("id")))) {
            message = "Your item has been deleted.";
            statusCode = 200;
        } else {
            message = "Your item has not been deleted.";
            statusCode = 401;
        }
        resp.addHeader("X-Message", message);
        resp.setStatus(statusCode);
    }
}
