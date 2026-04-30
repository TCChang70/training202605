<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
 <% 
    request.setCharacterEncoding("utf-8");
    String a=request.getParameter("favoriteAnimal");              
 %>
 <h2>Your favorite animal is a           
         <%= a %>Wow, mine is too!
 </h2>

</body>
</html>