<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.ats.dao.DaoStatistiche"%>
    <%@ page import="java.time.LocalDate;"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistiche</title>
</head>
<body>

<form action="StatisticheServlet" method="GET">


<h2>Statistiche corsi</h2>

<% LocalDate.now(); %>

<table>
  <tr>
    <th> -- </th>
    <th>Statistiche aggiornate</th>

  </tr>
  <tr>
    <td>Numero corsisti totali: </td>
    <td><% Integer intero = Integer.parseInt((String)(session.getAttribute("corsistiTot"))); %></td>
    
  </tr>
  <tr>
    <td>Corso più frequentato: </td>
    <td> <% %> </td>
    
  </tr>
  <tr>
    <td>Data di inizio dell'ultimo corso: </td>
    <td> <% %> </td>

  </tr>
  <tr>
    <td> Durata media dei corsi ( in giorni lavorativi ) </td>
    <td><% %></td>

  </tr>
  <tr>
    <td>Numero di commenti presenti: </td>
    <td><% %></td>

  </tr>
 
    <tr>
    <td> Docente che può tenere più tipologie di corso: </td>
    <td> <% %> </td>
  </tr>
</table>

<table> 
	<caption>
		<p>Elenco Corsisti: </p>
	</caption>
	<thead>
		<tr>
			<td>Nome</td>
			<td>Cognome</td>
			<td>Codice </td>
			<td>Precedenti formativi </td>
		</tr>
	</thead>
	<%  session.getAttribute("listaCorsisti"); %>
    
    <c:forEach items="${listaCorsisti}" var="current"> 

       <tr>
          <td><c:out value="${current.nomecorsista}" /> 
          <% String nomeCorsista = (current.nomecorsista);  %>
          <% session.setAttribute("nomeCorsista", nomeCorsista); %> 
           <td><c:out value="${current.cognomecorsista}" /> 
            <td><c:out value="${current.codcorsista}" />
             <td><c:out value="${current.precedentiformativi}" />	
        </tr>
      </c:forEach>
    
    </td>
  </tr>

</table>

</form>

</body>
</html>