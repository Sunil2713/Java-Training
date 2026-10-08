<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<nav class="navbar navbar-dark bg-primary"><div class="container"><a class="navbar-brand" href="${pageContext.request.contextPath}/dashboard">Training Application</a><a href="${pageContext.request.contextPath}/login" class="btn btn-outline-light btn-sm">Logout</a></div></nav>
<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h3 class="mb-0">Available Courses</h3>
        <div><a href="${pageContext.request.contextPath}/courses/form" class="btn btn-success">Add Course</a><a href="${pageContext.request.contextPath}/dashboard" class="btn btn-secondary">Dashboard</a></div>
    </div>
    <c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
    <div class="row g-3">
        <c:forEach items="${courses}" var="course">
            <div class="col-md-6 col-lg-4">
                <div class="card shadow-sm h-100">
                    <div class="card-body"><h5 class="card-title"><c:out value="${course.courseName}" /></h5><p class="card-text text-muted"><c:out value="${course.description}" /></p></div>
                    <div class="card-footer bg-white d-flex justify-content-between align-items-center"><span class="text-muted">Course ID: <c:out value="${course.id}" /></span><span><a href="${pageContext.request.contextPath}/courses/form?id=${course.id}" class="btn btn-sm btn-warning">Edit</a><form action="${pageContext.request.contextPath}/courses/delete" method="post" class="d-inline" onsubmit="return confirm('Delete this course?');"><input type="hidden" name="id" value="${course.id}"><button class="btn btn-sm btn-danger">Delete</button></form></span></div>
                </div>
            </div>
        </c:forEach>
    </div>
    <c:if test="${empty courses}"><div class="alert alert-info mt-3">No courses found. Click Add Course to create one.</div></c:if>
</div>
</body>
</html>
