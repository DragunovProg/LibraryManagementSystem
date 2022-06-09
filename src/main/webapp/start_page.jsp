<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <style><%@include file="style.css"%></style>
</head>
<body>
    <header class="header">
        <div class="container">
            <div class="header__inner">
                <div class="logo">ModernLibrary</div>
                <div class="about__us"><a class="about__link" href="about.jsp">ABOUT</a></div>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="container">
            <div class="login__form">
                <form class="login" action="" method="post">
                    <div class="email"><input type="email" name="email" placeholder="Enter a email" required></div>
                    <div class="password"><input type="password" name="password" placeholder="Enter a password" required></div>
                    <div class="sumbit"><input type="submit" name="submit" value="Sign in"></div>
                    <div class="register">or <a class="sign__up__link" href="#">Register</a></div>
                    <div class="error">${error}</div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
