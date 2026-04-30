<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Books</title>
</head>
<body>
<jsp:useBean id="b" class="beans.Book"></jsp:useBean>
<table border="1" width="40%">
   <tr><th>Book ID</th><th>Book Name</th><th>Author</th><th>Price</th></tr>
	<c:forEach var="book" items="${sessionScope.booklist}">
	   
    	 	<tr><td> ${book.id}</td>
    	 	    <td>${book.bookName}</td>
    	 	    <td>${book.author}</td>
    	 	    <td>${book.price}</td>
    	 	</tr>
	</c:forEach>
</table>
</body>
</html>