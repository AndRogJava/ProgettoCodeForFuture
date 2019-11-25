>Logout</a></li><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<header><jsp:include page="header.jsp"/></header>

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
    <td> <% String corsoPiuFreq = (String)session.getAttribute("corso"); %> </td>
  </tr>
  <tr>
  
    <td>Data di inizio dell'ultimo corso: </td>
    <td> <% LocalDate dataUltCorso = (LocalDate)session.getAttribute("data"); %> </td>
  </tr>
  
  <tr>
    <td> Durata media dei corsi ( in giorni lavorativi ) </td>
    <td><% Double durataMedia = (Double)session.getAttribute("media"); %></td>
  </tr>
  
  <tr>
    <td>Numero di commenti presenti: </td>
    <td><% Integer commentiTotali = Integer.parseInt((String)(session.getAttribute("commentiTot"))); %></td>

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
			<td>Codice</td>
		</tr>
	</thead>
	<%  session.getAttribute("listaCorsisti"); %>
    
    <c:forEach items="${listaCorsisti}" var="current"> 

       <tr>
          <td><a href="ProfiloCorsista.jsp"><c:out value="${current.nomecorsista}" /></a> 
           <c:param name="codcorsista" value="${current.codcorsista}"/>
           
           <td><c:out value="${current.cognomecorsista}" /> 
           <td id="codice"><c:out value="${current.codcorsista}" />     
             
        </tr>
      </c:forEach>
    
    </td>
  </tr>

</table>

</form>

<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>