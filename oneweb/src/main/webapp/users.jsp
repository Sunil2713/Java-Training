<%@ page import="java.util.List" %>
<%@ page import="com.training.model.User" %>
<%@ page import="com.training.service.UserService" %>
<%@ page import="com.training.service.impl.UserServiceImpl" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    UserService userService = new UserServiceImpl();
    List<User> users = userService.getAllUsers();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
    <h1>Users</h1>
    <p><a href="dashboard.jsp">Dashboard</a> | <a href="addUser.jsp">Add user</a></p>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Full name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Actions</th>
        </tr>
        <% for (User listedUser : users) { %>
        <tr>
            <td><%= listedUser.getUserId() %></td>
            <td><%= listedUser.getUsername() %></td>
            <td><%= listedUser.getFullName() %></td>
            <td><%= listedUser.getEmail() %></td>
            <td><%= listedUser.getRole() %></td>
            <td>
                <a href="editUser.jsp?id=<%= listedUser.getUserId() %>">Edit</a>
                <a href="deleteUser.jsp?id=<%= listedUser.getUserId() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
