<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
 <jsp:useBean id="user1"  class="beans.LoginBean">
    <jsp:setProperty name="user1" property="*" />
 </jsp:useBean>
<h2>
  User : ${user1.user}<br/>
  Password: ${user1.password}<br/>
  Phone: ${user1.phone}
</h2>
</body>
</html>