<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supplier View</title>
</head>
<body>
<a href="supplierform.html">新增供應商</a>
<table border="1" width="50%">
<tr><th>Supplier ID</th><th>Supplier Name</th><th>Street</th>
    <th>City</th><th>State</th><th>ZIP</th><th>Operation</th></tr>
<c:forEach var="p" items="${requestScope.suppliers}">
   <tr>
      <td>${p.supId}</td><td>${p.supName}</td><td>${p.street}</td>
      <td>${p.city}</td><td>${p.state}</td><td>${p.zip}</td>
      <td><a href="editview?sid=${p.supId}">修改</a> <a href="deleteid?sid=${p.supId}">刪除</a></td>
   </tr>
</c:forEach>
</table>


</body>
</html>