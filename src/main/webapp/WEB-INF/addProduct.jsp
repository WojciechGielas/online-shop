<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2019-02-17
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>

<jsp:include page="/WEB-INF/header.jsp">
    <jsp:param name="login" value="${login}"></jsp:param>
</jsp:include>

<form action="${pageContext.request.contextPath}/addProduct" method="post">
    <div class="mx-auto" style="width: 200px;">
    <p>
        <input type="text" name="name"/><h5>Nazwa</h5>
    </p>
    <p>
        <input type="text" name="price"/><h5>Cena</h5>
    </p>
    <p>
        <textarea name="description"></textarea><h5>Opis</h5>
    </p>
    <p>
    <input type="text" name="category"><h5>Kategoria</h5>
    </p>
    <p>
        <input type="text" name="quantity"/><h5>Ilosc</h5>
    </p>
    <p>
    <input type="submit" name="submit" value="Dodaj produkt">
    </p>
    </div>
</form>
</body>
</html>
