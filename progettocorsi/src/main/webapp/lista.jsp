<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*"%>
    <%@ page import="com.ats.model.*"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@ page isELIgnored ="false" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista</title>
</head>
<body class="img">

<header><jsp:include page="header.jsp"/></header>
<form action="ListaServlet" method="GET">
<style>
th, td {
	border: 3px solid #111;
	padding:8px;
}
thead {
	background-color: #449D48;
}

</style>

<table align = "center">

	<thead>
		<tr>
			<b><h2><td>NOME CORSISTA</td></h2></b>
			<b><h2><td>COGNOME CORSISTA</td></h2></b>	
			
			
			
			</tr>
	</thead>	
	
	 <c:forEach items="${lista}" var="current">
	 
        <tr>
          <td><c:out value="${current.nomecorsista}" /></a>
           <td><c:out value="${current.cognomecorsista}" /> 
           
             
       
 </tr>	
 	
 </c:forEach>
<a href="InserisciCorsista.jsp"> </a>

 </table> 

<footer><jsp:include page="footer.jsp"/></footer>	
</body>
</form>
</body>
</html>