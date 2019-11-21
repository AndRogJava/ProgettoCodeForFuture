package com.ats.dao;

import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;

public interface IDaoDatiAmministratori {
	public void addAmministratore (DatiAmministratori  amministratore) throws ClassNotFoundException, DaoException;
    public void updateAmministratore(DatiAmministratori  amministratore)throws SQLException, DaoException;
	public void deleteAmministratore (int codadmin)throws SQLException, DaoException;
	public LinkedList<DatiAmministratori> getallAmministratori () throws SQLException, DaoException;
	public DatiAmministratori getAmministratorebyUsername (int codadmin) throws SQLException, DaoException;


	

}
