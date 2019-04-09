<%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2019-02-23
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img src="${param.pictureUrl}" height="100" width="100">
<p>Id: ${param.id}</p>
<p>Nazwa: ${param.name}</p>
<p>Opis: ${param.description}</p>
<p>Cena: ${param.price}</p>
<p>Kategoria: ${param.category}</p>
<p>Ilosc: ${param.quantity}</p>
<p></p>


<form action="${pageContext.request.contextPath}/BuyProduct" method="post">
    <p>
        <input type="hidden" name="id" value="${param.id}"/>
    </p>
    <p>
        <input type="hidden" name="quantity" value="1"/>
    </p>
    <p>
        <input type="submit" name="submit" value="Dodaj do koszyka">
    </p>


</form>

</body>
</html>
