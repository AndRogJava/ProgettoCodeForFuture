<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ats.controller.ListaServlet"%>
<%@ page import="com.ats.dao.*"%>
<%@ page import="com.ats.model.*"%>
<%@ page import="java.util.LinkedList"%>
 <%@ page isELIgnored="false"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>lista</title>
</head>

<body class="img">
<style>
th, td {
	border: 3px solid #111;
	padding: 8px;
}

thead {
	background-color: #449D48;
}
</style>
<table align="center">

	<thead>
<tr>

	<b><h2><td>NOME CORSISTA</td></h2></b>
	<b><h2><td>COGNOME CORSISTA</td></h2></b>
</tr>
	</thead>

<c:forEach items="${lista}" var="current">
		
		<tr>
			<td>${current.nomecorsista}</td>
			<td>${current.cognomecorsista}</td>
			
	
		</tr>	
	</c:forEach>
	 </table>
	 <div>
	 <a href="AddCorso.jsp">
	 <input type="button" name="Aggiungi corso" value="aggiungiCorso">
	 </a>
	 </div>
<footer><jsp:include page="footer.jsp" /></footer>
</html>
