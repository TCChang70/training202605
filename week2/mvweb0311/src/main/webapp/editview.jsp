<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Supplier Form</title>
</head>
<body>
<form action="supplierupdate" method="post">
  <fieldset style="width:25%">
     <legend>Supplier Update Form</legend>
     <table>
       <tr><td>供應商編號:</td><td><input type="text" name="sid" value="${supplier.supId}"/></td></tr>
       <tr><td>供應商名字:</td><td><input type="text" name="sname" value="${supplier.supName}"/></td></tr>
       <tr><td>Street:</td><td><input type="text" name="street" value="${supplier.street}"/></td></tr>
     <tr><td>City:</td><td><input type="text" name="city" value="${supplier.city}"/></td></tr>
     <tr><td>State:</td><td><input type="text" name="state" value="${supplier.state}"/></td></tr>
     <tr><td>ZIP:</td><td><input type="text" name="zip" value="${supplier.zip}"/></td></tr>
     <tr><td><input type="submit" value="Update"/></td></tr>
     </table>
  </fieldset>
 </form>
</body>
</html>