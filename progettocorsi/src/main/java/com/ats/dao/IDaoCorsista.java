package com.ats.dao;

import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;

public interface IDaoCorsista {
	
	public void addCorsista (DatiCorsisti corsista) throws DaoException;
	
	public void updateCorsista (DatiCorsisti corsista) throws DaoException;
	
	public void deleteCorsista (int codcorsista) throws DaoException;
	
	public LinkedList<DatiCorsisti> selectAll() throws DaoException;
	
	public DatiCorsisti getCorsistaById (int codcorsista) throws DaoException;

} 
