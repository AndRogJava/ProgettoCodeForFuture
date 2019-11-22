<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<header><jsp:include page="/JSP/header.jsp"/></header>
<h1 class="serif"> Benevenuto Admin!</h1>
<h2 class="serif"> Per accedere alla tua pagina di gestione dei corsi effettua il login</h2>

<form action="LoginServlet" method="post">

<b class="serif">Nome admin: </b><input class="serif" placeholder ="nome admin" type = "text" name="nomeadmin" required> <br>
<br>
<b class="serif">Codice admin: </b><input class="serif" placeholder ="codice admin" type = "text" name="codadmin" required> <br>
<br>
<a href="ListaServlet">clicca qui</a>


</form>
</body>
</html>
