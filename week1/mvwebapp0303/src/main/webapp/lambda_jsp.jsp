<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  int[] nums={1,2,3,4,5};
  pageContext.setAttribute("numbers", nums);
%>
<p>偶數：${numbers.stream().filter(x -> x % 2 != 0).toList()}</p>


<p>平方和：${numbers.stream().map(x -> x * x).sum()}</p>
</body>
</html>