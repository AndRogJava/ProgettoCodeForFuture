<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="java.time.LocalDate"%>
    <%@ page import = "java.util.LinkedList" %>
    <%@ page import = "java.lang.*" %>
 
    
     
     <%@ page import="com.ats.dao.DaoStatistiche"%>
      <%@ page import="com.ats.controller.StatisticheServlet"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
</head>
<body class="img">

<header><jsp:include page="header.jsp"/></header>

<form action="StatisticheServlet" method="GET">

<h2>Statistiche corsi</h2>

<table>

  <tr>
    <th> -- </th>
    <th>Statistiche aggiornate</th>
  </tr>
  
  <tr>
    <td>Numero corsisti totali: </td>
    <% Integer.parseInt(session.getAttribute("corsistiTot").toString()); %> 
    <td>  <% out.println("corsistiTot"); %>  </td>
    
  </tr>
  
  <tr>
    <td>Corso più frequentato: </td>
     <%session.getAttribute("corsoPiuFreq").toString();%>
    <td><% out.println("corsoPiuFreq"); %>  </td>
  </tr>
  
  <tr>
    <td>Data di inizio dell'ultimo corso: </td>
    <% LocalDate data = (LocalDate)session.getAttribute("dataInizio"); %>
    <td> <% out.println("dataInizio"); %>  </td>
  </tr>
  
  <tr>
    <td> Durata media dei corsi ( in giorni lavorativi ) </td>
    <% Double media = (Double)session.getAttribute("media"); %>
    <td> <% out.println("media"); %></td>
  </tr>
  
  <tr>
    <td>Numero di commenti presenti: </td>
    <% Integer.parseInt(session.getAttribute("commentiTot").toString()); %>
    <td><% out.println("commentiTot"); %></td>
  </tr>
 
   
</table>

<table> 

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
     	<c:url value = "ProfiloCorsista.jsp" var = "myURL">
  			 <c:param name = "codcorsista" value = "${current.codcorsista}"/>
   		</c:url>

       <tr>
          <td> <c:import url = "${myURL}"/> <c:out value="${current.nomecorsista}" /> 
          <td><c:out value="${current.cognomecorsista}" /> 
          <td id=codcorsista><c:out value="${current.codcorsista}" />         
       </tr>
      </c:forEach>

</table>


<table> 
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
	
	<%  session.getAttribute("ListadocentiPiuCorsi"); %>
    
    <c:forEach items="${ListadocentiPiuCorsi}" var="current"> 
       <tr>
          <td><c:out value="${current.nomedocente}" />           
          <td><c:out value="${current.cognomedocente}" /> 
          <td><c:out value="${current.cvdocente}" /> 
          <td><c:out value="${current.coddocente}" />       
        </tr>
      </c:forEach>

</table>


</form>

<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>