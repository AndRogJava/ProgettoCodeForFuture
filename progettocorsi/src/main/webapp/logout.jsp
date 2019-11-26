<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>

<body class="img">


<header><jsp:include page="header.jsp" /></header>
	<div class="box">
	    
		<h1><font color="#0c6914">Hai eseguito con successo il logout</font></h1>
		<a href="index.jsp">Torna alla Home Page</a>
		<br>
		<br>
</div>

<%
		session.invalidate();

	%>
	
</body>


<footer><jsp:include page="footer.jsp"/></footer>

</html>