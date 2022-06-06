<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dragu
  Date: 29.05.2022
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About</title>
    <style><%@include file="style/about_style.css"%></style>
</head>
<body>
    <div class="header">
        <div><a href="main.jsp"><span id="first_letter">L</span><span id="other_letter">ibrary</span></a></div>
    </div>
    <div class="main">
        <img src="<c:url value='/pictures/city_library.jpg'/>" alt=.../>
        <span id="description">It's site of City Library, where you can rental a books with difference jenre
        and size. Have fun dude !!</span>
    </div>
    <div class="footer">

    </div>
</body>
</html>
