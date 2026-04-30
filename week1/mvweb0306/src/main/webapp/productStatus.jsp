<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products Info</title>
</head>
<body>
<c:if test="${flag}">
   <h2>add product success</h2>
</c:if>
<c:if test="${!flag}">
   <h2>add product fail</h2>
</c:if>
<jsp:include page="addproduct.html"></jsp:include>
</body>
</html>