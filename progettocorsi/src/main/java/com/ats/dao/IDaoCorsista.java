package com.ats.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;

public interface IDaoCorsista {
	
	public void addCorsista (DatiCorsisti corsista) throws ClassNotFoundException, DaoException;
	
	public void updateCorsista (DatiCorsisti corsista) throws SQLException, DaoException;
	
	public void deleteCorsista (int codcorsista) throws SQLException, DaoException;
	
	public LinkedList<DatiCorsisti> selectAll() throws SQLException;
	
	public DatiCorsisti getCorsistaById (int codcorsista) throws SQLException;

}
