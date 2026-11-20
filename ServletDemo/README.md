# ServletDemo - Implement a Java Servlet to Handle HTTP Requests

This project is a ready-to-run **Eclipse Dynamic Web Project** that implements `MyServlet` to handle HTTP requests (GET and POST).

---

## 📁 Project Structure

```text
ServletDemo/
├── .classpath                     # Eclipse classpath configuration
├── .project                       # Eclipse project definition
├── .settings/                     # Eclipse Web Project Facets & Settings
├── src/
│   └── MyServlet.java             # Servlet source code
├── WebContent/
│   ├── index.html                 # Welcome testing page
│   └── WEB-INF/
│       ├── web.xml                # Deployment descriptor (mapping /hello to MyServlet)
│       ├── lib/
│       │   └── javax.servlet-api-4.0.1.jar  # Servlet API library
│       └── classes/
│           └── MyServlet.class    # Compiled servlet class
└── README.md                      # Instructions
```

---

## 🚀 How to Import and Run in Eclipse IDE

### Step 1: Open Eclipse IDE
Make sure you are using **Eclipse IDE for Enterprise Java and Web Developers** (formerly Eclipse for Java EE).

### Step 2: Import the Project
1. In Eclipse, go to **File** → **Import...**
2. Expand **General** and select **Existing Projects into Workspace** (or **Projects from Folder or Archive**).
3. Click **Next**.
4. In **Select root directory**, click **Browse...** and select this `ServletDemo` folder:
   `c:\Users\PRASANNA\Desktop\AJT POE\ServletDemo`
5. Ensure `ServletDemo` is checked in the Projects list.
6. Click **Finish**.

### Step 3: Configure Apache Tomcat Server (If not already configured)
1. Go to the **Servers** tab at the bottom (if hidden, go to `Window` → `Show View` → `Servers`).
2. Click the link: *"No servers are available. Click this link to create a new server..."*
3. Under **Apache**, select your installed version (e.g., **Tomcat v9.0 Server**).
4. Click **Next**, browse to your **Tomcat installation directory**, and select your JRE/JDK.
5. Click **Finish**.

### Step 4: Run the Application on Server
1. Right-click on the `ServletDemo` project in **Project Explorer**.
2. Select **Run As** → **Run on Server**.
3. Choose your configured **Apache Tomcat** server.
4. Check *"Always use this server when running this project"* (optional).
5. Click **Finish**.

---

## 🌐 Testing the Servlet

Tomcat will launch and start the application.

1. **Test via Browser directly:**
   Open your browser and navigate to:
   ```text
   http://localhost:8080/ServletDemo/hello
   ```
   **Output:**
   ```html
   Hello! GET Request Received
   ```

2. **Test via Welcome Page:**
   Navigate to:
   ```text
   http://localhost:8080/ServletDemo/
   ```
   Click the **"Send GET Request to /hello"** button to view the response.

---

> [!NOTE]
> If you are using **Apache Tomcat 10 or 11**, the package changed from `javax.servlet` to `jakarta.servlet`. If using Tomcat 10+, simply replace `javax.servlet` with `jakarta.servlet` in `MyServlet.java`. For Tomcat 8.5/9.0, `javax.servlet` is used as currently configured.
