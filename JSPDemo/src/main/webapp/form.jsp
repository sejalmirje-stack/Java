
<!DOCTYPE html>
<html>
<head>
    <title>JSP Form Handling</title>
</head>
<body>

    <h2>Student Registration Form</h2>

    <form action="form.jsp" method="post">

        Enter Name:
        <input type="text" name="username" required>
        <br><br>

        Enter Email:
        <input type="email" name="email" required>
        <br><br>

        <input type="submit" value="Submit">

    </form>

    <%
        String name = request.getParameter("username");
        String email = request.getParameter("email");

        if (name != null && email != null) {
    %>

        <h2>Submitted Details</h2>
        <p>Welcome, <%= name %>!</p>
        <p>Your Email: <%= email %></p>

    <%
        }
    %>

</body>
</html>
