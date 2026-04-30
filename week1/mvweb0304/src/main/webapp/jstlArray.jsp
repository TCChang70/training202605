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
       <% String[] words = {"foo", "bar", "baz"};
          pageContext.setAttribute("wds", words);%>        
        <H2>Key Words:</H2>
        <UL>
            <c:forEach var="word"   items="${wds}">
                <LI><c:out value="${word}"/>
            </c:forEach>
        </UL>        
        <br/>
        <h2>Country Array </h2>
        <c:forEach
            var="country"
            items="Australia,Canada,Japan,Philippines,USA">
        <LI><c:out value="${country}"/>
        </c:forEach>

</body>
</html>