package com.ats.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;
import com.ats.service.DatiAmministratoriService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		DatiAmministratoriService as=null;
		try {
			as = new DatiAmministratoriService();
		} catch (DaoException e1) {
			
			e1.printStackTrace();
		}
		DatiAmministratori amministratore = new DatiAmministratori();
		String nomeIns = request.getParameter("nomeadmin");
		int codice = Integer.parseInt(request.getParameter("codadmin"));
	
		
		try {
			amministratore = as.getAmministratorebyUsername(codice);
			System.out.println("nome" + amministratore);
			if (amministratore!=null  && amministratore.getCodadmin()==codice && amministratore.getNomeadmin().equalsIgnoreCase(nomeIns)) {
				session.setAttribute("nomeadmin", nomeIns);		
				session.setAttribute("codadmin", codice);
				rd = request.getRequestDispatcher("lista.jsp");
				rd.forward(request,response);

			}else  {
				String error = "Credenziali invalide!";
				session.setAttribute ("error", error);
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request,response);
			}


		} catch (DaoException e) {
//			sql.printStackTrace(); gestione eccezioni per quando avremo la jsp dell'errore
//			sql.getMessage();
//			rd = request.getRequestDispatcher("Error.jsp");
//			session.setAttribute("Errore","Siamo spiacenti, si è verificato un errore durante il login.");
//			richiesta.forward(request, response);
			e.printStackTrace();
		}

		
		}

}