<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${products.size()==0}">
 <h2>No Product</h2>
</c:if>
<table border="1" width="40%">
<tr><th>Product ID</th><th>Product Name</th><th>Product Price</th>
<c:forEach var="p" items="${products}">
   <tr>
      <td>${p.id}</td><td>${p.name}</td><td>${p.price}</td>
   </tr>
</c:forEach>
</table>

<jsp:include page="addproduct.html"></jsp:include>
</body>
</html>