<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
    <h3>Products Page</h3>
    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <th>Id</th><th>Name</th><th>Photo</th><th>Price</th><th>Buy</th>
        </tr>

        <%-- c:forEach 迭代 Controller 傳來的 products 集合 --%>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <%-- pageContext.request.contextPath 取得應用程式根路徑，避免路徑錯誤 --%>
                <td><img src="${pageContext.request.contextPath}/${product.photo}" width="150"></td>
                <td>${product.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/cart/buy/${product.id}">Buy Now</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>