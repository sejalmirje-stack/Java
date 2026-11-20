# EmployeeManagement - Database-Driven Web Application Using JSP and Servlets (Experiment 4)

This project implements a complete CRUD (Create, Read, Update, Delete) Employee Management Web Application using JSP, Servlets, and MySQL JDBC.

---

## 📁 Project Structure

```text
EmployeeManagement/
├── .classpath
├── .project
├── .settings/
├── schema.sql                               # MySQL database setup script
├── src/
│   └── com/example/
│       ├── model/
│       │   └── Employee.java                # JavaBean / Model
│       ├── util/
│       │   └── DBConnection.java            # JDBC Database Connection Utility
│       ├── dao/
│       │   └── EmployeeDAO.java             # Data Access Object (CRUD queries)
│       └── servlet/
│           └── EmployeeServlet.java         # Controller Servlet (handles requests)
├── WebContent/
│   ├── index.jsp                            # Auto-redirects to employee?action=list
│   ├── listEmployees.jsp                    # Table of all employees with Edit/Delete
│   ├── addEmployee.jsp                      # Form to add a new employee
│   ├── editEmployee.jsp                     # Form to update an existing employee
│   └── WEB-INF/
│       ├── web.xml                          # Servlet mapping & configuration
│       ├── lib/
│       │   ├── jakarta.servlet-api-6.0.0.jar# Servlet API jar
│       │   └── mysql-connector-j-8.3.0.jar  # MySQL JDBC Driver jar
│       └── classes/
│           └── com/example/
│               ├── model/Employee.class
│               ├── util/DBConnection.class
│               ├── dao/EmployeeDAO.class
│               └── servlet/EmployeeServlet.class
└── README.md
```

---

## 🛠️ Step 1: Set Up MySQL Database

Before running, ensure MySQL server is running, and create the `empdb` database:

1. Open your MySQL Command Line Client or MySQL Workbench.
2. Run the commands in `schema.sql`:
   ```sql
   CREATE DATABASE IF NOT EXISTS empdb;
   USE empdb;

   CREATE TABLE IF NOT EXISTS employee (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL,
       department VARCHAR(50),
       salary DOUBLE
   );

   -- Sample data:
   INSERT INTO employee (name, email, department, salary) VALUES
   ('John Doe', 'john.doe@example.com', 'IT', 75000.00),
   ('Jane Smith', 'jane.smith@example.com', 'HR', 65000.00);
   ```

3. **Check Database Password in Code:**
   Open `src/com/example/util/DBConnection.java`:
   ```java
   private static final String USER = "root";
   private static final String PASSWORD = "root"; // <-- Change to your MySQL password if different
   ```

---

## 🚀 Step 2: Import into Eclipse IDE

1. In Eclipse, go to **File** → **Import...**
2. Select **General** → **Existing Projects into Workspace** → click **Next >**.
3. In **Select root directory**, browse to:
   ```text
   C:\Users\PRASANNA\Desktop\AJT POE\EmployeeManagement
   ```
4. Ensure `EmployeeManagement` is checked, then click **Finish**.

---

## 🌐 Step 3: Run on Tomcat Server

1. In **Project Explorer**, right-click `EmployeeManagement`.
2. Select **Run As** → **Run on Server**.
3. Choose your existing **apache-tomcat-11.0.4 at localhost** server.
4. Click **Finish**.

---

## 🧪 Testing the Application

Navigate to:
```text
http://localhost:8081/EmployeeManagement/
```
*(Or `http://localhost:8081/EmployeeManagement/employee?action=list`)*

You can now:
- **View All Employees:** Displayed in a table with Name, Email, Department, and Salary.
- **Add Employee:** Click "+ Add New Employee", fill in the form, and save.
- **Edit Employee:** Click "Edit" next to any record, modify fields, and click "Update".
- **Delete Employee:** Click "Delete" and confirm the prompt to remove the record from MySQL.
