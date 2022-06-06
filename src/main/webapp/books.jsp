<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td><h3><form method="post" action="<c:url value='/deleteBook'/>">
                <input type="number" hidden name="id" value="${book.id}"/>
                <input type="submit" name="delete" value="delete"/>
            </form></h3></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
