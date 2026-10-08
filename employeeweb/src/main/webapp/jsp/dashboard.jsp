<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">Training Application</a>
        <span class="text-white">Welcome, ${user.fullName}</span>
    </div>
</nav>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-3">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/dashboard" class="list-group-item list-group-item-action active">Dashboard</a>
                <a href="#" class="list-group-item list-group-item-action">My Profile</a>
                <a href="${pageContext.request.contextPath}/courses" class="list-group-item list-group-item-action">Courses</a>
                <a href="#" class="list-group-item list-group-item-action">Settings</a>
                <a href="${pageContext.request.contextPath}/login" class="list-group-item list-group-item-action text-danger">Logout</a>
            </div>
        </div>
        <div class="col-md-9">
            <div class="card shadow">
                <div class="card-header"><h4 class="mb-0">Dashboard</h4></div>
                <div class="card-body">
                    <h5>Welcome ${user.fullName}!</h5>
                    <p class="text-muted">You have successfully logged in.</p>
                    <table class="table table-bordered">
                        <tr><th>Name</th><td>${user.fullName}</td></tr>
                        <tr><th>Email</th><td>${user.email}</td></tr>
                        <tr><th>Role</th><td><span class="badge bg-success">${user.role}</span></td></tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
