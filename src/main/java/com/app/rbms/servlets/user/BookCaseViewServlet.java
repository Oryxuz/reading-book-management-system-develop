package com.app.rbms.servlets.user;

import com.app.rbms.daos.impl.BookDAOImpl;
import com.app.rbms.entities.User;
import com.app.rbms.services.BookService;
import com.app.rbms.services.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/bookcase"})
public class BookCaseViewServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl(new BookDAOImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginedUser");
        request.setAttribute("books", bookService.getBooks(user.getBookCase().getId()));
        request.getRequestDispatcher("/views/user/bookcase/bookcase.jsp").forward(request, response);
    }

}
