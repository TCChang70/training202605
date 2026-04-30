<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coffee View</title>
</head>
<body>
<table border="1" width="50%">
<tr><th>Coffee Name</th><th>Supplier ID</th><th>Price</th><th>Sales</th><th>Total</th>
<c:forEach var="c" items="${coffees}">
   <tr>
      <td>${c.cofName}</td><td>${c.supId}</td><td>${c.price}</td>
      <td>${c.sales}</td><td>${c.total}</td>
   </tr>
</c:forEach>
</table>


</body>
</html>