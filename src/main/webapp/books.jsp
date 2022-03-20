<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 20.03.2022
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <c:forEach var="book" items="${requestScope.books}">
        <tr>
            <td><h3>${book.id}</h3></td>
            <td><h3>${book.title}</h3></td>
            <td><h3>${book.year}</h3></td>
            <td><h3>${book.quantity}</h3></td>
            <td><h3>${book.authors}</h3></td>
        </tr>
    </c:forEach>
    FUUUUUCK
</table>
</body>
</html>
