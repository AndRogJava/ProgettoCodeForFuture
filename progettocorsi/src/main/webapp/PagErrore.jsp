<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PagErrore</title>
</head>
<body>

<h3>Sorry an exception occured!</h3>  

<%String stampa= (String)session.getAttribute("erroreDao");
if (stampa!=null){
response.getWriter().append(stampa);}
%>

 
</body>
</html>