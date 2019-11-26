<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.LinkedList" %>
      <%@ page import= "com.ats.model.DatiCorsisti" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

table {
  width: 90%;
  background-color: white;
  border-collapse: collapse;
  border-color: grey;
  border-style: solid;
  color: black;
}
td{
border:1px solid black;
}

html{
    height:90%;
    min-height:90%;}
body{
    min-height:90%;}
   
h1,p {
font-family: 'Open Sans', arial, sans-serif;
font-weight: bold;
color: black;

}
</style>

<body class="img">>
<header><jsp:include page="header.jsp"/></header>

<form action="StatisticheServlet" method="GET">
<% 
out.println(session.getAttribute("listaCorsisti"));
 %>

<table>
<thead>
<tr>

<td>Nome</td>
<td>Cognome</td>  
<td>Codice</td>
<td>Precedenti Formativi</td>


</tr>
</thead>

<c:forEach items="${listaCorsisti}" var="items">
<tr>
<td><c:out value="${items.nomecorsista}" /></td>
<td><c:out value="${items.cognomecorsista}" /></td>
<td id="codice"><c:out value="${current.codcorsista}" />    
<td><c:out value="${items.precedentiformativi}" /></td>


</tr>
     </c:forEach>
     </table>
     <footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>
