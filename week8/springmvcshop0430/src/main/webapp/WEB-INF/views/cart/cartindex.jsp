<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>Cart Page</title></head>
<body>
    <h3>Cart Page</h3>
    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <th>Option</th><th>Id</th><th>Name</th>
            <th>Photo</th><th>Price</th><th>Quantity</th><th>Sub Total</th>
        </tr>

        <%-- 宣告 total 變數，用來累計總金額 --%>
        <c:set var="total" value="0" />

        <%-- sessionScope.cart：從 HttpSession 讀取購物車資料 --%>
        <c:forEach var="item" items="${sessionScope.cart}">
            <%-- 每次迭代累加小計 --%>
            <c:set var="total" value="${total + item.product.price * item.quantity}" />
            <tr>
                <td>
                    <%-- 刪除前彈出確認視窗 --%>
                    <a href="${pageContext.request.contextPath}/cart/remove/${item.product.id}"
                       onclick="return confirm('確定要刪除 ${item.product.name}?')">Remove</a>
                </td>
                <td>${item.product.id}</td>
                <td>${item.product.name}</td>
                <td><img src="${pageContext.request.contextPath}/${item.product.photo}" width="150"></td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="right"><strong>Sum</strong></td>
            <td>${total}</td>
        </tr>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/productcart">Continue Shopping</a>
</body>
</html>