<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb"
     user="root"  password="1234"/> 
<sql:update dataSource="${sample}">
       update testdb.Employees 
       set firstname='${param.firstname}' , lastname= '${param.lastname}' , age=${param.age}
       where id= ${param.uid}
       
</sql:update> 
<jsp:include page="showall.jsp"></jsp:include>
</body>
</html>