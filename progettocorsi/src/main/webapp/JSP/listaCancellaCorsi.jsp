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
<title>Lista Cancella Corsi</title>
</head>
<body>

<header><jsp:include page="header.jsp"/></header>



 
 <form action="RemoveServlet" method="post"> 
 
 <input type="submit" name="bottone" value="Lista Corsi aggiornata"/>

 </form>
 <% 
 session.getAttribute("listaCorsi");
System.out.print(session.getAttribute("listaCorsi"));
 %>
<table>
	<thead>
		<tr>
			<td>Cod. corso</td>
			<td>Cod. docente</td>
			<td>Nome corso</td>
			<td>Data inizio corso</td>
			<td>Data fine corso</td>
			<td>Costo corso</td>
			<td>Commenti corso</td>
			<td>Aula corso</td>
		</tr>
	</thead>
	
	  <c:forEach items="${listaCorsi}" var="current">
	 
        <tr>
          <td><c:out value="${current.codcorso}" />
           <td><c:out value="${current.coddocente}" /> 
            <td><c:out value="${current.nomecorso}" />
             <td><c:out value="${current.data_iniziocorso}" />
              <td><c:out value="${current.data_finecorso}" />
               <td><c:out value="${current.costocorso}" />
                <td><c:out value="${current.commenticorso}" />
                <td><c:out value="${current.aulacorso}" /> 

<td><a  href="<c:url value="RemoveServlet"><c:param name="corsoCanc" value="${current.codcorso}"/>
      
      </c:url>"><input type="button" name="bottone" value="Elimina" /></a>
      
      </td>
		
        </tr>
      </c:forEach>


</table>

<footer><jsp:include page="footer.jsp"/></footer>
</body>
</html>