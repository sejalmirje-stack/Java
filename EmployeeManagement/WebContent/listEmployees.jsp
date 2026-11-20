<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
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
        .container {
            background: #fff;
            padding: 32px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            max-width: 900px;
            width: 100%;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #3498db;
            padding-bottom: 12px;
            margin-bottom: 24px;
        }
        h2 {
            margin: 0;
            color: #2c3e50;
        }
        .btn-add {
            background-color: #27ae60;
            color: white;
            text-decoration: none;
            padding: 10px 18px;
            border-radius: 4px;
            font-weight: bold;
            font-size: 14px;
            transition: background-color 0.2s;
        }
        .btn-add:hover {
            background-color: #219150;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        th, td {
            padding: 12px 14px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            color: #2c3e50;
            font-weight: 600;
        }
        tr:hover {
            background-color: #f8fbff;
        }
        .action-link {
            text-decoration: none;
            font-weight: 600;
            padding: 4px 8px;
            border-radius: 4px;
        }
        .edit-link {
            color: #3498db;
        }
        .edit-link:hover {
            text-decoration: underline;
        }
        .delete-link {
            color: #e74c3c;
        }
        .delete-link:hover {
            text-decoration: underline;
        }
        .empty-state {
            text-align: center;
            padding: 30px;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Employee List</h2>
            <a class="btn-add" href="employee?action=new">+ Add New Employee</a>
        </div>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Salary</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employeeList");
                if (employees != null && !employees.isEmpty()) {
                    for (Employee emp : employees) {
            %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><strong><%= emp.getName() %></strong></td>
                    <td><%= emp.getEmail() %></td>
                    <td><%= emp.getDepartment() != null ? emp.getDepartment() : "-" %></td>
                    <td>$<%= String.format("%.2f", emp.getSalary()) %></td>
                    <td>
                        <a class="action-link edit-link" href="employee?action=edit&id=<%= emp.getId() %>">Edit</a> |
                        <a class="action-link delete-link" href="employee?action=delete&id=<%= emp.getId() %>"
                           onclick="return confirm('Are you sure you want to delete employee <%= emp.getName() %>?');">Delete</a>
                    </td>
                </tr>
            <% 
                    }
                } else {
            %>
                <tr>
                    <td colspan="6" class="empty-state">No employees found in the database. Click "+ Add New Employee" above to add one.</td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
