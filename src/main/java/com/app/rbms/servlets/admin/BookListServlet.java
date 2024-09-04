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

@WebServlet(urlPatterns = {"/admin/book/list"})
public class BookListServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl(new BookDAOImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", bookService.getAllBooks());
        request.getRequestDispatcher("/views/admin/list-book.jsp").forward(request, response);
    }
}
