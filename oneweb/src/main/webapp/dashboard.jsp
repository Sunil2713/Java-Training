<%@ page import="com.training.model.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
    <h1>!!! Dashboard !!!</h1>
    <h1>Welcome to Dover</h1>
    <p><a href="users.jsp">Manage users</a></p>
</body>
</html>
