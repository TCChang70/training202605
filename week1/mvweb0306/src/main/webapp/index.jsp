<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<html>
<body>
<%
   Date d1=new Date();
%>
<h2>
 Date Time : <%= d1.toLocaleString() %><br/>
 value:${param.value}
</h2>
</body>
</html>
