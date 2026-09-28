<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
 
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
 
        .login-container {
            width: 350px;
            margin: 100px auto;
            padding: 25px;
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
 
        h2 {
            text-align: center;
            margin-bottom: 25px;
        }
 
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
 
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
 
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
 
        input[type="submit"]:hover {
            background-color: #555;
        }
 
        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
</head>
 
<body>
 
    <div class="login-container">
 
        <h2>Login</h2>
 
        <%
            String error = request.getParameter("error");
 
            if ("invalid".equals(error)) {
        %>
            <div class="error">
                Invalid username or password
            </div>
        <%
            }
        %>
 
        <form action="processLogin.jsp" method="post">
 
            <label for="username">Username</label>
            <input type="text"
                   id="username"
                   name="username"
                   placeholder="Enter username"
                   required>
 
            <label for="password">Password</label>
            <input type="password"
                   id="password"
                   name="password"
                   placeholder="Enter password"
                   required>
 
            <input type="submit" value="Login">
 
        </form>
 
    </div>
 
</body>
</html>
 
