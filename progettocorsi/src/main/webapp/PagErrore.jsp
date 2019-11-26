<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PagErrore</title>
<link href="CSS/style.css" rel="stylesheet" type="text/css">
</head>
<body class="img">

<h3 style="color:#0c6914" class="serif">Sorry an exception occured!</h3>  
<a href="index.jsp">Torna alla Home Page</a>

<%String stampa= (String)session.getAttribute("erroreDao");
if (stampa!=null){
response.getWriter().append(stampa);}
%>

<footer><jsp:include page="footer.jsp"/><br></footer>

 
</body>
</html>