package com.ats.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;
import com.ats.model.DatiCorsi;
import com.ats.utility.ConnectionFactory;

public class DaoDatiCorsiImpl implements IDaoDatiCorsi {

	private Connection conn=null;
	PreparedStatement prepStatement= null;
	ResultSet resultset= null;
	
	public DaoDatiCorsiImpl () throws DaoException {
		conn = ConnectionFactory.getInstance();
	}

	public void addCorso(DatiCorsi corso) throws  DaoException {
		Date data_iniziocorso = Date.valueOf(corso.getData_iniziocorso());
		Date data_finecorso = Date.valueOf(corso.getData_finecorso());
		try{
			String query="insert into DATI_CORSI "
					+ "values(?,?,?,?,?,?,?,?)";
			conn= ConnectionFactory.getInstance();
			prepStatement= conn.prepareStatement(query);
			prepStatement.setInt(1,corso.getCodcorso());
			prepStatement.setInt(2,corso.getCoddocente());
			prepStatement.setString(3,corso.getNomecorso());
			prepStatement.setInt(4,corso.getCostocorso());
			prepStatement.setString(5,corso.getAulacorso());
			prepStatement.setString(6,corso.getCommenticorso());
			prepStatement.setDate(7,data_iniziocorso);
			prepStatement.setDate(8,data_finecorso);
			
			int numeroRighe = prepStatement.executeUpdate();
			if(numeroRighe > 0) {
				System.out.println("Corso aggiunto con successo!");
			}
			prepStatement.close();
			conn.close();
		}catch (SQLException sql) {
			
			throw new DaoException(sql.getMessage());
		}
	
		
	}

	public void updateCorso(DatiCorsi corso) throws  DaoException {
		Date data_iniziocorso = Date.valueOf(corso.getData_iniziocorso());
		Date data_finecorso = Date.valueOf(corso.getData_finecorso());
		try {
			String query="update DATI_CORSI set nomecorso=?, coddocente=?, data_iniziocorso=?, data_finecorso=?, costocorso=?, commenticorso=?,aulacorso=? where codcorso =? ";
		
		conn= ConnectionFactory.getInstance();
		prepStatement= conn.prepareStatement(query);
		
		prepStatement.setString(1,corso.getNomecorso());
		prepStatement.setInt(2, corso.getCoddocente());
		prepStatement.setDate(3, data_iniziocorso);
		prepStatement.setDate(4, data_finecorso);
		prepStatement.setInt(5, corso.getCostocorso() );
		prepStatement.setString(6,corso.getCommenticorso());
		prepStatement.setString(7, corso.getAulacorso());
		prepStatement.setInt(8, corso.getCodcorso());
		prepStatement.executeUpdate();
		System.out.println("Corso modificato con successo!");
		
		 prepStatement.close();
		conn.close();
	}catch (SQLException sql) {
		// TODO: handle exception
		throw new DaoException(sql.getMessage());
	}
		
	}

	public void deleteCorso(int codcorso) throws SQLException, DaoException {
		try {
			String query="delete from DATI_CORSI where codcorso=?";
			conn= ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			prepStatement.setInt(1, codcorso);
			prepStatement.executeUpdate();
			System.out.println("Corso cancellato con successo!");
			prepStatement.close();
			conn.close();
			}catch (SQLException sql) {
				// TODO: handle exception
				throw new DaoException(sql.getMessage());
			}
			
		}
	
		
	

	public LinkedList<DatiCorsi> getallCorsi() throws SQLException, DaoException {
		
		try {
			String query="select * from DATI_CORSI";
			LinkedList <DatiCorsi> listaCorsi = new LinkedList<DatiCorsi>();
			
			conn=ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			resultset=prepStatement.executeQuery();

			while(resultset.next()){

				DatiCorsi corso =new DatiCorsi ();
				
				
				corso.setCodcorso(resultset.getInt("codcorso"));
				corso.setCoddocente(resultset.getInt("coddocente"));
				corso.setAulacorso(resultset.getNString("aulacorso"));
				corso.setCommenticorso(resultset.getNString("commenticorso"));
				corso.setCostocorso(resultset.getInt("costocorso"));
				corso.setNomecorso(resultset.getNString("nomecorso"));
				corso.setData_iniziocorso(resultset.getDate("data_iniziocorso").toLocalDate());
				corso.setData_finecorso(resultset.getDate("data_finecorso").toLocalDate());
				
				listaCorsi.add(corso);
					}
		
			return listaCorsi;
		}catch (SQLException sql) {
			// TODO: handle exception
			throw new DaoException(sql.getMessage());
		}
	}

	public DatiCorsi getCorsobyCodCorso (int codcorso) throws SQLException, DaoException {
		try {

			String query="select * from DATI_CORSI where codcorso=?";
			conn=ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			prepStatement.setInt(1, codcorso);
			resultset=prepStatement.executeQuery();
			
			DatiCorsi corso = null;

			
			while(resultset.next()) {
				corso= new DatiCorsi ();
				
				corso.setCoddocente(resultset.getInt("coddocente"));
				corso.setAulacorso(resultset.getNString("aulacorso"));
				corso.setCommenticorso(resultset.getNString("commenticorso"));
				corso.setCostocorso(resultset.getInt("costocorso"));
				corso.setNomecorso(resultset.getNString("nomecorso"));
				corso.setData_iniziocorso(resultset.getDate("data_iniziocorso").toLocalDate());
				corso.setData_finecorso(resultset.getDate("data_finecorso").toLocalDate());
				corso.setCodcorso(resultset.getInt("codcorso"));
				
				
		}
			return corso;
		    }
		catch (SQLException sql)  {
			throw new DaoException(sql.getMessage());
		}
		
	}
}

