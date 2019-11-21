package com.ats.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;

public interface IDaoDatiCorsi {
	public void addCorso(DatiCorsi corso) throws DaoException;
    public void updateCorso(DatiCorsi corso)throws SQLException, DaoException;
	public void deleteCorso (int codcorso)throws SQLException, DaoException;
	public LinkedList<DatiCorsi> getallCorsi() throws SQLException, DaoException;
	public DatiCorsi getCorsobyCodCorso (int codcorso) throws SQLException, DaoException;

}
