<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body class="img">


<div class="box">
<h1 style="color:#0c6914" class="serif"> Benvenuto Admin!</h1>
<h2 style="color:#0c6914" class="serif"> Per accedere alla tua pagina di gestione dei corsi effettua il login</h2>

<form action="LoginServlet" method="POST">
<b style="color:#0c6914" class="serif">Nome admin: </b><input class="italic" class="serif" placeholder ="nome admin" type = "text" name="nomeadmin" required> <br>
<br>
<b style="color:#0c6914" class="serif">Codice admin: </b><input class="italic" class="serif" placeholder ="codice admin" type = "number" name="codadmin" required> <br>
<br>
<input type="submit" value="Login">


<% if (session.getAttribute("error") != null) {
				out.println(session.getAttribute("error"));
			}
%>

</form>
<br> 
</div>

<footer><jsp:include page="footer.jsp"/></footer>

</body>
</html>
