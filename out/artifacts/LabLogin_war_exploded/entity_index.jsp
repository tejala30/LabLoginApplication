<%--
  Created by IntelliJ IDEA.
  User: tethippe
  Date: 3/22/2016
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data List</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Entity page</title>
</head>
<body>
<p> Here are the list of entities</p>
<c:choose>
    <c:when test="${empty entities}">
        <p>There are no records to display</p>
    </c:when>
    <c:otherwise>
        <ul>
            <c:forEach items="${entities}" var="entity">
                <li>${entity.prodName}</li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<a href="/index.jsp">Go back to home page</a>
</body>
</html>
</body>
</html>
