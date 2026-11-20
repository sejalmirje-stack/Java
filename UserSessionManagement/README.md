# UserSessionManagement - HttpSession API Demonstration

This project is a ready-to-run **Eclipse Dynamic Web Project** implementing the complete **User Session Management System** using pure Java Servlets and the `HttpSession` API as described in your lab manual.

---

## 📁 Project Structure

```text
UserSessionManagement/
├── .classpath                             # Eclipse build path config
├── .project                               # Eclipse project definition
├── .settings/                             # Eclipse Dynamic Web facet settings (Java 21)
├── LAB_REPORT.md                          # Full Lab Report (Aim, Theory, Result, Conclusion)
├── src/
│   └── com/session/mgmt/
│       ├── LoginServlet.java              # getSession(), setAttribute(), getId(), isNew()
│       ├── DashboardServlet.java          # getSession(false), getAttribute(), session info
│       ├── RemoveAttributeServlet.java    # removeAttribute()
│       └── LogoutServlet.java             # invalidate()
├── WebContent/
│   ├── index.html                         # Login UI
│   └── WEB-INF/
│       ├── web.xml                        # Web descriptor (15 min session timeout)
│       ├── lib/
│       │   └── jakarta.servlet-api-6.0.0.jar # Pre-bundled Servlet API jar (Tomcat 11)
│       └── classes/
│           └── com/session/mgmt/*.class   # Pre-compiled with Java 21 bytecode (v65.0)
└── README.md
```

---

## 🚀 How to Import and Run in Eclipse IDE

1. **Import the Project:**
   * In Eclipse, click **File** → **Import...**
   * Select **General** → **Existing Projects into Workspace** → click **Next >**.
   * Under **Select root directory**, browse to:
     ```text
     C:\Users\PRASANNA\Desktop\AJT POE\UserSessionManagement
     ```
   * Ensure `UserSessionManagement` is checked, then click **Finish**.

2. **Run on Tomcat Server:**
   * Right-click `UserSessionManagement` in **Project Explorer**.
   * Select **Run As** → **Run on Server**.
   * Choose your configured **`apache-tomcat-11.0.4 at localhost`** server and click **Finish**.

---

## 🧪 Testing the Experiment

1. Open your browser to:
   ```text
   http://localhost:8085/UserSessionManagement/
   ```
2. **Log In:**
   * Enter any username (e.g. `Admin`) and password (e.g. `1234`).
   * Click **Login (Create Session)**.
3. **Session Dashboard:**
   * Demonstrates:
     - `session.getAttribute("username")`
     - `session.getId()` (Unique session token)
     - `session.isNew()` (Session creation check)
     - `session.getCreationTime()` & `session.getLastAccessedTime()`
4. **Test `session.removeAttribute()`:**
   * Click the orange button to remove the `role` attribute from session.
5. **Test `session.invalidate()`:**
   * Click **Logout** to terminate the session and observe the logout confirmation.
