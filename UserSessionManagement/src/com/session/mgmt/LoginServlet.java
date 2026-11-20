package com.session.mgmt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && !username.trim().isEmpty() && password != null && !password.trim().isEmpty()) {
            // 1. request.getSession() - Creates or retrieves existing session
            HttpSession session = request.getSession();

            // 2. session.setAttribute() - Stores user info in session
            session.setAttribute("username", username);
            session.setAttribute("role", username.equalsIgnoreCase("Admin") ? "Administrator" : "Standard User");
            session.setAttribute("loginTime", new Date().toString());

            // Set session inactive timeout (15 minutes = 900 seconds)
            session.setMaxInactiveInterval(15 * 60);

            // Redirect to DashboardServlet
            response.sendRedirect("DashboardServlet");
        } else {
            out.println("<!DOCTYPE html><html><head><title>Login Error</title>");
            out.println("<style>body{font-family:sans-serif;padding:40px;background:#f4f6f9;} .card{background:#fff;padding:24px;border-radius:8px;max-width:400px;box-shadow:0 2px 10px rgba(0,0,0,0.1);}</style></head><body>");
            out.println("<div class='card'>");
            out.println("<h3 style='color:#e74c3c;'>Invalid Username or Password</h3>");
            out.println("<p><a href='index.html'>&larr; Try Again</a></p>");
            out.println("</div></body></html>");
        }
    }
}
