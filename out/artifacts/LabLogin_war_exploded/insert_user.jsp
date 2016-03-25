<%--
  Created by IntelliJ IDEA.
  User: tethippe
  Date: 3/25/2016
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>New User</title>
</head>
<body>

<c:choose>
    <c:when test="${empty status}">
        <h2>Enter the below details</h2>
        <form action="newuser" method="post">
            User Id:<br>
            <input type="text" name="userid"><br>
            User name:<br>
            <input type="text" name="username"><br>
            Password:<br>
            <input type="password" name="password">
            <br>
            <br>
            <br>
            <input type="submit" value="Submit">
        </form>
    </c:when>
    <c:when test="${status == 'fail'}">
        <h2>Account creation failed. Try again</h2>
        <h2>Enter the below details</h2>
        <form action="newuser" method="post">
            User Id:<br>
            <input type="text" name="userid"><br>
            User name:<br>
            <input type="text" name="username"><br>
            Password:<br>
            <input type="password" name="password">
            <br>
            <br>
            <br>
            <input type="submit" value="Submit">
        </form>
    </c:when>
    <c:otherwise>
        <h2> Welcome!!</h2>
        <p> You have successfully created account in!!</p>
        <a href="/login.jsp">Click on link to Login</a>
    </c:otherwise>
</c:choose>
</body>
</html>