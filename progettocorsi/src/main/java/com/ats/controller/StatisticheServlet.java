package com.ats.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;
import com.ats.service.CorsistaService;
import com.ats.service.StatisticheService;

@WebServlet("/StatisticheServlet")
public class StatisticheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StatisticheServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sono nella servlet - get");
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
	
		StatisticheService stSe = null;
		CorsistaService cs = null;
		try {
			stSe = new StatisticheService();
			cs = new CorsistaService();
			
		} catch (DaoException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		I.    Numero corsisti totali.		
		int corsisti = 0;
		try {
			corsisti = stSe.CorsistiTotali();
			System.out.println(corsisti);
			System.out.println(stSe.CorsistiTotali());
			
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		session.setAttribute("corsistiTot", corsisti);
		System.out.println("corsistiTot" + corsisti);
		
		
//		II.   Nome del corso più frequentato
		String corso = null;
		try {
			corso = stSe.CorsoPiuFrequentato();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("corsoPiuFreq", corso);
		System.out.println("corsoPiuFreq" + corso);
		
		
//		III.  Data di inizio ultimo corso
		LocalDate data = null;
		try {
			data = stSe.DataInizioUltimoCorso();
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		session.setAttribute("dataInizio", data);
		System.out.println("dataInizio" + data);
		
//		IV.   Durata media dei corsi ( in giorni lavorativi )
		double media = 0;
		try {
			media = stSe.DurataMediaCorsi();
		} catch (DaoException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("media", media);
		System.out.println("media" + media);
	
		
//		V.    Numero di commenti presenti	
		int commentiTot = 0;
		try {
			commentiTot = stSe.NumeroCommenti() ;
		} catch (DaoException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("commentiTot", commentiTot);
		System.out.println("commentiTot" + commentiTot);

		
//		VI.   Elenco corsisti	
		LinkedList <DatiCorsisti> listaCorsisti = new LinkedList<DatiCorsisti>();
		try {
			listaCorsisti = cs.selectAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		session.setAttribute("listaCorsisti", listaCorsisti);
		System.out.println("listaCorsisti" + listaCorsisti);

//		int codiceCorsista = Integer.parseInt((String)request.getParameter("codcorsista"));
//		DatiCorsisti corsista = new DatiCorsisti();
//		
//		 try {
//			corsista = cs.getCorsistaById(codiceCorsista);	
//			
//			if (corsista!=null) {
//				cs.getCorsistaById(codiceCorsista);
//				rd = request.getRequestDispatcher("ProfiloCorsista.jsp");				
//			}
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
		 
			
//		VII.  Docente che può tenere più tipologie di corso
		LinkedList<DatiDocenti> ListadocentiPiuCorsi = new LinkedList<DatiDocenti>();
		try {
			ListadocentiPiuCorsi = stSe.DocentePiuCorsi();
			System.out.println(ListadocentiPiuCorsi);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		session.setAttribute("ListadocentiPiuCorsi", ListadocentiPiuCorsi);
		System.out.println("ListadocentiPiuCorsi" + ListadocentiPiuCorsi);
			
//		VIII. Corsi con posti disponibili
		
		HashMap <String, Integer>  listaCorsi = new HashMap <String, Integer>();
		listaCorsi = null;
		try {
			listaCorsi = stSe.corsiConPostiDisponibili();
			System.out.println(listaCorsi);
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("listaCorsi", listaCorsi);
		System.out.println("listaCorsi" + listaCorsi);
		rd = request.getRequestDispatcher("/statistiche.jsp");
		rd.forward(request, response);
	}

				


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

	}