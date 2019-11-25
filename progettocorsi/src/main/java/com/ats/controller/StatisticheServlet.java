package com.ats.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import com.ats.service.StatisticheService;

public class StatisticheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StatisticheServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		
		StatisticheService stSe = null;
				
		try {
			stSe = new StatisticheService();
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		
		CorsistaService cs = null;
		try {
			cs = new CorsistaService();
		} catch (DaoException e2) {
			e2.printStackTrace();
		}
		
		DaoDatiCorsiImplService corsiService = null;
		try {
			corsiService = new DaoDatiCorsiImplService();
		} catch (DaoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	
		
//		I.    Numero corsisti totali.		
		int corsistiTot = 0;
		try {
			corsistiTot = stSe.CorsistiTotali();
		} catch (DaoException e) {
			e.printStackTrace();
		}
				
		session.setAttribute("corsistiTot", corsistiTot);
		System.out.println("corsistiTot" + corsistiTot);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);	
		
		
//		II.   Nome del corso più frequentato
		String corso = null;
		try {
			corso = stSe.CorsoPiuFrequentato();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		session.setAttribute("corso", corso);
		System.out.println("corso" + corso);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);	
		
		
//		III.  Data di inizio ultimo corso
		LocalDate data = null;
		try {
			data = stSe.DataInizioUltimoCorso();
		} catch (DaoException e) {
			e.printStackTrace();
		}		
		session.setAttribute("data", data);
		System.out.println("data" + data);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);	

		
//		IV.   Durata media dei corsi ( in giorni lavorativi )
		double media = 0;
		try {
			media = stSe.DurataMediaCorsi();
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		session.setAttribute("media", media);
		System.out.println("media" + media);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);
	
		
//		V.    Numero di commenti presenti	
		int commentiTot = 0;
		try {
			commentiTot = stSe.NumeroCommenti() ;
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		session.setAttribute("commentiTot", commentiTot);
		System.out.println("commentiTot" + commentiTot);
		rd= request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);

		
//		VI.   Elenco corsisti	
		LinkedList <DatiCorsisti> listaCorsisti = new LinkedList<DatiCorsisti>();
		try {
			listaCorsisti = cs.selectAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		session.setAttribute("listaCorsisti", listaCorsisti);
		System.out.println("listaCorsisti" + listaCorsisti);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);
		
		int codiceCorsista = Integer.parseInt((String)request.getParameter("codcorsista"));
		DatiCorsisti corsista = new DatiCorsisti();
		
		 try {
			corsista = cs.getCorsistaById(codiceCorsista);	
			
			if (corsista!=null) {
				cs.getCorsistaById(codiceCorsista);
				rd = request.getRequestDispatcher("ProfiloCorsista.jsp");				
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
		 
			
//		VII.  Docente che può tenere più tipologie di corso
		DatiDocenti docente = new DatiDocenti();
		try {
			docente = stSe.DocentePiuCorsi();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		session.setAttribute("docente", docente);
		System.out.println("docente" + docente);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);
	
			
//		VIII. Corsi con posti disponibili
		
		LinkedList <DatiCorsi> listaCorsiDisp = new LinkedList <DatiCorsi>();
		listaCorsiDisp = null;
		try {
			listaCorsiDisp = corsiService.listaCorsibyData();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("listaCorsiDisp", listaCorsiDisp);
		System.out.println("listaCorsiDisp" + listaCorsiDisp);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);
		
		
		
	}	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}

}