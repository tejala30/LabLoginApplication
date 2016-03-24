<%--
  Created by IntelliJ IDEA.
  User: tethippe
  Date: 3/22/2016
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<c:choose>
    <c:when test="${empty status}">
        <h2> Welcome User</h2>
        <form action="login" method="post">
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
        <h2> Welcome User</h2>
        <p> Invalid Credentials. Try again!!</p>
        <form action="login" method="post">
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
        <h2> Welcome ${status}</h2>
        <p> You have successfully logged in!!</p>
        <a href="/index.jsp">Go back to home page</a>
    </c:otherwise>
</c:choose>
<br />
<br />

</body>
</html>


