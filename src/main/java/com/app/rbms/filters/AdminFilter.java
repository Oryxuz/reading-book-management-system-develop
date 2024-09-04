package com.app.rbms.filters;

import com.app.rbms.entities.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/admin/*")
public class AdminFilter implements Filter {

   public void init(FilterConfig config) throws ServletException {
      System.out.println("AdminFilter init");
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
      HttpServletRequest req = (HttpServletRequest) request;
      HttpServletResponse resq = (HttpServletResponse) response;
      HttpSession session = req.getSession();
      Object obj = session.getAttribute("loginedUser");
      User user = (User) obj;
      if (obj != null && user.getRole().getId() == 1) {
         chain.doFilter(request, response);
         return;
      } else {
         resq.sendRedirect(req.getContextPath().concat("/logout"));
      }
   }

   public void destroy() {
      System.out.println("AdminFilter destroy");
   }
}
