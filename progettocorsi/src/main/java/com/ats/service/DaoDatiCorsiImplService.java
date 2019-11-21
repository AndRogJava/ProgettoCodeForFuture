package com.ats.service;

import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.dao.DaoDatiCorsiImpl;
import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;

public class DaoDatiCorsiImplService {
	
	public DaoDatiCorsiImplService() throws DaoException{};
	
	DaoDatiCorsiImpl daoDCI= new DaoDatiCorsiImpl();
	
	public void addCorso(DatiCorsi corso) throws DaoException{
		daoDCI.addCorso(corso);
		
	}
    public void updateCorso(DatiCorsi corso)throws SQLException, DaoException{
    	daoDCI.updateCorso(corso);
    }
	public void deleteCorso (int codcorso)throws SQLException, DaoException{
		daoDCI.deleteCorso(codcorso);
	}
	public LinkedList<DatiCorsi> getallCorsi() throws SQLException, DaoException{
		return daoDCI.getallCorsi();
	}
	public DatiCorsi getCorsobyCodCorso (int codcorso) throws SQLException, DaoException{
		return daoDCI.getCorsobyCodCorso(codcorso);
	}

}
