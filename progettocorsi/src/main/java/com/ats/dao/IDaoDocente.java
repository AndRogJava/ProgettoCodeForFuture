package com.ats.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiDocenti;

public interface IDaoDocente {
	
	public void addDocente (DatiDocenti docente) throws DaoException;
	
	public void updateDocente (DatiDocenti docente) throws DaoException;
	
	public void deleteDocente (int coddocente) throws DaoException;
	
	public LinkedList<DatiDocenti> selectAll() throws DaoException;
	
	public DatiDocenti getDocenteById (int coddocente) throws DaoException;

}