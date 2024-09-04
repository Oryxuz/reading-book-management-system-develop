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

@WebServlet(urlPatterns = {"/user/book/list"})
public class ViewBookServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl(new BookDAOImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", bookService.getAllBooks());
        request.getRequestDispatcher("/views/user/list-book.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String option = req.getParameter("option");
        req.setAttribute("books", bookService.getBooks(keyword, option));
        req.getRequestDispatcher("/views/user/list-book.jsp").forward(req, resp);
    }
}
