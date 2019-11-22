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
<body>

<form action="/ListaServlet" method="GET">

<table>
	<thead>
		<tr>
			<b><h2><td>NOME CORSISTA</td></h2></b>
			<b><h2><td>COGNOME CORSISTA</td></h2></b>	
			<b><h2><td>CODICE CORSISTA</td></h2></b>
		
			
		</tr>
	</thead>
	
	 <c:forEach items="${lista}" var="current">
	 
        <tr>
          <td><a href="ProfiloCorsista.jsp"><c:out value="${current.nomecorsista}" /></a>
           <td><c:out value="${current.cognomecorsista}" /> 
             <td id="codice"><c:out value="${current.codcorsista}" />
       
 </tr>
 		
 	
 		
 </c:forEach>
 
  </table>            
                
	<input type="button" name="bottone" value="Inserisci corsista"> 
	<input type="button" name="bottone" value="Modifica corsista">  
	<input type="button" name="bottone" value="Elimina corso">  
	<input type="button" name="bottone" value="Statistiche"> 
	
</body>
</form>
</body>
</html>