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

<div class="box">
<h3 style="color:#0c6914" class="serif">La pagina non è al momento disponibile</h3>  

<h2 style="color:#0c6914" class="serif">:(</h2>
<a href="index.jsp">Torna alla Home Page</a>
<br>
<br>
<%String stampa= (String)session.getAttribute("erroreDao");
if (stampa!=null){
response.getWriter().append(stampa);}
%>

</div>
<footer><jsp:include page="footer.jsp"/><br></footer>

 
</body>
</html>