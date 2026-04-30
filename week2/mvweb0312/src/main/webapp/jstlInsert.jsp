<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<html>
<head>
<title>INSERT Operation</title>
</head>
<body> 
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb"
     user="root"  password="1234"/> 

<sql:update dataSource="${sample}">
       INSERT INTO testdb.Employees(id,age,firstname,lastname) 
       VALUES (${param.uid}, ${param.age}, '${param.firstname}', '${param.lastname}')
</sql:update> 
<jsp:include page="showall.jsp"></jsp:include>
</body>
</html>
