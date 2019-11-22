<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title >Header</title>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<ul>
  <li><a class="serif" href="#lista">Corsi Attivi</a></li>
  <li><a class="serif" href="#Statistiche">Statistiche</a></li>
  <li class="serif" style="float:right"><a class="active" href="#login">Login</a></li>
  <% String nome =(String)session.getAttribute("nomeadmin");
	        if (nome!=null) {
	        out.println (nome); %>
	        <li class="serif" style="float:right"><a class="active" href="#nomeadmin"><%=nome%></a></li>   
	        <%
	        }%>
                       
  <% String codiceadmin =(String)session.getAttribute("codiceadmin");
	        if (codiceadmin!=null){%>
	        <li class="serif" style="float:right"><a class="active" href="#logout">Logout</a></li>
	     <% } %>
  
  
</ul>
</body>
</html>




