package com.ats.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class ValidatorUtente {
private static ResourceBundle bundle = ResourceBundle.getBundle("risorse/info");
	
	/*
	 * regole di validazione per la registrazione dell'utente
	 */
	public static ArrayList<ErroreValidazione> validazioneUtente(HttpServletRequest request){
		ArrayList<ErroreValidazione> lista = new ArrayList<ErroreValidazione>();
		//Nome corsista
		String nomecorsista = request.getParameter("nomecorsista");
		if(nomecorsista == null || nomecorsista.length()==0)
			lista.add(new ErroreValidazione("nomecorsista", "nomecorsista " + bundle.getString("error.required")));
		else if(nomecorsista.contains("[0-9]+"))
			lista.add(new ErroreValidazione("nomecorsista", bundle.getString("error.type.string")));
		else if(nomecorsista.length()<30)
			lista.add(new ErroreValidazione("nomecorsista", bundle.getString("error.maxlength") + " 30"));
		
		//Cognome corsista
		String cognomecorsista = request.getParameter("cognomecorsista");
		if(cognomecorsista == null || cognomecorsista.length()==0)
			lista.add(new ErroreValidazione("cognomecorsista", "cognomecorsista " + bundle.getString("error.required")));
		else if(cognomecorsista.contains("[a-zA-Z]+") == false)
			lista.add(new ErroreValidazione("cognomecorsista", bundle.getString("error.type.string")));
		else if(cognomecorsista.length()<30)
			lista.add(new ErroreValidazione("cognomecorsista", bundle.getString("error.maxlength") + " 30"));
		
		//Nome corso
		String nomecorso = request.getParameter("nomecorso");
		if(nomecorso == null || nomecorso.length()==0)
			lista.add(new ErroreValidazione("nomecorso", "nomecorso" + bundle.getString("error.required")));
		else if(nomecorso.contains("[a-zA-Z]+") == false)
			lista.add(new ErroreValidazione("nomecorso", bundle.getString("error.type.string")));
		else if(nomecorso.length()<30)
			lista.add(new ErroreValidazione("nomecorso", bundle.getString("error.maxlength") + " 30"));
		
		//Data inizio corso
		String data_iniziocorso = request.getParameter("data_iniziocorso");
	
		LocalDate inizio = LocalDate.parse(data_iniziocorso);
		
		LocalDate afterInizio = LocalDate.now();
		
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		if (data_iniziocorso == null ||data_iniziocorso.length()==0) {
			lista.add(new ErroreValidazione("data_iniziocorso", "data_iniziocorso " + bundle.getString("error.data.esistente")));
		}
		else if (inizio == LocalDate.now()) {
			lista.add(new ErroreValidazione("data_iniziocorso", "data_iniziocorso" + bundle.getString("error.data.esistente")));
		}
		else if (afterInizio.isAfter(inizio)) {
			lista.add(new ErroreValidazione("data_iniziocorso", "data_iniziocorso " + bundle.getString("error.data.nascita"))); 
		}
		
		//Data fine corso
		String data_finecorso = request.getParameter("data_iniziocorso");
	
		LocalDate fine = LocalDate.parse(data_finecorso);
		
		LocalDate afterFine = LocalDate.now();
		
		DateTimeFormatter formatta = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		
		if (data_finecorso == null ||data_finecorso.length()==0) {
			lista.add(new ErroreValidazione("data_finecorso", "data_finecorso " + bundle.getString("error.data.esistente")));
		}
		else if (fine == LocalDate.now()) {
			lista.add(new ErroreValidazione("data_finecorso", "data_finecorso" + bundle.getString("error.data.esistente")));
		}
		else if (afterFine.isAfter(fine)) {
			lista.add(new ErroreValidazione("data_finecorso", "data_finecorso " + bundle.getString("error.data.nascita"))); 
		}
	
		
		//Commenti corso
		String commenticorso = request.getParameter("commenticorso");
		if(commenticorso.length()<30)
			lista.add(new ErroreValidazione("commenticorso", bundle.getString("error.maxlength") + " 200"));
		
		//Precedenti formativi
		String precedentiformativi = request.getParameter("precedentiformativi");
		if(precedentiformativi == null)
			lista.add(new ErroreValidazione("precedentiformativi", bundle.getString("error.required")));
		
		//Aula corso
		String aulacorso = request.getParameter("aulacorso");
		if(aulacorso.length()<30)
			lista.add(new ErroreValidazione("aulacorso", bundle.getString("error.maxlength") + " 30"));
		else if(aulacorso.contains("[0-9]+")||aulacorso.contains("[a-zA-Z]+"))
			lista.add(new ErroreValidazione("nomecorsista", bundle.getString("error.type.numlet")));
		
		return lista;
	}
}
