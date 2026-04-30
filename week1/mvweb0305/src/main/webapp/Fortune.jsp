<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP GUESS</title>
</head>
<body>
<jsp:useBean id="Fortune" class="beans.GuessGameLogic" scope="session">
  <% Fortune.initialize(1 , 10); %>
</jsp:useBean>
<c:set var="guessnumber"  value="${param.number}"></c:set>
<c:set var="flag" value="${Fortune.isCorrectGuess(guessnumber)}"></c:set>
<c:if test="${flag}">
    <%session.invalidate();%>
    <jsp:forward page="bingo.jsp" />
</c:if>
<c:if test="${!flag}"> 
    <c:if test="${Fortune.remainder==0}">
         <%session.invalidate();%>
        <jsp:forward page="noChances.jsp" />
    </c:if>   
    <c:if test="${Fortune.remainder>0}">
        The number ${guessnumber} is not correct.<br/>
    	    You still have ${Fortune.remainder} chances.<br/>
            ${Fortune.hint} <br/>
    	    <a href="guess.html">Try again</a>
    </c:if>
</c:if> 

</body>
</html>