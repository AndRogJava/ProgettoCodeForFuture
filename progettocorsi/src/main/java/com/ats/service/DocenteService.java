package com.ats.service;

import java.util.LinkedList;

import com.ats.dao.DaoDocente;
import com.ats.exception.DaoException;
import com.ats.model.DatiDocenti;

public class DocenteService {
	
	public DocenteService() throws DaoException {}
	
	DaoDocente daoDocente=new DaoDocente();
	
	public void addDocente (DatiDocenti docente) throws DaoException{
		daoDocente.addDocente(docente);
	}
	
	public void updateDocente (DatiDocenti docente) throws DaoException{
		daoDocente.updateDocente(docente);
	}
	
	public void deleteDocente (int coddocente) throws DaoException{
		daoDocente.deleteDocente(coddocente);
	}
	
	public LinkedList<DatiDocenti> selectAll() throws DaoException{
		return daoDocente.selectAll();
	}
	
	public DatiDocenti getDocenteById (int coddocente) throws DaoException{
		return daoDocente.getDocenteById(coddocente);
	}

}
