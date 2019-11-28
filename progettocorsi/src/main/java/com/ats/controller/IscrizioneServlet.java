package com.ats.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;

import com.ats.service.CorsistaService;
import com.ats.service.DaoDatiCorsiImplService;
import com.ats.service.DocenteService;
import com.ats.service.StatisticheService;
import com.ats.validator.*;

import oracle.sql.ARRAY;


@WebServlet("/IscrizioneCorsistaServlet")
public class IscrizioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public IscrizioneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		
		// CORSO
		DatiCorsi corso = new DatiCorsi();
		String nomecorso= request.getParameter("nomecorso");
		
		
		try {
			DaoDatiCorsiImplService datiCorsiService = new DaoDatiCorsiImplService();
			LinkedList<DatiCorsi> datiCorso=null; 
			datiCorso= datiCorsiService.getCorsobyNomeCorso(nomecorso);
			session.setAttribute("datiCorso",datiCorso);
			//request.getRequestDispatcher("WEB-INF/InserisciCorsista.jsp").forward(request, response);
			
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 
		
		
		//DOCENTI

		DatiDocenti docenti =new DatiDocenti();
		docenti.setNomedocente(request.getParameter("nomedocente"));
		docenti.setCognomedocente(request.getParameter("cognomedocente"));
		

		try {
			StatisticheService ss = new StatisticheService();
			LinkedList <DatiDocenti> docentiPerNomeCorsi =null;
			docentiPerNomeCorsi=ss.docentiPerNomeCorsi(nomecorso);			 
			System.out.println("prova " + docentiPerNomeCorsi);
			session.setAttribute("docentiPerNomeCorsi",docentiPerNomeCorsi);
			request.getRequestDispatcher("InserisciCorsista.jsp").forward(request,response);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			//VALIDAZIONE
		ArrayList<ErroreValidazione> lista = new ArrayList<ErroreValidazione>();
		lista=ValidatorUtente.validazioneUtente(request);
		if(lista.size()!=0) {
			request.setAttribute("lista",lista);
			getServletContext().getRequestDispatcher("/WEB-INF/InserisciCorsista.jsp").forward(request,response);
		}
		

	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("Ciao sono entrata");
			
			HttpSession session = request.getSession();
			RequestDispatcher rd=null;
			
			String tagControllo= request.getParameter("tagControllo");
			String nomedocente= request.getParameter("selected_value");
			System.out.println(nomedocente);
			
			
			if(tagControllo.equals("fineBlocco3")) {
			
			
			
			DatiDocenti docenteTrovato= new DatiDocenti();
			
		
			
			LinkedList <DatiDocenti> listaDocenti= (LinkedList<DatiDocenti>) session.getAttribute("docentiPerNomeCorsi");
			
		for(int i =0; i<listaDocenti.size();i++) {
			if(listaDocenti.get(i).getNomedocente().equalsIgnoreCase(nomedocente)) {
				docenteTrovato=listaDocenti.get(i);
			}
		}
		
		int codiceDocenteTrovato=docenteTrovato.getCoddocente();
		LocalDate oggi= LocalDate.now();
		LinkedList <DatiCorsi> listaCorsiConDocente= (LinkedList<DatiCorsi>) session.getAttribute("datiCorso");
		for(int i =0; i<listaCorsiConDocente.size();i++) {
			if( (listaCorsiConDocente.get(i).getCoddocente()!=codiceDocenteTrovato) || listaCorsiConDocente.get(i).getData_iniziocorso().isBefore(oggi)) {
				listaCorsiConDocente.remove(listaCorsiConDocente.get(i));
			}
			
		}
		LinkedList <String> listaDate= new LinkedList <String> ();
		for (int i =0; i<listaCorsiConDocente.size();i++) {
			String dataDaAggiungere=(listaCorsiConDocente.get(i).getData_iniziocorso()).toString();
			listaDate.add(dataDaAggiungere);
		}
		
				
		System.out.println(listaCorsiConDocente);
		session.setAttribute("listaCorsiFinale", listaCorsiConDocente);
		session.setAttribute("listaDate", listaDate);
		
		request.getRequestDispatcher("InserisciCorsista.jsp").forward(request,response);
		
	}	
			if(tagControllo.equals("fineBlocco4")) {
				DatiCorsi corsoDefinitivo = new DatiCorsi();
				LinkedList<DatiCorsi> listaCorsiConDocente=(LinkedList<DatiCorsi>) session.getAttribute("listaCorsiFinale");
				
				String dataRecuperata= request.getParameter("selected_value_date");
				//LocalDate dataRecuperataD=LocalDate.(dataRecuperata);
			
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate dataRecuperataD = LocalDate.parse(dataRecuperata, formatter);
				
				
				System.out.println(dataRecuperataD);
			
			
				for(int i =0; i<listaCorsiConDocente.size();i++) {
					if( listaCorsiConDocente.get(i).getData_iniziocorso().equals(dataRecuperataD)) {
						corsoDefinitivo=listaCorsiConDocente.get(i);
					}
				}
					System.out.println("stampa corso definitvo" + corsoDefinitivo);
					session.setAttribute("corsoDefinitivo", corsoDefinitivo);
					request.getRequestDispatcher("InserisciCorsista.jsp").forward(request,response);
		
				
	
			}
	}
}

