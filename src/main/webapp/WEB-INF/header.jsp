<%@ page import="pl.sda.servlet.shopOnline.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
    <div class="p-3 mb-2 bg-warning text-dark">
        <div class="row">
            <div class="col">
                <% if (session.getAttribute("user") != null) { %>
                <h5>Zalogowany uzytkownik:</h5>
                <%=((User) session.getAttribute("user")).getUserName() %>
                <p></p>
            </div>
            <div class="col">
                <a href="${pageContext.request.contextPath}/logout" class="text-dark">Wyloguj sie</a>
                <% } else { %>
                <a href="${pageContext.request.contextPath}/login" class="text-dark">Zaloguj sie</a>
            </div>
            <div class="col">
                <a href="${pageContext.request.contextPath}/register" class="text-dark">Zarejestruj sie</a>
            </div>

            <% } %>
        </div>
    </div>
    <div class="p-3 mb-2 bg-light text-dark">
    <div class="row">

            <div class="col">
                <a href="${pageContext.request.contextPath}/page" class="text-dark">Strona glowna</a>
            </div>
            <div class="col">
                <a href="${pageContext.request.contextPath}/cart" class="text-dark">Twój Koszyk</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>

</body>
</html>
