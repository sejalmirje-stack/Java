# JavaWebSocketChat - Real-Time Chat Application Using Jakarta WebSocket API (Experiment 6)

This project implements a complete multi-client real-time chat application using native **Jakarta WebSocket API (`@ServerEndpoint("/chat")`)** running on **Apache Tomcat 11**.

---

## 📁 Project Structure

```text
JavaWebSocketChat/
├── .classpath
├── .project
├── .settings/
├── src/
│   └── com/chat/websocket/
│       └── ChatWebSocketServer.java       # Broadcasts WebSocket messages across clients
├── WebContent/
│   ├── index.html                         # Real-time WebSocket chat client
│   └── WEB-INF/
│       ├── web.xml                        # Web descriptor
│       ├── lib/                           # Bundled WebSocket & Tomcat libraries
│       │   ├── jakarta.servlet-api-6.0.0.jar
│       │   ├── websocket-api.jar
│       │   ├── websocket-client-api.jar
│       │   └── tomcat-websocket.jar
│       └── classes/
│           └── com/chat/websocket/
│               └── ChatWebSocketServer.class # Pre-compiled with Java 21 bytecode
└── README.md
```

---

## 🚀 How to Run in Eclipse IDE (Tomcat)

1. **Import the Project:**
   * In Eclipse, click **File** → **Import...**
   * Select **General** → **Existing Projects into Workspace** → click **Next >**.
   * Under **Select root directory**, browse to:
     ```text
     C:\Users\PRASANNA\Desktop\AJT POE\JavaWebSocketChat
     ```
   * Ensure `JavaWebSocketChat` is checked, then click **Finish**.

2. **Run on Tomcat Server:**
   * Right-click `JavaWebSocketChat` in **Project Explorer**.
   * Select **Run As** → **Run on Server**.
   * Choose your configured **`apache-tomcat-11.0.4 at localhost`** server and click **Finish**.

---

## 🧪 Testing Multi-Client Chat

1. Open your browser and navigate to:
   ```text
   http://localhost:8085/JavaWebSocketChat/
   ```
2. Open the **same URL in a second browser tab or window**.
3. Type a message in one tab and press **Enter** or click **Send**.
4. The message will appear instantly in both tabs without reloading!
