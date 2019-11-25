package com.ats.service;

import java.util.LinkedList;

import com.ats.dao.DaoCorsiCorsisti;
import com.ats.exception.DaoException;
import com.ats.model.CorsiCorsisti;

public class CorsiCorsistiService {
	
	public CorsiCorsistiService() throws DaoException{};
	
	DaoCorsiCorsisti daoCorsiCorsisti=new DaoCorsiCorsisti();
	
	public void addRelazioneCorsoCorsista (CorsiCorsisti relazione) throws DaoException{
		daoCorsiCorsisti.addRelazioneCorsoCorsista(relazione);
	}
	
	public LinkedList<CorsiCorsisti> selectAllByCodCorsista(int codCorsista) throws DaoException{
		return daoCorsiCorsisti.selectAllByCodCorsista(codCorsista);
	}

}
