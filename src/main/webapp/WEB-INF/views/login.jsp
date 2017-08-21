<%@page session="false"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mercenaries Project</title>

    <c:url var="home" value="/" scope="request"/>
    <spring:url value="/resources/css/" var="css"/>
    <spring:url value="/resources/js/" var="js"/>
    <spring:url value="/resources/fonts/" var="fonts"/>

    <link rel="stylesheet" href="${fonts}notoserif.css">
    <link rel="stylesheet" href="${fonts}font-awesome.css">
    <link rel="stylesheet" href="${css}my.css">
    <link rel="stylesheet" href="${css}bundle.css">
    <link rel="stylesheet" href="${css}loaders.min.css">
    <link rel="stylesheet" href="${css}question.css">
    <link rel="stylesheet" href="${css}prism.css">

    <script>
         window.config = { basename: '/' };
    </script>
</head>
<body>
<div>
    <form action="login" method="post">
        <fieldset>
            <legend>Please Login</legend>
            <c:if test="${param.error != null}">
                <div>
                    <p>Authentication Failed : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div>
                    <p>You have been logged out successfully.</p>
                </div>
            </c:if>
            <label for="username">Username</label> <input type="text" id="username" name="username"/> <br> <label for="password">Password</label>
            <input type="password" id="password" name="password"/> <br>
            <div>
                <button type="submit">Log in</button>
            </div>
        </fieldset>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
<div id="app" class="wrapper"></div>
<script src="${js}/bundle.js"></script>
<script src="${js}/prism.js"></script>
</body>
</html>