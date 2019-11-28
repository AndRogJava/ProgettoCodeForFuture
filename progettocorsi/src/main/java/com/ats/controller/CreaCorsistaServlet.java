package com.ats.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.dao.OrdineIdGenerator;
import com.ats.dao.OrdineIdGeneratorCorsiCorsisti;
import com.ats.exception.DaoException;
import com.ats.model.CorsiCorsisti;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.service.CorsiCorsistiService;
import com.ats.service.CorsistaService;

/**
 * Servlet implementation class CreaCorsistaServlet
 */
public class CreaCorsistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CreaCorsistaServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
////CORSISTA
		
		CorsistaService cs = null; 			
		try {
			cs = new CorsistaService();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;

		DatiCorsisti corsista=new DatiCorsisti();

		if (corsista.getNomecorsista()==null) {

			corsista.setNomecorsista(request.getParameter("nomecorsista"));
			corsista.setCognomecorsista(request.getParameter("cognomecorsista"));
			corsista.setPrecedentiformativi(request.getParameter("precedentiformativi"));
			
		}
		try {
			cs.addCorsista(corsista);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int codcorsistaCorretto=0;
		OrdineIdGenerator oig;
		try {
			oig = new OrdineIdGenerator();
			codcorsistaCorretto=oig.getCurrIdCorsista();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		response.getWriter().append("Iscrizione avvenuta con successo");
		session.setAttribute("corsistaDaAggiungere",corsista);
	
		
		DatiCorsi corsoDefinitivo = (DatiCorsi)session.getAttribute("corsoDefinitivo");
		int codcorso= corsoDefinitivo.getCodcorso();
		//int codcorsista=((DatiCorsisti)session.getAttribute("corsistaDaAggiungere")).getCodcorsista();
		System.out.println("stampa cordice corsista" + codcorsistaCorretto);
		
		CorsiCorsisti corsiC = new CorsiCorsisti();
		corsiC.setCodcorso(codcorso);
		corsiC.setCodcorsista(codcorsistaCorretto);
		CorsiCorsistiService ccS;
		try {
			ccS = new CorsiCorsistiService();
		
		
			ccS.addRelazioneCorsoCorsista(corsiC);
		
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		rd= request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
		
	}

}
