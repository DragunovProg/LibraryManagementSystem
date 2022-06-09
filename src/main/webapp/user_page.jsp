<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 07.06.2022
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <style><%@include file="style.css"%></style>
</head>
<body>
    <header class="header">
        <div class="container">
            <div class="header__inner">
                <div class="logo">ModernLibrary</div>
                <div class="user__email">${user.email}</div>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="orders__table">
            <table class="orders">
                <tr>
                    <thead>
                        <th>№</th>
                        <th>Book</th>
                        <th>Start date</th>
                        <th>End date</th>
                    </thead>
                </tr>
                <c:forEach var="booking" items="${requestScope.bookings}">
                <tr>
                    <tbody>
                        <td>${booking.id}</td>
                        <td>${booking.book.title}</td>
                        <td>${booking.startBookingDate}</td>
                        <td>${booking.endBookingDate}</td>
                    </tbody>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
