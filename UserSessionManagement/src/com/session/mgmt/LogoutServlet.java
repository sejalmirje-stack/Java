package com.session.mgmt;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String username = "User";

        if (session != null) {
            username = (String) session.getAttribute("username");
            // session.invalidate() - Terminates the current session completely
            session.invalidate();
        }

        out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Logged Out</title>");
        out.println("<style>");
        out.println("body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background-color: #f4f6f9; color: #333; padding: 40px 20px; display: flex; justify-content: center; }");
        out.println(".card { background: #fff; padding: 32px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.08); max-width: 480px; width: 100%; text-align: center; }");
        out.println("h2 { color: #e74c3c; margin-top: 0; }");
        out.println(".btn { display: inline-block; padding: 10px 20px; background-color: #3498db; color: white; border-radius: 4px; text-decoration: none; font-weight: bold; margin-top: 15px; }");
        out.println(".btn:hover { background-color: #2980b9; }");
        out.println("</style></head><body>");

        out.println("<div class='card'>");
        out.println("<h2>Session Terminated</h2>");
        out.println("<p>Goodbye, <strong>" + (username != null ? username : "User") + "</strong>! You have been successfully logged out.</p>");
        out.println("<p>The <code>session.invalidate()</code> method destroyed your session.</p>");
        out.println("<a class='btn' href='index.html'>Login Again</a>");
        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
