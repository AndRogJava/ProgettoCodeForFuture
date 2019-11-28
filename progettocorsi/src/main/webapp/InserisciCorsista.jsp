<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored ="false" %>
<%@ page import="java.util.*"%>
<%@ page import="java.time.LocalDate"%>
        <%@ page import="com.ats.model.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="CSS/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
	
<title>Inserisci Corsista</title>

		   	<script type="text/javascript">
		   	
		   

				$(document).ready(function(){
				
					$('#my_radio_box').change(function(){
						selected_value = $("input[name='my_options']:checked").val();
			            alert(selected_value);
			            
			            console.log('sono una funzione');
			        	

			        	var tagControllo="fineBlocco3";
			        	var data="selected_value=" + selected_value + "&tagControllo="+ tagControllo;
			        
			        	$.ajax({
			                type: 'POST',
			                url: 'IscrizioneCorsistaServlet',
			                data:data,
			             
			                error: function(response) {
			                    // Gets called when an error occurs with error details in variable response
			                },
			    
			        });
				
		
					});
				});
				
				
				$(document).ready(function(){
					
					$('#date').change(function(){
						
						//var e = getParameterByName('calendario');
						selected_value_date = document.getElementById("date").value;
							//$("input[name='date']:checked").val();
			            alert(selected_value_date);
						
			         
			            console.log('sono una funzione 2');
			        	

			        	var tagControllo=("fineBlocco4");
			        	var data="selected_value_date=" + selected_value_date + "&tagControllo="+ tagControllo;
			        	$.ajax({
			                type: 'POST',
			                url: 'IscrizioneCorsistaServlet',
			                data:data,
			                error: function(response) {
			                    // Gets called when an error occurs with error details in variable response
			                },
			    
			        });
				
		
					});
				});
				

				</script>
				
				 <script>
				            $(document).ready(function(){
				                document.getElementById("nomecorso").value = sessionStorage.getItem("item1");
				            });
				        </script>
				        <script>
				            $(window).on('beforeunload', function() {
				            	sessionStorage.setItem("item1",document.getElementById("nomecorso").value);
				            });

				        </script>
				        <script>
				            $(document).ready(function(){
				                document.getElementById("my_options").value = sessionStorage.getItem("item2");
				            });
				        </script>
				        <script>
				            $(window).on('beforeunload', function() {
				            	sessionStorage.setItem("item2",document.getElementById("my_options").value);
				            });

				        </script>
				         
	<script>
  $( function() {
    $( "#date" ).datepicker();
  } );
  </script>
  
  
  
		       
</head>


<body>

 
<header><jsp:include page="header.jsp"/></header> <br>
<br>
<!-- INIZIO BLOCCO 1: Prelevo le info inserite riguardo al corsista e creo corsista -->


<form action="IscrizioneCorsistaServlet" method="get" name="modulo">
	
	
<!-- FINE BLOCCO 1 --><!-- INIZIO BLOCCO 2: inserisco nome corso, creo linkedlist corsi e linked list docebti. salvo lList docenti in un attr. di sessione-->
<b>Nome Corso:</b><input placeholder=" " type="text" name="nomecorso" id= "nomecorso" maxlength="30" required><br>
<br>

<input type="submit" name=" Bottone" value="Carica Dati Corso"> <br>
<br>
</form>
<!-- FINE BLOCCO 2 -->

<!-- INIZIO BLOCCO 3: Visualizzazione lista docenti che tengono i corsi con quel nomeCorso e scelta docenti. Preparazione lista di date inizio possibili. -->

<!-- <form action="IscrizioneCorsistaServlet" method="POST" name="modulo"> -->

<b><i>Docenti:</i></b>
<br>


<% 
 session.getAttribute("docentiPerNomeCorsi");

 %>

<form id="my_radio_box" action="IscrizioneCorsistaServlet" method="POST" name="modulo">
		    <c:forEach items="${docentiPerNomeCorsi}" var="Docenti"> 
		   
		   
		    <input type="radio" name="my_options" id="my_options" value="${Docenti.nomedocente}" /> <c:out value="${Docenti.nomedocente}" />
		    
		    
		    </c:forEach>
		</form>
	
 
<br>

<!-- FINE BLOCCO 3 --> <!-- INIZIO BLOCCO 4: caricamento lista date iniziali disponibili, scelta della data, visualizzazione Aula e commenti-->

<!-- <b>Data Inizio Corso:</b><input type="date" name="data_iniziocorso" required><br> -->
<br>
<% 
 session.getAttribute("listaCorsiFinale");

 %>
	
<b>Data Inizio Corso:</b> <!-- <form id="my_radio_box_dateInizio" action="IscrizioneCorsistaServlet" method="POST" name="modulo"> -->


<p>Date: <input type="text" id="date" name="calendario"></p>
	
	<script>
	console.log("${listaDate}");
	var arrayTmp="${listaDate}";
	var i;
	var arrayDate=[];
	for (i=1; i<"${listaDate}".length-10; i+=12){
		var x=arrayTmp.slice(i,i+10);
		var y=x.substring(0,10);
		arrayDate.push(y)
		
	}
	console.log(arrayDate);

	function available(date) {
	  dmy =  date.getFullYear()+ ("-0")+ (date.getMonth()+1) + ("-0") +date.getDate();
	  dmy2=date.getFullYear()+ ("-0")+ (date.getMonth()+1) + ("-") +date.getDate();
	  dmy3=date.getFullYear()+ ("-")+ (date.getMonth()+1) + ("-0") +date.getDate();
	  dmy4=date.getFullYear()+ ("-")+ (date.getMonth()+1) + ("-") +date.getDate();
	  if (($.inArray(dmy, arrayDate) != -1)||($.inArray(dmy2, arrayDate) != -1)||($.inArray(dmy3, arrayDate) != -1)||($.inArray(dmy4, arrayDate) != -1)) {
	    return [true, "","Available"];
	  } else {
	    return [false,"","unAvailable"];
	  }
	}

	$('#date').datepicker({ beforeShowDay: available });
	</script>
	    
			
		
<b>Data Fine Corso:</b>
<br>

<%  session.getAttribute("corsoDefinitivo");%>
<c:out value="${corsoDefinitivo.data_finecorso}"/>


<br>
<b>Aula Corso:</b><br>
<br>
<c:out value="${corsoDefinitivo.aulacorso}"/> <br>

<b><i>Commenti Corso</i></b> 
<br>
<c:out value="${corsoDefinitivo.commenticorso}"/>


<!-- FINE BLOCCO 4 --> <!-- INIZIO BLOCCO 5: submit edizione corso selezionata e creazione relazione corso-corsista-->	

<form action="CreaCorsistaServlet" method="post" name="modulo2">
<br>
<b>Nome:</b><input placeholder =" " type = "text" name="nomecorsista" maxlength="30" required> <br>
<br>

<b>Cognome:</b><input placeholder =" " type = "text" name="cognomecorsista" maxlength="30" required><br>
<br>

<b><i>Precedenti Formativi:</i></b> <br>
<br>
	<input type="radio" name="precedentiformativi" value="Si">Si<br> 
	<input type="radio" name="precedentiformativi" value="No"checked="checked">No<br>
	<br>

<br>

<input type="submit" value="Invia">
</form>
	

</body>

</html>