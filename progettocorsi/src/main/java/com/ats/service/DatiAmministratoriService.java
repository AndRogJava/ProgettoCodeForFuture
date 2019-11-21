package com.ats.service;

import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.dao.DaoDatiAmministratoriImpl;
import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;

public class DatiAmministratoriService {
	
	public DatiAmministratoriService() throws DaoException{};
	DaoDatiAmministratoriImpl daoAmministratori=new DaoDatiAmministratoriImpl();
	
	public void addAmministratore (DatiAmministratori  amministratore) throws  DaoException{
		daoAmministratori.addAmministratore(amministratore);
	}
    public void updateAmministratore(DatiAmministratori  amministratore)throws  DaoException{
    	daoAmministratori.updateAmministratore(amministratore);
    }
	public void deleteAmministratore (int codadmin)throws  DaoException{
		daoAmministratori.deleteAmministratore(codadmin);
	}
	public LinkedList<DatiAmministratori> getallAmministratori () throws  DaoException{
		return daoAmministratori.getallAmministratori();
	}
	public DatiAmministratori getAmministratorebyUsername (int codadmin) throws  DaoException{
		return daoAmministratori.getAmministratorebyUsername(codadmin);
	}

}
