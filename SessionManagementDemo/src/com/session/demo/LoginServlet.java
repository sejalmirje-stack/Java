package com.session.demo;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple hardcoded validation (password: 1234)
        if (username != null && password != null && password.equals("1234")) {
            // Create session (or get existing one)
            HttpSession session = request.getSession(true);
            // Store user data as session attributes
            session.setAttribute("username", username);
            session.setAttribute("loginTime", new java.util.Date());
            // Set session timeout (in seconds) - 15 minutes
            session.setMaxInactiveInterval(15 * 60);
            response.sendRedirect("welcome.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html><html><head><title>Login Failed</title></head><body>");
            out.println("<h3 style='color:red;'>Invalid credentials! Password is 1234</h3>");
            out.println("<p><a href='login.html'>Try again</a></p>");
            out.println("</body></html>");
        }
    }
}
