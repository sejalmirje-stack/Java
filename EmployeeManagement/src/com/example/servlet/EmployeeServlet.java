package com.example.servlet;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO dao = new EmployeeDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if (action == null || action.isEmpty()) {
                action = "list";
            }
            switch (action) {
                case "new":
                    req.getRequestDispatcher("addEmployee.jsp").forward(req, resp);
                    break;
                case "edit":
                    int id = Integer.parseInt(req.getParameter("id"));
                    Employee emp = dao.getEmployeeById(id);
                    req.setAttribute("employee", emp);
                    req.getRequestDispatcher("editEmployee.jsp").forward(req, resp);
                    break;
                case "delete":
                    dao.deleteEmployee(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect("employee?action=list");
                    break;
                case "list":
                default:
                    List<Employee> list = dao.getAllEmployees();
                    req.setAttribute("employeeList", list);
                    req.getRequestDispatcher("listEmployees.jsp").forward(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException("Database Error in EmployeeServlet: " + e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        String salaryStr = req.getParameter("salary");
        double salary = (salaryStr != null && !salaryStr.isEmpty()) ? Double.parseDouble(salaryStr) : 0.0;
        String idParam = req.getParameter("id");

        try {
            Employee emp = new Employee();
            emp.setName(name);
            emp.setEmail(email);
            emp.setDepartment(department);
            emp.setSalary(salary);

            if (idParam != null && !idParam.trim().isEmpty()) {
                emp.setId(Integer.parseInt(idParam.trim()));
                dao.updateEmployee(emp);
            } else {
                dao.addEmployee(emp);
            }
            resp.sendRedirect("employee?action=list");
        } catch (SQLException e) {
            throw new ServletException("Database Error while saving employee: " + e.getMessage(), e);
        }
    }
}
