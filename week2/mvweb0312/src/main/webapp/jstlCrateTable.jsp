<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Table</title>
</head>
<body>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb"
     user="root"  password="1234"/> 
<sql:update dataSource="${sample}" var="result">
   create table if not exists testdb.Employees
    (
     id int not null ,
     age int not null,
     firstname varchar (255),
     lastname varchar (255),
     primary key(id)     
    )
</sql:update> 
<c:out value="Table created in testdb"></c:out>
</body>
</html>