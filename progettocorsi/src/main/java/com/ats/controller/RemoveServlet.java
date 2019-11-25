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
import com.ats.model.DatiCorsi;
import com.ats.service.DaoDatiCorsiImplService;


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public RemoveServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		DaoDatiCorsiImplService corsoService = null;
		//int corsoIns=Integer.parseInt(session.getAttribute("corsoCanc"));
		int corsoIns=Integer.parseInt(request.getParameter("corsoCanc"));
		try {
			corsoService = new DaoDatiCorsiImplService();
			corsoService.deleteCorso(corsoIns);
			session.setAttribute("CorsoCancellato", "Il corso è stato cancellato!");
			rd= request.getRequestDispatcher("listaCancellaCorsi.jsp");
			rd.forward(request, response);
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during DeleteCorso");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
			
		}

}  

			

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		DaoDatiCorsiImplService corsoService = null;
		try {
			corsoService = new DaoDatiCorsiImplService();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		LinkedList <DatiCorsi> listaCorsi = new LinkedList <DatiCorsi>();
		
		try {
			listaCorsi = corsoService.getallCorsi();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		session.setAttribute("listaCorsi", listaCorsi);
		rd= request.getRequestDispatcher("listaCancellaCorsi.jsp");
		rd.forward(request, response);
	}

}


