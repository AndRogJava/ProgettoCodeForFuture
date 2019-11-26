function Modulo() {
	// Variabili associate ai campi del modulo
	var nome = document.modulo.nomecorsista.value;
	var cognome = document.modulo.cognomecorsista.value;
	var nomeCorso = document.modulo.nomecorso.value;
	var dataInizio = document.modulo.data_iniziocorso.value;
	var dataFine = document.modulo.data_fineCorso.value;
	var commenti = document.modulo.commenticorso.value;
	var precedentiFormativi = document.modulo.precedentiformativi.value;
	var aula = document.modulo.aulacorso.value;
	//var citta = document.modulo.citta.options[document.modulo.citta.selectedIndex].value;

	//Effettua il controllo sul campo NOME
	if ((nome == "") || (nome == "undefined")) {
		alert("Il campo Nome è obbligatorio.");
		document.modulo.nome.focus();
		return false;
	}
	else if(nomecorsista.contains("[0-9]+")){
		alert("Il campo deve contenere solo lettere");
		document.modulo.nome.focus();
		return false;
	}
	else if(nomecorsista.length()<30){
		alert("Il nome inserito non può essere maggiore di 30 caratteri");
		document.modulo.nome.focus();
		return false;
	}	


	//Effettua il controllo sul campo COGNOME
	else if ((cognome == "") || (cognome == "undefined")) {
		alert("Il campo Cognome è obbligatorio.");
		document.modulo.cognome.focus();
		return false;
	}

	else if(cognomecorsista.contains("[a-zA-Z]+") == false){
		alert("Il campo deve contenere solo lettere");
		document.modulo.cognome.focus();
		return false;
	}
	else if(cognomecorsista.length()<30){
		alert("Il cognome inserito non può essere maggiore di 30 caratteri");
		document.modulo.cognome.focus();
		return false;
	}

	//Effettua il controllo sul campo NOME CORSO
	else if ((nomecorso == "") || (nomecorso == "undefined")) {
		alert("Il campo Nome Corso è obbligatorio.");
		document.modulo.nomecorso.focus();
		return false;
	}

	else if(nomecorso.contains("[a-zA-Z]+") == false){
		alert("Il campo Nome Corso deve contenere solo lettere");
		document.modulo.nomecorso.focus();
		return false;
	}
	else if(nomecorso.length()<30){
		alert("Il Nome Corso inserito non può essere maggiore di 30 caratteri");
		document.modulo.nomecorso.focus();
		return false;
	}


	//Effettua il controllo sul campo DATA INIZIO CORSO
	else if (data_iniziocorso == null ||data_iniziocorso.length()==0){
		alert("Inserire una data di inizio");
		document.modulo.data_iniziocorso.focus();
		return false;	
	}

	else if (document.modulo.data_iniziocorso.value.substring(2,3) != "/" ||
			document.modulo.data_iniziocorso.value.substring(5,6) != "/" ||
			isNaN(document.modulo.data_iniziocorso.value.substring(0,2)) ||
			isNaN(document.modulo.data_iniziocorso.value.substring(3,5)) ||
			isNaN(document.modulo.data_iniziocorso.value.substring(6,10))) {
		alert("Inserire data inizio corso in formato gg/mm/aaaa");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}
	else if (document.modulo.data_iniziocorso.value.substring(0,2) > 31) {
		alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
		document.modulo.nascita.select();
		return false;
	}
	else if (document.modulo.data_iniziocorso.value.substring(3,5) > 12) {
		alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}
	else if (document.modulo.data_iniziocorso.value.substring(6,10) < 1900) {
		alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}

	//Effettua il controllo sul campo DATA FINE CORSO
	else if (data_finecorso == null ||data_finecorso.length()==0){
		alert("Inserire una data di fine");
		document.modulo.data_finecorso.focus();
		return false;	
	}	
	else if (document.modulo.data_finecorso.value.substring(2,3) != "/" ||
			document.modulo.data_fineocorso.value.substring(5,6) != "/" ||
			isNaN(document.modulo.data_finecorso.value.substring(0,2)) ||
			isNaN(document.modulo.data_finecorso.value.substring(3,5)) ||
			isNaN(document.modulo.data_finecorso.value.substring(6,10))) {
		alert("Inserire data fine corso in formato gg/mm/aaaa");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}

	else if (document.modulo.data_iniziocorso.value.substring(0,2) > 31) {
		alert("Impossibile utilizzare un valore superiore a 31 per i giorni");
		document.modulo.nascita.select();
		return false;
	}
	else if (document.modulo.data_iniziocorso.value.substring(3,5) > 12) {
		alert("Impossibile utilizzare un valore superiore a 12 per i mesi");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}
	else if (document.modulo.data_iniziocorso.value.substring(6,10) < 1900) {
		alert("Impossibile utilizzare un valore inferiore a 1900 per l'anno");
		document.modulo.data_iniziocorso.value = "";
		document.modulo.data_iniziocorso.focus();
		return false;
	}

	//Effettua il controllo sul campo COMMENTI CORSO
	else if(commenticorso.length()<200){
		alert("Hai superato il limite di caratteri utilizzabili"); 
		document.modulo.commenticorso.focus();
		return false;
	}
	else if (commenticorso == null ||commenticorso.length()==0) {
		alert("Inserisci un commento"); 
		document.modulo.commenticorso.focus();
		return false;
	}
	
	
	//Effettua il controllo sul campo PRECEDENTI FORMATIVI
	else if(precedentiformativi == null){
		alert("Scegli un'opzione"); 
		document.modulo.precedentiformativi.focus();
		return false;
	}
	//Effettua il controllo sul campo AULA CORSO
	else if(aulacorso.length()<30){
		alert("Hai superato il limite di caratteri utilizzabili"); 
		document.modulo.aulacorso.focus();
		return false;
	}
	else if(aulacorso.contains("[0-9]+")==false||aulacorso.contains("[a-zA-Z]+")==false){
		alert("Inserisci lettere e numeri"); 
		document.modulo.aulacorso.focus();
		return false;
	}

	else {
		alert("Tutto ok");
		return true;
	}
}