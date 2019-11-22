package com.ats.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.dao.DaoStatistiche;
import com.ats.exception.DaoException;
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
		
	}
		
		
		//		I.    Numero corsisti totali.
		 
//		II.   Nome del corso più frequentato
		
				
//		III.  Data di inizio ultimo corso
				
//		IV.   Durata media dei corsi ( in giorni lavorativi )
				
//		V.    Numero di commenti presenti
				
//		VI.   Elenco corsisti
				
//		VII.  Docente che può tenere più tipologie di corso
				
//		VIII. Corsi con posti disponibili

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Al punto VI. cliccando sul nome del corsista si deve 
		//aprire la pagina contenente il riepilogo con le informazioni 
		//dei corsi da lui frequentati.
		
 
		doGet(request, response);
	}

}


