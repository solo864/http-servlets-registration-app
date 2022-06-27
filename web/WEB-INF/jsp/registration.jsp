<%--
  Created by IntelliJ IDEA.
  User: iamus
  Date: 27.06.2022
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SIGN UP</title>
</head>
<body>

<form action="/registration" method="post">

    NAME
    <label for="name">
        <input type="text" name="name" id="name">
    </label>
    <br>
    EMAIL
    <label for="email">
        <input type="text" name="email" id="email">
    </label>
    <br>
    PASSWORD
    <label for="pw">
        <input type="password" name="password" id="pw">
    </label>
    <br>
    BIRTHDAY
    <label for="birthday">
        <input type="date" name="birthday" id="birthday">
    </label>
    <br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
            <br>
            <option value="${role}"> ${role}</option>
        </c:forEach>
    </select>
    <c:forEach var="gender" items="${requestScope.genders}">
        <br>
        <input type="radio" name="gender" value="${gender}"> ${gender}
    </c:forEach>
    <br>
    <button type="submit">Отправить</button>

    <c:if test="${not empty requestScope.errors}">
        <c:forEach var="error" items="${requestScope.errors}">
            <br>
            ${error.message}
        </c:forEach>
    </c:if>

</form>

</body>
</html>
