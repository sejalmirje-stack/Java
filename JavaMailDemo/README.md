# JavaMailDemo - Sending Emails using JavaMail API (Experiment 5)

This project implements a web application configured with the JavaMail (Jakarta Mail) API to compose and send emails via SMTP (e.g. Gmail SMTP).

---

## 📁 Project Structure

```text
JavaMailDemo/
├── .classpath
├── .project
├── .settings/
├── src/
│   └── SendEmailServlet.java               # Servlet creating SMTP Session & sending email
├── WebContent/
│   ├── index.html                          # Email form (To, Subject, Message)
│   └── WEB-INF/
│       ├── web.xml                         # Deployment descriptor
│       ├── lib/
│       │   ├── jakarta.servlet-api-6.0.0.jar
│       │   ├── jakarta.mail-api-2.1.3.jar  # Jakarta Mail API
│       │   ├── angus-mail-2.0.3.jar        # Eclipse Angus Mail Provider
│       │   ├── jakarta.activation-api-2.1.3.jar
│       │   └── angus-activation-2.0.2.jar
│       └── classes/
│           └── SendEmailServlet.class      # Pre-compiled with Java 21 bytecode
└── README.md
```

---

## 🚀 Step 1: Import into Eclipse IDE

1. In Eclipse, go to **File** → **Import...**
2. Select **General** → **Existing Projects into Workspace** → click **Next >**.
3. In **Select root directory**, browse to:
   ```text
   C:\Users\PRASANNA\Desktop\AJT POE\JavaMailDemo
   ```
4. Ensure `JavaMailDemo` is checked, then click **Finish**.

---

## 🌐 Step 2: Run on Tomcat Server

1. In **Project Explorer**, right-click `JavaMailDemo`.
2. Select **Run As** → **Run on Server**.
3. Choose your configured **apache-tomcat-11.0.4 at localhost** server.
4. Click **Finish**.

---

## 🧪 Step 3: Test Sending an Email

Open your browser to:
```text
http://localhost:8085/JavaMailDemo/
```

1. Enter the recipient email address, subject, and message.
2. *(Optional)* Click **"Sender SMTP Credentials"** to specify your own Gmail and 16-character Google App Password.
3. Click **Send Email**.
