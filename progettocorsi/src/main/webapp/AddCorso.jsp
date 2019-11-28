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
<title>Insert title here</title>

</head>
<header><jsp:include page="header.jsp"/></header>
<body>




 <% 
 session.getAttribute("corsoAgg");
System.out.print(session.getAttribute("corsoAgg"));
 %>

            <table>
               <tr>
            <td>Cod.corso</td>
			<td>Cod.docente</td>
			<td>Nome corso</td>
			<td>Data inizio corso</td>
			<td>Data fine corso</td>
			<td>Costo corso</td>
			<td>Commenti corso</td>
			<td>Aula corso</td>
              </tr>

              
  

             <c:forEach items="${listaCorsiCorsisti}" var="current">
             

               
             <td><c:out value="${current.codcorsista}" />
             <td><c:out value="${current.codcorso}" />
              
           </td>
                    
  <a href="AggiornaProfiloServlet">Update</a> 
               </c:forEach>
            

            </table>
<% 
 session.getAttribute("listaCorsi");
System.out.print(session.getAttribute("listaCorsi"));
 %>
     
    <form action=" AggiornaProfiloServlet" method="post" name="eseform" onSubmit="return validaInvio();" >       
    
      
   <select name="corso"> 
    <c:forEach items="${listaCorsi}" var="corso">
    
    <option> <c:out value="${current.codcorso}"></c:out>
    <option> <c:out value="${current.nomecorso}"></c:out>
    <option> <c:out value="${current.coddocente}"> </c:out></option>
    
    
    </c:forEach>
    </select>
   <input  type="button" value="Aggiungicorso" name ="bottoneAggiungi"><br>
   </form>
  


  


<footer><jsp:include page="footer.jsp"/></footer>


</body>
</html>