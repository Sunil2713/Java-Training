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
        User user = new User(id, request.getParameter("username"), request.getParameter("password"),
                request.getParameter("fullName"), request.getParameter("email"), request.getParameter("role"));
        userService.update(user);
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
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form method="post">
        <label>Username <input type="text" name="username" value="<%= user.getUsername() %>" required></label><br>
        <label>Password <input type="password" name="password" value="<%= user.getPassword() %>" required></label><br>
        <label>Full name <input type="text" name="fullName" value="<%= user.getFullName() %>" required></label><br>
        <label>Email <input type="email" name="email" value="<%= user.getEmail() %>" required></label><br>
        <label>Role <input type="text" name="role" value="<%= user.getRole() %>" required></label><br>
        <button type="submit">Update</button>
    </form>
    <p><a href="users.jsp">Cancel</a></p>
</body>
</html>
