<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>


<!-- <header><jsp:include page="header.jsp" /></header></footer>-->
	<div>
	    
		<h1><font color="darkgreen">Hai eseguito con successo il logout</font></h1>
		<a href="index.jsp">Torna alla Home Page</a>


</div>
<%
		session.invalidate();
	%>
<!-- <footer><jsp:include page="footer.jsp"/></footer>-->
	</body>



	



</body>
</html>