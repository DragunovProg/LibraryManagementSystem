<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 14.06.2022
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <style><%@include file="style.css"%></style>
</head>
<body>
    <header class="header">
        <div class="container">
            <div class="header__inner">
                <div class="logo"><a class="startpage__link" href="/">ModernLibrary</a></div>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="edit__form">
            <form action="/edit" class="edit">
                <div class="edit__column"><input  type="text" name="book__title" value="${booking.book.title}"></div>
                <div class="edit__column"><input type="date" name="book__start__date" value="${booking.startBookingDate}"></div>
                <div class="edit__column"><input type="date" name="book__start__date" value="${booking.endBookingDate}"></div>
                <div class="edit__submit"><input type="submit" name="edit__submit" value="Edit"></div>
            </form>
        </div>
    </div>
</body>
</html>
