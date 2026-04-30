<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Information</title>
</head>
<body>
<%
   Map<String,String> user=new HashMap<String,String>();
   user.put("firstName","Johnson");
   user.put("lastName","Smith");
   user.put("address","Kung Yuan Road Taipei");
   user.put("phone","23826015");
   List<Map<String,String>> data=new ArrayList<>();
   data.add(user);
   
   user=new HashMap<String,String>();
   user.put("firstName","Mary");
   user.put("lastName","Lane");
   user.put("address","Chung Sun North Road Taipei");
   user.put("phone","25122362");   
   data.add(user);   
%>
<table border="1" width="40%">
 <tr>
      <th>用戶名字</th><th>用戶姓氏</th><th>用戶地址</th><th>用戶電話</th> 
 </tr>
 <% for(Map<String,String> u:data){ %>
    <tr>
       <td><%= u.get("firstName") %></td><td><%= u.get("lastName") %></td>
       <td><%= u.get("address") %></td><td><%= u.get("phone") %></td> 
    </tr>
 <%}%>
</table>



</body>
</html>