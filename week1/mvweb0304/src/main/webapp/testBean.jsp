<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Bean</title>
</head>
<body>
<jsp:useBean id="test1" class="beans.Test"></jsp:useBean>
<jsp:setProperty property="message" name="test1" value="Good Afternoon everyone"/>
<h2>
    Get Property message: <jsp:getProperty property="message" name="test1"/>
</h2>
</body>
</html>