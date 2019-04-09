<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
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
<div class="row">
    <div class="mx-auto" style="width: 200px;">
        <a href="${pageContext.request.contextPath}/addProduct" class="text-dark"><h5>DODAJ PRODUKT</h5></a>
    </div>
</div>
<div class="container">
<div class="row">
    <div class="col">
<h5>Produkty: </h5>
        <c:forEach items="${products}" var="product">
            <jsp:include page="/WEB-INF/viewProduct.jsp">
                <jsp:param name="name" value="${product.name}"/>
                <jsp:param name="description" value="${product.description}"/>
                <jsp:param name="price" value="${product.price}"/>
                <jsp:param name="category" value="${product.category}"/>
                <jsp:param name="id" value="${product.id}"/>
                <jsp:param name="quantity" value="${product.quantity}"/>
                <jsp:param name="pictureUrl" value="${product.pictureUrl}"/>
            </jsp:include>


            <a href="${pageContext.request.contextPath}/Product?id=${product.id}" class="text-danger"> Wejdz w produkt</a>
            <p>---------------------------------------</p>


        </c:forEach>
    </div>
    <div class="col">
        <div class="mx-auto" style="width: 200px;">

            <c:choose>
                <c:when test="${Last !=null}">
                    <h5>Otatnio ogladany produkt:</h5>
                    <jsp:include page="/WEB-INF/viewProduct.jsp">
                        <jsp:param name="name" value="${Last.name}"/>
                        <jsp:param name="description" value="${Last.description}"/>
                        <jsp:param name="price" value="${Last.price}"/>
                        <jsp:param name="category" value="${Last.category}"/>
                        <jsp:param name="id" value="${Last.id}"/>
                        <jsp:param name="quantity" value="${Last.quantity}"/>

                    </jsp:include>
                </c:when>
            </c:choose>
        </div>
    </div>
</div>
</div>

</body>
</html>
