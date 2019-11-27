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

  <% String nome =(String)session.getAttribute("nomeadmin");
	        if (nome!=null) { %>
	        <li class="serif" style="float:right"><a class="active"><%=nome%></a></li>   
	        <%
	        }%>
                       
  <% Integer codadmin =(Integer)session.getAttribute("codadmin");
	        if (nome!=null && codadmin!=0){%>
	        <li class="serif" style="float:right"><a class="active" href="logout.jsp">Logout</a>
	        <%session.invalidate();%></li>
	        <li class="serif"><a href="StatisticheServlet">Statistiche</a></li>
	        
	     <% } %>
  
</ul>


</body>

</html>




