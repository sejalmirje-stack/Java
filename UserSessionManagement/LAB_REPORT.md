# Lab Experiment: Develop a User Session Management System Using HttpSession API

## Title
**Develop a User Session Management System Using HttpSession API**

## Aim
To develop a user session management system using the `HttpSession` API in Java Servlets to maintain user-specific information across multiple HTTP requests.

## Objectives
1. To understand the concept of session management in web applications.
2. To learn how to create and manage sessions using the `HttpSession` API.
3. To store and retrieve user information during a session.
4. To understand session creation, tracking, and termination.
5. To implement login and logout functionality using sessions.

---

## Theory
HTTP is a stateless protocol, which means that the web server does not automatically remember information about a user between different HTTP requests. Session management is used to maintain user-specific information across multiple requests.

The Java Servlet API provides the `HttpSession` interface for managing user sessions. A session is created when a user accesses a web application and can be used to store attributes such as username, user ID, shopping cart information, or other temporary data.

### Important HttpSession Methods
- `request.getSession()` – Creates a new session or returns the existing session associated with the user.
- `session.setAttribute(String name, Object value)` – Stores information in the session.
- `session.getAttribute(String name)` – Retrieves information stored in the session.
- `session.removeAttribute(String name)` – Removes a particular attribute from the session.
- `session.invalidate()` – Terminates the current session.
- `session.getId()` – Returns the unique session ID.
- `session.isNew()` – Checks whether the session is newly created.
- `session.getCreationTime()` – Returns the time when this session was created.
- `session.getLastAccessedTime()` – Returns the last time the client sent a request associated with this session.
- `session.setMaxInactiveInterval(int interval)` – Specifies the time, in seconds, between client requests before the servlet container invalidates this session.

---

## Working of Session Management
1. The user sends a request to the web application (e.g., submitting the login form).
2. The Servlet creates or retrieves an `HttpSession` object using `request.getSession()`.
3. User information is stored in the session using session attributes (`session.setAttribute()`).
4. The stored information can be accessed during subsequent requests (`session.getAttribute()`).
5. When the user logs out, the session is invalidated using `session.invalidate()`.

---

## Code Example Implemented in Project
```java
// 1. Create or get session
HttpSession session = request.getSession();

// 2. Store username in session
session.setAttribute("username", "Admin");

// 3. Retrieve username
String username = (String) session.getAttribute("username");

// 4. Display username
response.getWriter().println("Welcome, " + username);

// 5. Remove an attribute
session.removeAttribute("role");

// 6. Terminate session on logout
session.invalidate();
```

---

## Result
The user session management system was successfully developed using the `HttpSession` API. User information was stored and retrieved successfully across multiple HTTP requests, and the session was successfully terminated using the `invalidate()` method.

## Conclusion
Thus, a user session management system was successfully implemented using the `HttpSession` API. The experiment demonstrated how sessions can be created, maintained, accessed, and invalidated to manage user-specific information in a Java web application.
