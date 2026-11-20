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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Check if an existing session exists (do not create a new one)
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            // No active session -> redirect to login
            response.sendRedirect("index.html");
            return;
        }

        // 3. session.getAttribute() - Retrieves stored user information
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");
        String loginTime = (String) session.getAttribute("loginTime");

        // 4. session.getId() - Returns unique session identifier
        String sessionId = session.getId();

        // 5. session.isNew() - Checks whether the session was newly created
        boolean isNew = session.isNew();

        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessed = new Date(session.getLastAccessedTime());
        int maxInactive = session.getMaxInactiveInterval();

        out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Session Dashboard</title>");
        out.println("<style>");
        out.println("body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background-color: #f4f6f9; color: #333; padding: 40px 20px; display: flex; justify-content: center; }");
        out.println(".dashboard-card { background: #fff; padding: 32px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.08); max-width: 620px; width: 100%; }");
        out.println("h2 { color: #27ae60; margin-top: 0; border-bottom: 2px solid #27ae60; padding-bottom: 10px; }");
        out.println(".info-row { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #eee; }");
        out.println(".badge { background: #eef2f7; padding: 3px 8px; border-radius: 4px; font-family: monospace; font-size: 13px; }");
        out.println(".btn { display: inline-block; padding: 10px 18px; border-radius: 4px; text-decoration: none; font-weight: bold; font-size: 14px; margin-right: 10px; margin-top: 20px; }");
        out.println(".btn-logout { background-color: #e74c3c; color: white; }");
        out.println(".btn-logout:hover { background-color: #c0392b; }");
        out.println(".btn-remove { background-color: #e67e22; color: white; }");
        out.println(".btn-remove:hover { background-color: #d35400; }");
        out.println("</style></head><body>");

        out.println("<div class='dashboard-card'>");
        out.println("<h2>Welcome, " + username + "!</h2>");
        out.println("<p>Your session is active and being maintained across HTTP requests.</p>");

        out.println("<div class='info-row'><strong>Username [session.getAttribute()]:</strong> <span>" + username + "</span></div>");
        out.println("<div class='info-row'><strong>User Role:</strong> <span>" + (role != null ? role : "<em style='color:#e67e22;'>Attribute Removed</em>") + "</span></div>");
        out.println("<div class='info-row'><strong>Login Time:</strong> <span>" + loginTime + "</span></div>");
        out.println("<div class='info-row'><strong>Session ID [session.getId()]:</strong> <span class='badge'>" + sessionId + "</span></div>");
        out.println("<div class='info-row'><strong>Is Session Newly Created? [session.isNew()]:</strong> <span>" + isNew + "</span></div>");
        out.println("<div class='info-row'><strong>Session Created At:</strong> <span>" + creationTime + "</span></div>");
        out.println("<div class='info-row'><strong>Last Accessed At:</strong> <span>" + lastAccessed + "</span></div>");
        out.println("<div class='info-row'><strong>Max Inactive Interval:</strong> <span>" + maxInactive + " seconds</span></div>");

        out.println("<div style='margin-top:24px;'>");
        if (role != null) {
            out.println("<a class='btn btn-remove' href='RemoveAttributeServlet'>Test session.removeAttribute('role')</a>");
        }
        out.println("<a class='btn btn-logout' href='LogoutServlet'>Logout (session.invalidate())</a>");
        out.println("</div>");

        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
