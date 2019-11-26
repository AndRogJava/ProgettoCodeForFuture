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
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		LinkedList<DatiCorsisti> listaTutti = new LinkedList<DatiCorsisti>();

		try {

			CorsistaService cs = new CorsistaService();
			listaTutti = cs.selectAll();
			

		} catch (DaoException e) {
			e.printStackTrace();
		}
		System.out.println(listaTutti);
		session.setAttribute("lista", listaTutti);
		System.out.println("stampalista" + listaTutti);
		
		rd=request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}