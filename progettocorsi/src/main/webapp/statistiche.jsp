<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
    
    <%@ page import="java.time.LocalDate"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "java.lang.*" %>

     <%@ page import="com.ats.dao.DaoStatistiche"%>
     <%@ page import="com.ats.controller.StatisticheServlet"%>
     <%@ page import="com.ats.model.*"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistiche</title>

<style>
th, td {
	border: 3px solid #111;
	padding:8px;
}
thead, th {
	background-color: #449D48;
}

</style>

</head>
<body class="img">

<header><jsp:include page="header.jsp"/></header>

<form action="StatisticheServlet" method="GET">

<h2>Statistiche corsi</h2>

<table align = "center">

  <tr>
    <th> -- </th>
    <th>Statistiche aggiornate</th>
  </tr>
  
  <tr>
    <td>Numero corsisti totali: </td>

    <td>  <% out.println(session.getAttribute("corsistiTot")); %>  </td>
    
  </tr>
  
  <tr>
    <td>Corso più frequentato: </td>
     
    <td><% out.println(session.getAttribute("corsoPiuFreq")); %>  </td>
  </tr>
  
  <tr>
    <td>Data di inizio dell'ultimo corso: </td>
    <td> <% out.println(session.getAttribute("dataInizio")); %>  </td>
  </tr>
  
  <tr>
    <td> Durata media dei corsi </td>
    <td> <% out.println(session.getAttribute("media")); %></td>
  </tr>
  
  <tr>
    <td>Numero di commenti presenti: </td>
    <td><% out.println(session.getAttribute("commentiTot")); %></td>
  </tr>
 
   
</table>

<br>

<br>
<table align = "center"> 
	<caption>
		Docenti che possono tenere più corsi:
	</caption>
	<thead>
		<tr>
			<td>Nome </td>		
		</tr>
	</thead>
	<tbody> 
    <c:forEach items="${ListadocentiPiuCorsi}" var="current2"> 
       <tr>
            <td><c:out value="${current2.nomedocente}" />               
       </tr>
     </c:forEach>
     </tbody>
</table>
<br><br>
<table align = "center"> 
	<caption>
			Corsi con posti disponibili:
	</caption>
	<thead>
	   <tr>
			<td>Nome </td>
			<td>Codice </td>	
	   </tr>
	</thead>
	<c:forEach items="${listaCorsi.map}" var="current4">   
    
     	<tr> 
     	 <td> <c:out value="${current4.nomecorso}" /></td>
	        <td><c:out value="${current4.codcorso}" /> </td>
      	</tr>   	
    </c:forEach>
</table>  	      


<table align = "center"> 
	<caption>
	Elenco Corsisti:
	</caption>
	<thead>
		<tr>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Codice</td>
		</tr>
	</thead>
    <c:forEach items="${ListaCorsisti}" var="current1">   
    
     	<tr> 
     	 <td> <a href="ProfiloCorsista.jsp"><c:out value="${current1.nomecorsista}" /></a></td>
  
	        <td><c:out value="${current1.cognomecorsista}" /> 
	        <td><c:out value="${current1.codcorsista}" /> 
	  
      	</tr>   	
    </c:forEach>
</table>

 

</form>
<button type="submit" form="formPOST" value="Submit">Visualizza elenco corsisti</button>

<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>