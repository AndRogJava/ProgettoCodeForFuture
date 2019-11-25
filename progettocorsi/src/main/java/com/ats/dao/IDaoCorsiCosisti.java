package com.ats.dao;

import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.CorsiCorsisti;

public interface IDaoCorsiCosisti {
	public void addRelazioneCorsoCorsista (CorsiCorsisti relazione) throws DaoException;
	
	public LinkedList<CorsiCorsisti> selectAllByCodCorsista(int codCorsista) throws DaoException;
}
