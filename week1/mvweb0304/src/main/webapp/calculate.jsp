<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Math OP</title>
</head>
<body>
     <% String op=request.getParameter("sb"); %>
     <% if(op.equals("add")){ %>
          <h2> ${param.num1}+${param.num2}=${param.num1+param.num2}</h2> 
     <%}else if(op.equals("subtract")){ %>
          <h2> ${param.num1}-${param.num2}=${param.num1-param.num2}</h2>
     <%}else if(op.equals("multiply")){ %>
          <h2> ${param.num1}x${param.num2}=${param.num1*param.num2}</h2>
     <%}else if(op.equals("divide")){ %>
          <h2> ${param.num1}/${param.num2}=${param.num1/param.num2}</h2>
     <%}else { %>
          <h2>運算符號不能使用</h2>
     <%}%>
</body>
</html>