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
import com.ats.model.DatiCorsisti;
import com.ats.service.CorsistaService;


@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    
    public ListaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//		String nomeIns=request.getParameter("Nomeadmin");
//		int codIns=request.getParameter("Codadmin");
		
		HttpSession session = request.getSession();
		RequestDispatcher rd=null;
		
		
		LinkedList<DatiCorsisti> listaTutti=null;
		try {
			CorsistaService cs = new CorsistaService();
			listaTutti = cs.selectAll();
		} catch (DaoException e) {
			session.setAttribute("erroreDao", "Error occurred during ListView");
			rd= request.getRequestDispatcher("PagError.jsp");
			rd.forward(request, response);
		}
		
		session.setAttribute("lista", listaTutti);
		System.out.println("stampalista" + listaTutti);
		rd=request.getRequestDispatcher("lista.jsp");
		rd.forward(request, response);
		}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
