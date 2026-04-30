<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   session.setAttribute("userName","John")<br/>
<% session.setAttribute("userName","John");%>

session.setAttribute("userName","Mary")<br>
<% session.setAttribute("userName","Mary");%>

session.removeAttribute("userName","Mary")<br>
<% session.removeAttribute("userName");%>

目前有<%=application.getAttribute("users")%>個用戶。<br>
after session.invalidate()<br>


目前有<%= application.getAttribute("users")%>個用戶。<br/>
目前有${applicationScope.users}個用戶。<br/>
<a href="closesession.jsp">Close Session</a>
</body>
</html>