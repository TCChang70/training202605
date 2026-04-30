<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check User Session</title>
</head>
<body>
<c:if test="${empty sessionScope.username}">
    <% response.sendRedirect("login.html"); %>    
</c:if>
<h2>
  Login Name is ${sessionScope.username}<br/>
  Login Password is ${sessionScope.userpassword}
</h2>
</body>
</html>