<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.time.LocalDate"%>
    <%@ page import = "java.util.LinkedList" %>

     <%@ page import="com.ats.dao.DaoStatistiche"%>
     <%@ page import="com.ats.controller.StatisticheServlet"%>
    
    
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
thead {
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
		<%  session.getAttribute("listaCorsisti"); %>
    <c:forEach items="${listaCorsisti}" var="current">    	
     	<tr>
	        <td><c:out value="${current.nomecorsista}" />    	
	        <td><c:out value="${current.cognomecorsista}" /> 
	        <td><c:out value="${current.codcorsista}" />                
      	</tr>   	
    </c:forEach>
</table>

<table align = "center"> 
	<caption>
		Docenti che possono tenere più corsi:
	</caption>
	<thead>
		<tr>
			<td>Nome </td>
			<td>Cognome</td>
			<td>Curriculum</td>
			<td>Codice</td>			
		</tr>
	</thead>
  		<%session.getAttribute("ListadocentiPiuCorsi"); %>
    <c:forEach items="${ListadocentiPiuCorsi}" var="current"> 
       <tr>
            <td><c:out value="${current.nomedocente}" />           
            <td><c:out value="${current.cognomedocente}" /> 
            <td><c:out value="${current.cvdocente}" /> 
            <td><c:out value="${current.coddocente}" />       
       </tr>
     </c:forEach>
</table>

<table align = "center"> 
	<caption>
			Corsi con posti disponibili:
	</caption>
	<thead>
	   <tr>
			<td>Nome </td>
			<td>Codice</td>		
	   </tr>
	</thead>
		<%session.getAttribute("listaCorsi"); %>
    <c:forEach items="${listaCorsi}" var="current"> 
       <tr>
          <td><c:out value="${current.nomecorso}" />           
          <td><c:out value="${current.codcorso}" />        
       </tr>
    </c:forEach>
</table>


</form>

<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>