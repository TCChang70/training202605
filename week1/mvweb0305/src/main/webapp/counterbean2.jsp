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
<jsp:useBean id="bean1" class="beans.Counter"  scope="session"/>
 
<c:set target="${bean1}"  property="counter" value="${bean1.counter+1}"></c:set>
        
 The counter value is: <jsp:getProperty  name="bean1"  property="counter" /> 

</body>
</html>