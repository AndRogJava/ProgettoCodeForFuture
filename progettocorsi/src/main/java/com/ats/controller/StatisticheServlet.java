package com.ats.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.filters.CsrfPreventionFilter;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;
import com.ats.service.CorsistaService;
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CorsistaService cs = null;
		try {
			cs = new CorsistaService();
		} catch (DaoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		I.    Numero corsisti totali.		
		int corsistiTot = 0;
		try {
			corsistiTot = stSe.CorsistiTotali();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("corso", corso);
		System.out.println("corso" + corso);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);	
		
//		III.  Data di inizio ultimo corso
		Date d = null;
		try {
			d = stSe.DataInizioUltimoCorso();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate data = d.toLocalDate();
		
		session.setAttribute("data", data);
		System.out.println("data" + data);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);	
				
//		IV.   Durata media dei corsi ( in giorni lavorativi )
				
//		V.    Numero di commenti presenti
				
//		VI.   Elenco corsisti
	
		LinkedList <DatiCorsisti> listaCorsisti = new LinkedList<DatiCorsisti>();
		try {
			listaCorsisti = cs.selectAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("listaCorsisti", listaCorsisti);
		System.out.println("listaCorsisti" + listaCorsisti);
		rd=request.getRequestDispatcher("statistiche.jsp");
		rd.forward(request, response);
				
//		VII.  Docente che può tenere più tipologie di corso
				
//		VIII. Corsi con posti disponibili
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Al punto VI. cliccando sul nome del corsista si deve 
		//aprire la pagina contenente il riepilogo con le informazioni 
		//dei corsi da lui frequentati.
		
 
		doGet(request, response);
	}

}