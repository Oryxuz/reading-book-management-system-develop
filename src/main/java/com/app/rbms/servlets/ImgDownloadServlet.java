package com.app.rbms.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/upload/img")
public class ImgDownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String path = System.getProperty("user.home") + "\\Uploads" + File.separator + fname;
        response.setContentType("image/jpeg");
        File file = new File(path);
        response.setContentLength((int) file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();

        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }

}
