<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
</head>
<body>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb"
     user="root"  password="1234"/> 
     
<sql:query dataSource="${sample}" var="result">
      SELECT * from testdb.Employees where id=${param.uid}
</sql:query> 
<form action="updateEmployee.jsp" method="post">
   ID: <input type="text" name="uid" value="${result.rows[0].id}"/><br/>
   First Name: <input type="text" name="firstname" value="${result.rows[0].firstname}"/><br/>
   Last Name: <input type="text" name="lastname" value="${result.rows[0].lastname}"/><br/>
   Age: <input type="text" name="age" value="${result.rows[0].age}"/><br/>
  <input type="submit" value="update"/>
</form>
</body>
</html>