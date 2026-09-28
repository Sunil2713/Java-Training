<%@ page import="com.training.model.User" %>
<%@ page import="com.training.service.UserService" %>
<%@ page import="com.training.service.impl.UserServiceImpl" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int id = Integer.parseInt(request.getParameter("id"));
    UserService userService = new UserServiceImpl();

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        User user = new User();
        user.setUserId(id);
        userService.delete(user);
        response.sendRedirect("users.jsp");
        return;
    }

    User user = userService.getUserById(id);
    if (user == null) {
        response.sendRedirect("users.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
</head>
<body>
    <h1>Delete User</h1>
    <p>Delete <strong><%= user.getUsername() %></strong>?</p>
    <form method="post">
        <button type="submit">Delete</button>
    </form>
    <p><a href="users.jsp">Cancel</a></p>
</body>
</html>
