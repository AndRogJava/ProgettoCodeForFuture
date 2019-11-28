package com.ats.controller;

import java.io.IOException;

import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.CorsiCorsisti;

import com.ats.service.CorsiCorsistiService;





@WebServlet ("/AggiornaProfiloServlet")
public class AggiornaProfiloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public AggiornaProfiloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     	HttpSession session = request.getSession();
        RequestDispatcher rd=null;
        CorsiCorsistiService corsoAgg = null;
		try {
			CorsiCorsisti corsista = new CorsiCorsisti ();
			  int idCorsista = Integer.parseInt(request.getParameter("codcorsista"));
			  System.out.println(idCorsista);
			corsista.setCodcorsista(idCorsista);
			corsoAgg = new CorsiCorsistiService();
		  
			
			LinkedList<CorsiCorsisti> listaCorsiCorsisti =  new LinkedList<CorsiCorsisti>  ();
			listaCorsiCorsisti.add(corsista);
			listaCorsiCorsisti = corsoAgg.selectAllByCodCorsista(idCorsista);
			System.out.println(listaCorsiCorsisti);
			
			session.setAttribute("corsoAgg", listaCorsiCorsisti);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		rd = request.getRequestDispatcher("AddCorso.jsp");
		rd.forward(request, response);
		
      

}    

			

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
//		String corsistaScelto = (String)session.getAttribute("UtenteCorrente"); 
//		DaoDatiCorsiImplService corsoService = null;
//		LinkedList <DatiCorsi> listaCorsi = new LinkedList <DatiCorsi>();
//		try {
//			listaCorsi = corsoService.getallCorsi();
//			session.setAttribute("listaCorsi", listaCorsi);
//			rd= request.getRequestDispatcher("AddCorso.jsp");
//			rd.forward(request, response);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	
		try {
			CorsiCorsistiService corsoAggiunto = new CorsiCorsistiService ();
			int idCorsista = Integer.parseInt(request.getParameter("codcorsista"));
			int idCorso = Integer.parseInt(request.getParameter("codcorso"));
			
			CorsiCorsisti corsistacorso = new CorsiCorsisti ();
			corsistacorso.setCodcorsista(idCorsista);
			corsistacorso.setCodcorso(idCorso);
			
			
			
			 corsoAggiunto.addRelazioneCorsoCorsista(corsistacorso);
				response.getWriter().append("Corso aggiunto con successo!!");
				session.setAttribute("corsoAggiunto", corsoAggiunto );
				rd = request.getRequestDispatcher("AddCorso.jsp");
				rd.forward(request, response);
			
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}



