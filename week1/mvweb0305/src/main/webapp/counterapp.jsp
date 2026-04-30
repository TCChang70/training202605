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
<jsp:useBean id="beanApp" class="beans.Counter"  scope="application"/>
 
<c:set target="${beanApp}"  property="counter" value="${beanApp.counter+1}"></c:set>
        
 The counter value is: <jsp:getProperty  name="beanApp"  property="counter" /> 
 
  <jsp:useBean id="bean1" class="beans.Counter"  scope="session"/>
 
        <% 
        bean1.setCounter(bean1.getCounter() + 1);
        %>
 <p>       
 The counter value is: <jsp:getProperty  name="bean1"  property="counter" /> 

</body>
</html>