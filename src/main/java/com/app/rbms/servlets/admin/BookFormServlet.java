package com.app.rbms.servlets.admin;

import com.app.rbms.daos.impl.BookDAOImpl;
import com.app.rbms.entities.Book;
import com.app.rbms.services.BookService;
import com.app.rbms.services.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/book/form"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class BookFormServlet extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl(new BookDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("briefs", getBrief());
        req.setAttribute("categories", getCategories());
        if (req.getParameter("id") != null) {
            req.setAttribute("book", bookService.getBookById(Integer.parseInt(req.getParameter("id"))));
        }
        req.getRequestDispatcher("/views/admin/form-book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book;
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String brief = req.getParameter("brief");
        String publisher = req.getParameter("publisher");
        String content = req.getParameter("content");
        String category = req.getParameter("category");
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            book = bookService.getBookById(Long.parseLong(req.getParameter("id")));
            book.setTitle(title);
            book.setAuthor(author);
            book.setBrief(brief);
            book.setPublisher(LocalDate.parse(publisher));
            book.setContent(content);
            book.setCategory(category);
            for (Part part : req.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    book.setImgUrl(fileName);
                    part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                }
            }
        } else {
            book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            book.setBrief(brief);
            book.setPublisher(LocalDate.parse(publisher));
            book.setContent(content);
            book.setCategory(category);
            for (Part part : req.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    book.setImgUrl(fileName);
                    part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
                }
            }
        }
        bookService.saveOrUpdate(book);
        resp.sendRedirect(req.getContextPath().concat("/admin/book/list"));
    }

    private List<String> getBrief() {
        return Arrays.asList("Mr", "Mrs");
    }

    private List<String> getCategories() {
        return Arrays.asList("Hentai", "Fantasy", "Manga", "Horror");
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        System.out.println(folderUpload.getAbsolutePath());
        return folderUpload;
    }
}
