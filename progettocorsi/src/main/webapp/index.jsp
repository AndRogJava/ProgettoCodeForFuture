<html>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<body>
<h1> Benevenuto Admin!</h1>
<h2> Per accedere alla tua pagina di gestione dei corsi effettua il login</h2>

<form action="LoginServlet" method="POST">

<b>Nome:</b><input placeholder ="nome" type = "text" name="nome_inserito"> <br>
<br>
<b>Cognome:</b><input placeholder ="cognome" type = "text" name="cognome_inserito"> <br>
<br>
<b>Codice admin:</b><input placeholder ="codice admin" type = "number" name="codadmin_inserito"> <br>
<br>
<input  type="button" value="Login" name ="bottone">

</form>
</body>
</html>
