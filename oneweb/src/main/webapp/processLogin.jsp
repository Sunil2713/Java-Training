<%@ page import="com.training.model.User" %>
<%@ page import="com.training.service.UserService" %>
<%@ page import="com.training.service.impl.UserServiceImpl" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    UserService userService = new UserServiceImpl();
    User user = userService.isValidUser(username, password);

    if (user == null) {
        response.sendRedirect("login.jsp?error=invalid");
        return;
    }

    session.setAttribute("user", user);
    response.sendRedirect("dashboard.jsp");
%>
