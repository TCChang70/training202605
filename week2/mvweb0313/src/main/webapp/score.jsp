<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://mytag.test/jstl/fake" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Status</title>
</head>
<body>
 <f:if test="${param.score>=60}">
       <h2>Score:${param.score} 及格</h2>
</f:if>
<f:if test="${param.score<60}">
       <h2>Score:${param.score} 不及格</h2>
</f:if>
</body>
</html>