package com.ats.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Synthesizer;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;
import com.ats.service.CorsistaService;


	@WebServlet("/ListaServlet")
	public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			

		public ListaServlet() {
		super();
			
		}
			

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// String nomeIns=request.getParameter("Nomeadmin");
		// int codIns=request.getParameter("Codadmin"); ------
		System.out.println("sono nella Servlet");
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		CorsistaService cs = null; 
		try {
			cs = new CorsistaService();
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		LinkedList<DatiCorsisti> listaTutti = new LinkedList<DatiCorsisti>();
		
		
		try {
			listaTutti = cs.selectAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listaTutti);
		session.setAttribute("lista", listaTutti);
		System.out.println("stampalista" + listaTutti);
		 
		rd=request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
		
		}

		
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}
		}