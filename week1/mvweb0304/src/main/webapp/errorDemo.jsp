<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
<h2>
 <% pageContext.setAttribute("exception",exception); %>
  Error Message is <%= exception.getMessage() %><br/>
  EL Error Message is ${exception.getMessage()} <br/>
</h2>
</body>
</html>