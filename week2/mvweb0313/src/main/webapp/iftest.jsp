<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://mytag.test/jstl/fake" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <f:if test="${param.password == '12345'}">
            你的秘密資料在此！
</f:if>

</body>
</html>