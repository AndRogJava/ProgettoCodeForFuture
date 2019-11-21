package com.ats.service;

import java.util.LinkedList;

import com.ats.dao.DaoCorsista;
import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;

public class CorsistaService {
		
	public CorsistaService() throws DaoException{};
	
	DaoCorsista daocorsista=new DaoCorsista();
	
	public void addCorsista (DatiCorsisti corsista) throws DaoException{
		daocorsista.addCorsista(corsista);
	}
	
	public void updateCorsista (DatiCorsisti corsista) throws  DaoException{
		daocorsista.updateCorsista(corsista);
	}
	
	public void deleteCorsista (int codcorsista) throws  DaoException{
		daocorsista.deleteCorsista(codcorsista);
	}
	
	public LinkedList<DatiCorsisti> selectAll() throws DaoException{
		return daocorsista.selectAll();
	}
	
	public DatiCorsisti getCorsistaById (int codcorsista) throws DaoException{
		return daocorsista.getCorsistaById(codcorsista);
	}

}
