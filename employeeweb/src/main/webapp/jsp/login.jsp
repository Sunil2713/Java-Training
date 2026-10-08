<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
 
<head>
 
    <meta charset="UTF-8">
 
    <title>User Login</title>
 
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
 
</head>
 
<body class="bg-light">
 
<div class="container">
 
    <div class="row justify-content-center mt-5">
 
        <div class="col-md-5">
 
            <div class="card shadow">
 
                <!-- Header -->
 
                <div class="card-header bg-primary text-white text-center">
 
                    <h4 class="mb-0">
                        User Login
                    </h4>
 
                </div>
 
 
                <div class="card-body">
 
 
                    <!-- Authentication Failure -->
 
                    <%
                        String error = (String) request.getAttribute("error");
 
                        if (error != null) {
                    %>
 
                        <div class="alert alert-danger">
                            <%= error %>
                        </div>
 
                    <%
                        }
                    %>
 
 
                    <!-- Login Form -->
 
                    <form:form
                        action="login"
                        method="post"
                        modelAttribute="loginForm">
 
 
                        <!-- Email -->
 
                        <div class="mb-3">
 
                            <form:label
                                path="email"
                                cssClass="form-label">
 
                                Email
 
                            </form:label>
 
 
                            <form:input
                                path="email"
                                type="email"
                                cssClass="form-control"
                                placeholder="Enter your email"/>
 
 
                            <!-- Email Validation Error -->
 
                            <form:errors
                                path="email"
                                cssClass="text-danger"/>
 
                        </div>
 
 
                        <!-- Password -->
 
                        <div class="mb-3">
 
                            <form:label
                                path="password"
                                cssClass="form-label">
 
                                Password
 
                            </form:label>
 
 
                            <form:password
                                path="password"
                                cssClass="form-control"
                                placeholder="Enter your password"/>
 
 
                            <!-- Password Validation Error -->
 
                            <form:errors
                                path="password"
                                cssClass="text-danger"/>
 
                        </div>
 
 
                        <!-- Login Button -->
 
                        <div class="d-grid">
 
                            <button
                                type="submit"
                                class="btn btn-primary">
 
                                Login
 
                            </button>
 
                        </div>
 
 
                    </form:form>
 
                </div>
 
            </div>
 
        </div>
 
    </div>
 
</div>
 
</body>
 
</html>