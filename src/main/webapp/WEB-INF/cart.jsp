<%@ page import="pl.sda.servlet.shopOnline.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Wojtek
  Date: 2019-02-23
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twoje zakupy</title>
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
<div class="container">
<div class="row">
    <div class="=col">
        <h5>Twoje produkty:</h5>
        <% Map<Product, Integer> map = (Map<Product, Integer>) session.getAttribute("cart");
            for (Map.Entry<Product, Integer> entry : map.entrySet()) {%>
        <p>Nazwa produktu: <a href="/Product?id=<%=entry.getKey().getId()%>">
            <%=entry.getKey().getName()%>
        </a>
        </p>
        <p>Ilość <%=entry.getValue()%>
        </p>
        <%}%>
    </div>
    <div class="col">
        <div class="mx-auto" style="width: 200px;">
            <form action="${pageContext.request.contextPath}/order" method="post">
                <p><h6>Adres</h6>
                <input type="text" name="adress"/>
                </p>
                <p><h6>Email</h6>
                <input type="text" name="email"/>
                </p>
                <p>
                    <input type="submit" name="submit" value="KUP">
                </p>
                <p>************************</p>
                <a href="${pageContext.request.contextPath}/page" class="text-dark">Wroc na strone glowna</a>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
