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
<jsp:useBean id="user" class="beans.UserInfo">
   <jsp:setProperty name="user" property="*" ></jsp:setProperty>
</jsp:useBean>
<c:if test="${empty user.name}">
   <% response.sendRedirect("userform.html"); %>
</c:if>

<h2>
   User Name:${user.name}<br/>
   User Age:${user.age}<br/>
</h2>
<c:if test="${user.age<18}">
   <h1>${user.name} under age</h1>
</c:if>
<c:if test="${user.age>=18}">
   <h1>${user.name} Adult age is reached</h1>
</c:if>

</body>
</html>