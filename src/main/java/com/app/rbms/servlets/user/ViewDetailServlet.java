package com.app.rbms.servlets.user;

import com.app.rbms.daos.impl.BookDAOImpl;
import com.app.rbms.services.BookService;
import com.app.rbms.services.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/book/detail"})
public class ViewDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl(new BookDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            req.setAttribute("book", bookService.getBookById(Integer.parseInt(req.getParameter("id"))));
        }
        req.getRequestDispatcher("/views/user/book/book-detail.jsp").forward(req, resp);
    }
}
