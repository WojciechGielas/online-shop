<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2019-02-24
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp">
    <jsp:param name="login" value="${login}"></jsp:param>
</jsp:include>
<div class="mx-auto" style="width: 200px;">

    <c:choose>
    <c:when test="${error!=null}">
        <h4>${error}</h4>
    </c:when>
    <c:otherwise></c:otherwise>
</c:choose>
</div>


<form action="${pageContext.request.contextPath}/register" method="post">
    <div class="mx-auto" style="width: 200px;">
        <input type="text" name="userName"/>
        <h5>Login</h5>
    </div>
    <div class="mx-auto" style="width: 200px;">
        <input type="text" name="email"/>
        <h5>Email</h5>
    </div>
    <div class="mx-auto" style="width: 200px;">
        <input type="password" name="password"/>
        <h5>Hasło</h5>
    </div>
    <div class="mx-auto" style="width: 200px;">
        <input type="Password" name="repeatPassword"/>
        <h5>Powtorz hasło</h5>
    </div>
    <div class="mx-auto" style="width: 200px;">
        <input type="submit" name="submit" value="zatwierdz">
    </div>

</form>

</body>
</html>
