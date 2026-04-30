<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Execute Stored Procedure</title>
</head>
<body>
<form action="empinoffice" method="post">
  All Cities: <select name="city">
     <c:forEach var="c" items="${citys}">
       <option>${c}</option>
     </c:forEach>
  </select><br/>
  <input type="submit" value="查詢"/>
  
</form>
</select>
</body>
</html>