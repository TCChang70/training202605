<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Employees</title>
</head>
<body>
<a href="employeeform.html">員工新增</a><br/>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/testdb"
     user="root"  password="1234"/> 
     
<sql:query dataSource="${sample}" var="result">
      SELECT * from testdb.Employees
</sql:query> 
<table border="1" width="50%">
<tr>
   <th>Employee ID</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Age</th>
   <th>Action</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.id}"/></td>
   <td><c:out value="${row.firstname}"/></td>
   <td><c:out value="${row.lastname}"/></td>
   <td><c:out value="${row.age}"/></td>
   <td><a href="editview.jsp?uid=${row.id}">修改</a> <a href="removeemployee.jsp?uid=${row.id}">刪除</a></td>
</tr>
</c:forEach>
</table> 
</body>
</html>