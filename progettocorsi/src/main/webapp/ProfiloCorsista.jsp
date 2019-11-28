<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "java.util.LinkedList" %>
      <%@ page import= "com.ats.model.DatiCorsisti" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profilo Corsista</title>

<link href="CSS/style.css" rel="stylesheet" type="text/css">

</head>

<style>
table{
	width: 35%;
	background-color: white;
	border-collapse: collapse;
	border-color: #449D48;
	border-style: solid;
	color: black;
}

td,th{
	border:1px solid #449D48;
}

.allineatab{
	text-align: center;
}

</style>

<body class="img">

<header><jsp:include page="header.jsp"/></header>

<div class="userpic" >
<form action="StatisticheServlet" method="GET">

<img src="images/userprova.jpg" width="150px">

<center>

<table>

<thead>

<tr>
<th>Nome</th>
<th>Cognome</th>  
<th>Codice</th>
<th>Precedenti Formativi</th>
</tr>

</thead>

<c:forEach items="${listaCorsisti}" var="items">
<tr>
<td><c:out value="${items.nomecorsista}" /></td>
<td><c:out value="${items.cognomecorsista}" /></td>
<td><c:out value="${current.codcorsista}" />    
<td><c:out value="${items.precedentiformativi}" /></td>
</tr>
</c:forEach>

</table>
 
 </center>
     
</form>  

</div>

<footer><jsp:include page="footer.jsp"/></footer>
     

</body>
</html>
