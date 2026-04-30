<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML Table</title>
</head>
<body bgcolor="lightgray">
 <b>Table of numbers squared:</b>
  <table border="1" width="25%">
  <tr><th>number</th><th>squared</th></tr>
  <% for ( int i=1; i<=10; i++ ) { %>  
   <tr>
       <td><%= i %></td>
       <td><%= (i * i) %></td>
   </tr>
 <% } %>
 </table>
</body>
</html>