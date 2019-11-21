package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.utility.*;

import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;

public class DaoDatiAmministratoriImpl implements IDaoDatiAmministratori {
	
	private Connection conn=null;
	PreparedStatement prepStatement= null;
	ResultSet resultset= null;
	
	public DaoDatiAmministratoriImpl () throws DaoException {
		conn = ConnectionFactory.getInstance();
	}
	

	public void addAmministratore(DatiAmministratori amministratore) throws ClassNotFoundException, DaoException {
		try{
			String query="insert into DATI_AMMINISTRATORI "
					+ "values(?,?,?)";
			conn= ConnectionFactory.getInstance();
			prepStatement= conn.prepareStatement(query);
			prepStatement.setString(1,amministratore.getNomeadmin());
			prepStatement.setString(2, amministratore.getCognomeadmin());
			prepStatement.setInt(3, amministratore.getCodadmin());
			
			int numeroRighe = prepStatement.executeUpdate();
			if(numeroRighe > 0) {
				System.out.println("Amministratore aggiunto con successo!");
			}
			prepStatement.close();
			conn.close();
		}catch (SQLException sql) {
			
			throw new DaoException(sql.getMessage());
		}

		
	}
	

	public void updateAmministratore(DatiAmministratori amministratore) throws SQLException, DaoException {
		try {
			String query="update DATI_AMMINISTRATORI set nomeadmin=?, cognomeadmin=? where codadmin=? ";
		
		conn= ConnectionFactory.getInstance();
		prepStatement= conn.prepareStatement(query);
		
		prepStatement.setString(1,amministratore.getNomeadmin());
		prepStatement.setString(2,  amministratore.getCognomeadmin());
		prepStatement.setInt(3, amministratore.getCodadmin());
		prepStatement.executeUpdate();
		System.out.println("Amministratore modificato con successo!");
		
		 prepStatement.close();
		conn.close();
	}catch (SQLException sql) {
		// TODO: handle exception
		throw new DaoException(sql.getMessage());
	}

	}
	
		

	public void deleteAmministratore(int codadmin) throws SQLException, DaoException {
		try {
			String query="delete from DATI_AMMINISTRATORI where codadmin=?";
			conn= ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			prepStatement.setInt(1, codadmin);
			prepStatement.executeUpdate();
			System.out.println("Amministratore cancellato con successo!");
			prepStatement.close();
			conn.close();
			}catch (SQLException sql) {
				// TODO: handle exception
				throw new DaoException(sql.getMessage());
			}
			
		}
	
		
	

	public LinkedList<DatiAmministratori> getallAmministratori() throws SQLException, DaoException {
		try {
			String query="select * from DATI_AMMINISTRATORI";
			LinkedList <DatiAmministratori> listaAmministratori = new LinkedList<DatiAmministratori>();
			
			conn=ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			resultset=prepStatement.executeQuery();

			while(resultset.next()){

				DatiAmministratori amministratore =new DatiAmministratori ();
				
				
				amministratore.setNomeadmin(resultset.getString("nomeadmin"));
				amministratore.setCognomeadmin(resultset.getString("cognomeadmin"));
				amministratore.setCodadmin(resultset.getInt("codadmin"));
				
				listaAmministratori.add(amministratore);
				
				
			}
		
			return listaAmministratori;
		}catch (SQLException sql) {
			
			throw new DaoException(sql.getMessage());
		}
	}
	

	public DatiAmministratori getAmministratorebyUsername(int codadmin) throws SQLException, DaoException {
		
		try {

			String query="select * from DATI_AMMINISTRATORI where codadmin=?";
			conn=ConnectionFactory.getInstance();
			prepStatement=conn.prepareStatement(query);
			prepStatement.setInt(1, codadmin);
			resultset=prepStatement.executeQuery();
			
			DatiAmministratori amministratore = null;
			
			while(resultset.next()) {
				amministratore = new DatiAmministratori ();
				amministratore.setNomeadmin(resultset.getString("nomeadmin"));
				amministratore.setCognomeadmin(resultset.getString("cognomeadmin"));
				amministratore.setCodadmin(resultset.getInt("codadmin"));
		}
			return amministratore;
		    }
		catch (SQLException sql)  {
			throw new DaoException(sql.getMessage());
		}

}
}
