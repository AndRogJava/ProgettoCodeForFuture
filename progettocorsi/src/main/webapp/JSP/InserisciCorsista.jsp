<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Corsista</title>
</head>
<body>



<form action=" IscrizioneServlet" method="post" name="eseform" onSubmit="return validaInvio();">

<b>Nome:</b><input placeholder =" " type = "text" name=" " size="30" maxlenght="30" required onChange="return controllaNomeCognome();"> <br>
<br>

<b>Cognome:</b><input placeholder =" " type = "text" name=" " size="30" maxlenght="30" required onChange="return controllaNomeCognome;"><br>
<br>

<b>Nome Corso:</b><input placeholder=" " type="text" name="" size="30" maxlenght="30" required><br>
<br>
<b>Data Inizio Corso:</b><input type="date" name="data_iniziocorso" required><br>
<br>
<b>Data Fine Corso:</b><input type="date" name="data_fineCorso" required><br>
<br>

<b><i>Precedenti Formativi:</i></b> <br>
<br>
	<input type="radio" name="command" value="Si"checked=" true">Si<br> 
	<input type="radio" name="command" value="No"checked=" true">No<br>
	<br>
	
<b><i>Commenti</i></b> 
<br>
	<textarea name="commenti" value="commenti" maxlenght="200"></textarea><br>
<br>
<b>Aula Corso:</b><input type="text" name="aulacorso" size="30" maxlenght="30"><br>
<br>
<b><i>Docenti:</i></b>
<br>
	<select name="docenti" >
	<option value="Selene Allevi" selected="selected">Selene Allevi</option>
	<option value="Rossella Di Palma"selected="selected">Rossella Di Palma </option>
	<option value="Saveria Paese"selected="selected">Saveria Paese</option>
	<option value="Andrea Rognetta"selected="selected">Andrea Rognetta</option>
	<option value="Valentina Mama"selected="selected">Valentina Mama</option>
	<option value="--select--" selected="--select--">
	</select>
	
<br>	
<br>
<input type="submit" value="Invia">

	
<script type="text/javascript" language="javascript">

function validaInvio() {
	if (document.eseform.nome.value=="") {
	alert("Inserire cognome e nome");
	return false;
	}
	return true;
}

function controllaNomeCognome() {
var v=parseInt(document.eseform.nome.value);
if (!isNaN(v)) {
alert("Il nome e il cognome non possono essere dei numeri");
return false;
} 
return true;
}


}

</script>
</body>

</html>