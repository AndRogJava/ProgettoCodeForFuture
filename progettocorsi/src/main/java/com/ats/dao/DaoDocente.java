package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.ats.utility.ConnectionFactory;

import com.ats.exception.DaoException;
import com.ats.model.DatiDocenti;

public class DaoDocente implements IDaoDocente{
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public DaoDocente() throws DaoException {
		conn = ConnectionFactory.getInstance();
	}

	public void addDocente(DatiDocenti docente) throws DaoException {
		
		try {
			String query = "insert into DATI_DOCENTI" + "values(?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, docente.getNomedocente());
			ps.setString(2, docente.getCognomedocente());
			ps.setString(3, docente.getCvdocente());
			ps.setInt(4, docente.getCoddocente());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			throw new DaoException();
		}	
	}

	public void updateDocente(DatiDocenti docente) throws DaoException {
		
		try {
			String query = "update DATI_DOCENTI set nomedocente=?, cognomedocente=?, cv_docente=? where coddocente=?";
			ps = conn.prepareStatement(query);
		
			ps.setString(1, docente.getNomedocente());
			ps.setString(2, docente.getCognomedocente());
			ps.setString(3, docente.getCvdocente());
			ps.setInt(4, docente.getCoddocente());
		
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			throw new DaoException();
		}
	}

	public void deleteDocente(int coddocente) throws DaoException {
		
		try {
			String query = "delete from DATI_DOCENTI where coddocente=?";
			ps = conn.prepareStatement(query);
		
			ps.setInt(1, coddocente);
		
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}


	public LinkedList<DatiDocenti> selectAll() throws DaoException {
		
		try {
			String query = "select * from DATI_DOCENTI";
		
			LinkedList <DatiDocenti> datidocenti = new LinkedList<DatiDocenti>();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
		
			while (rs.next()) {
				DatiDocenti tmp = new DatiDocenti();
				tmp.setNomedocente(rs.getString("nomedocente"));
				tmp.setCognomedocente(rs.getString("cognomedocente"));
				tmp.setCvdocente(rs.getString("cv_docente"));
				tmp.setCoddocente(rs.getInt("coddocente"));
			
				datidocenti.add(tmp);
			}
			return datidocenti;
		
			}
			catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}
	}

	public DatiDocenti getDocenteById(int coddocente) throws DaoException {
		
		try {
			String query = "select * from DATI_DOCENTI where coddocente=?";
		
			ps = conn.prepareStatement(query);
			ps.setInt(1,  coddocente);
			rs = ps.executeQuery();
			DatiDocenti tmp = null;
		
			while (rs.next()) {
				tmp = new DatiDocenti();
				tmp.setNomedocente(rs.getString("nomedocente"));
				tmp.setCognomedocente(rs.getString("cognomedocente"));
				tmp.setCvdocente(rs.getString("cv_docente"));
				tmp.setCoddocente(rs.getInt("coddocente"));
			}
			return tmp;
			}
			catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}
		
	}
		
}		
		
		

