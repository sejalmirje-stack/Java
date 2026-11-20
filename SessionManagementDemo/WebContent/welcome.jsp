<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome - User Session</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            background-color: #f4f6f9;
            color: #333;
            margin: 0;
            padding: 40px 20px;
            display: flex;
            justify-content: center;
        }
        .dashboard-card {
            background: #fff;
            padding: 32px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            max-width: 600px;
            width: 100%;
        }
        h2 {
            margin-top: 0;
            color: #27ae60;
            border-bottom: 2px solid #27ae60;
            padding-bottom: 10px;
        }
        .info-row {
            padding: 10px 0;
            border-bottom: 1px solid #eee;
            display: flex;
            justify-content: space-between;
        }
        .info-row strong {
            color: #555;
        }
        .btn-logout {
            display: inline-block;
            margin-top: 24px;
            background-color: #e74c3c;
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 4px;
            font-weight: bold;
            transition: background-color 0.2s;
        }
        .btn-logout:hover {
            background-color: #c0392b;
        }
        .badge {
            background: #eef2f7;
            padding: 2px 6px;
            border-radius: 4px;
            font-family: monospace;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<%
    HttpSession userSession = request.getSession(false); // don't create new one
    if (userSession == null || userSession.getAttribute("username") == null) {
        response.sendRedirect("login.html");
    } else {
        String username = (String) userSession.getAttribute("username");
        Date loginTime = (Date) userSession.getAttribute("loginTime");
%>
    <div class="dashboard-card">
        <h2>Welcome, <%= username %>!</h2>
        
        <div class="info-row">
            <strong>Login Time:</strong>
            <span><%= loginTime %></span>
        </div>
        <div class="info-row">
            <strong>Session ID:</strong>
            <span class="badge"><%= userSession.getId() %></span>
        </div>
        <div class="info-row">
            <strong>Session Created At:</strong>
            <span><%= new Date(userSession.getCreationTime()) %></span>
        </div>
        <div class="info-row">
            <strong>Last Accessed At:</strong>
            <span><%= new Date(userSession.getLastAccessedTime()) %></span>
        </div>
        <div class="info-row">
            <strong>Session Inactive Timeout:</strong>
            <span><%= userSession.getMaxInactiveInterval() %> seconds (15 mins)</span>
        </div>

        <a class="btn-logout" href="LogoutServlet">Logout</a>
    </div>
<%
    }
%>
</body>
</html>
