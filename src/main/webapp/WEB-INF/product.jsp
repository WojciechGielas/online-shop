<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2019-02-17
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="/WEB-INF/header.jsp">
    <jsp:param name="login" value="${login}"></jsp:param>
</jsp:include>

<jsp:include page="viewProduct.jsp">
    <jsp:param name="name" value="${product.name}"/>
    <jsp:param name="description" value="${product.description}"/>
    <jsp:param name="price" value="${product.price}"/>
    <jsp:param name="category" value="${product.category}"/>
    <jsp:param name="id" value="${product.id}"/>
    <jsp:param name="quantity" value="${product.quantity}"/>
    <jsp:param name="pictureUrl" value="${product.pictureUrl}"/>
</jsp:include>


</body>
</html>
