<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee View</title>
</head>
<body>
<table border="1" width="95%">
<tr>
    <th>員工編號</th><th>員工姓氏</th><th>員工名字</th><th>分機號碼</th>
    <th>電子郵件</th><th>辦公室編號</th><th>員工職稱</th><th>主管編號</th>
</tr>
<c:forEach var="emp" items="${employees}">
<tr>
    <th>${emp.employeeNumber}</th><th>${emp.firstName}</th><th>${emp.lastName}</th><th>${emp.extension}</th>
    <th>${emp.email}</th><th>${emp.officeCode}</th><th>${emp.jobTitle}</th><th>${emp.reportsTo}</th>
</tr>
</c:forEach>
</table>
</body>
</html>