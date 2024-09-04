package com.app.rbms.servlets.user;

import com.app.rbms.daos.impl.BookCaseDAOImpl;
import com.app.rbms.daos.impl.BookDAOImpl;
import com.app.rbms.daos.impl.ContainDAOImpl;
import com.app.rbms.entities.Book;
import com.app.rbms.entities.BookCase;
import com.app.rbms.entities.Contain;
import com.app.rbms.entities.User;
import com.app.rbms.services.BookCaseService;
import com.app.rbms.services.BookService;
import com.app.rbms.services.ContainService;
import com.app.rbms.services.impl.BookCaseServiceImpl;
import com.app.rbms.services.impl.BookServiceImpl;
import com.app.rbms.services.impl.ContainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/user/bookcase/delete"})
public class BookCaseDeleteServlet extends HttpServlet {

    private final BookService bookService = new BookServiceImpl(new BookDAOImpl());
    private final BookCaseService bookCaseService = new BookCaseServiceImpl(new BookCaseDAOImpl());
    private final ContainService containService = new ContainServiceImpl(new ContainDAOImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loginedUser");
        String message;
        int statusCode;
        String bookID = req.getParameter("bookID");
        Book book = bookService.getBookById(Integer.parseInt(bookID));
        BookCase bookCase = bookCaseService.getBookCase(user.getId());
        Contain contain = new Contain();
        contain.setBook(book);
        contain.setBookCase(bookCase);
        if (containService.deleteContain(contain)) {
            message = "Success!";
            statusCode = 200;
        } else {
            message = "Fail!";
            statusCode = 401;
        }
        resp.addHeader("X-Message", message);
        resp.setStatus(statusCode);
    }
}
