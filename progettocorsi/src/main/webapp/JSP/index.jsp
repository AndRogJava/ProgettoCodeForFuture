
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
<h1 style="color:#0c6914" class="serif"> Benevenuto Admin!</h1>
<h2 style="color:#0c6914" class="serif"> Per accedere alla tua pagina di gestione dei corsi effettua il login</h2>

<form action="LoginServlet" method="POST">

<b style="color:#0c6914" class="serif">Nome admin: </b><input class="italic" class="serif" placeholder ="nome admin" type = "text" name="nomeadmin" required> <br>

<b style="color:#0c6914" class="serif">Codice admin: </b><input class="italic" class="serif" placeholder ="codice admin" type = "text" name="codadmin" required> <br>

<br>
<a href="ListaServlet">clicca qui</a>
<footer><jsp:include page="/JSP/footer.jsp"/></footer>


</form>
</body>
</html>