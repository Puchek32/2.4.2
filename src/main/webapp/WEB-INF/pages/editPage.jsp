<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty user.lastName}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.lastName}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.lastName}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.lastName}">
<c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
<c:if test="${!empty user.lastName}">
    <input type="hidden" name="id" value="${user.id}">
</c:if>
    <label for="firstName">FirstName</label>
    <input type="text" name="firstName" id="firstName" value="${user.firstName}">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName" value="${user.lastName}">
    <label for="age">Age</label>
    <input type="text" name="age" id="age" value="${user.age}">
    <label for="job">Job</label>
    <input type="text" name="job" id="job" value="${user.job}">
    <c:if test="${empty user.lastName}">
    <input type="submit" value="Add new user">
    </c:if>
    <c:if test="${!empty user.lastName}">
    <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>