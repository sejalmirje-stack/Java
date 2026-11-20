# SessionManagementDemo - User Session Management System using HttpSession API

This project implements a complete User Session Management System using the `HttpSession` API as specified in **Assignment 2**.

---

## 📁 Project Structure

```text
SessionManagementDemo/
├── .classpath
├── .project
├── .settings/
├── src/
│   └── com/session/demo/
│       ├── LoginServlet.java     # Validates user & creates HttpSession
│       └── LogoutServlet.java    # Invalidates/destroys HttpSession
├── WebContent/
│   ├── index.html                # Automatically redirects to login.html
│   ├── login.html                # Login form
│   ├── welcome.jsp               # Dashboard displaying session attributes & time
│   └── WEB-INF/
│       ├── web.xml               # Web deployment descriptor
│       ├── lib/
│       │   └── jakarta.servlet-api-6.0.0.jar
│       └── classes/
│           └── com/session/demo/
│               ├── LoginServlet.class
│               └── LogoutServlet.class
└── README.md
```

---

## 🚀 How to Run in Eclipse IDE

### Step 1: Import the Project
1. In Eclipse, click **File** → **Import...**
2. Choose **General** → **Existing Projects into Workspace** and click **Next**.
3. Under **Select root directory**, browse to:
   ```text
   C:\Users\PRASANNA\Desktop\AJT POE\SessionManagementDemo
   ```
4. Ensure `SessionManagementDemo` is checked and click **Finish**.

### Step 2: Run on Tomcat Server
1. Right-click on `SessionManagementDemo` in Project Explorer.
2. Select **Run As** → **Run on Server**.
3. Choose your existing **apache-tomcat-11.0.4 at localhost** server.
4. Click **Finish**.

---

## 🧪 How to Test the Application

1. Open your browser and go to:
   ```text
   http://localhost:8081/SessionManagementDemo/login.html
   ```
   *(Or port `8080` if you are using default port)*

2. **Login Credentials:**
   - **Username:** Any name (e.g. `Prasanna` or `admin`)
   - **Password:** `1234`

3. **Welcome Page (`welcome.jsp`):**
   - You will see session information:
     - Username
     - Login Time
     - Session ID
     - Session creation time & last accessed time
     - Inactive timeout (15 minutes)

4. **Logout (`LogoutServlet`):**
   - Click the **Logout** button.
   - The session will be invalidated via `session.invalidate()` and redirect you back to `login.html`.
   - If you try to access `welcome.jsp` directly without logging in, it will protect the page and redirect you back to `login.html`.
