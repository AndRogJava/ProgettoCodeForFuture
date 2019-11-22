package com.ats.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;
import com.ats.service.CorsistaService;






public class IscrizioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IscrizioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CorsistaService cs = null;
		try {
			cs = new CorsistaService();
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		//boolean nomeuser_ok=true;
		DatiCorsisti Corsistatrovato=null;
		
			try {
				Corsistatrovato = cs.getCorsistaById(0);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	if (Corsistatrovato.getNomecorsista()==null) {
	DatiCorsisti corsista=new DatiCorsisti();
	corsista.setNomecorsista(request.getParameter("nomecorsista"));
	corsista.setCognomecorsista(request.getParameter("cognomecorsista"));
	corsista.getCodcorsista();
	
	corsista.setPrecedentiformativi(request.getParameter("precedentiformativi"));
	}
	
	response.getWriter().append("Iscrizione avvenuta con successo");
	session.setAttribute("UtenteCorrente",Corsistatrovato);
	rd= request.getRequestDispatcher("lista.jsp");
	rd.forward(request, response);
}
}
	

