<%@ page import="com.training.model.User" %>
<%@ page import="com.training.service.UserService" %>
<%@ page import="com.training.service.impl.UserServiceImpl" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        User user = new User(Integer.parseInt(request.getParameter("userId")), request.getParameter("username"),
                request.getParameter("password"), request.getParameter("fullName"), request.getParameter("email"),
                request.getParameter("role"));
        UserService userService = new UserServiceImpl();
        userService.save(user);
        response.sendRedirect("users.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>
    <h1>Add User</h1>
    <form method="post">
        <label>ID <input type="number" name="userId" required></label><br>
        <label>Username <input type="text" name="username" required></label><br>
        <label>Password <input type="password" name="password" required></label><br>
        <label>Full name <input type="text" name="fullName" required></label><br>
        <label>Email <input type="email" name="email" required></label><br>
        <label>Role <input type="text" name="role" required></label><br>
        <button type="submit">Save</button>
    </form>
    <p><a href="users.jsp">Cancel</a></p>
</body>
</html>
