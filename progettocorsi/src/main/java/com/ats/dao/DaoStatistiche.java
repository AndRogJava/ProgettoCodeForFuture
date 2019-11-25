package com.ats.dao;
import com.ats.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;
import com.ats.utility.ConnectionFactory;

public class DaoStatistiche {
	private Connection conn=null;
	PreparedStatement prepStatement= null;
	ResultSet resultset= null;
	
	public DaoStatistiche() throws DaoException {
		conn = ConnectionFactory.getInstance();
	
	}
	
	StatisticheDTO statistiche = new StatisticheDTO ();
	
	public int corsistiTotali() throws DaoException{

			String query="select count(codcorsista) as count from DATI_CORSISTI ";
			conn= ConnectionFactory.getInstance();
			int count=0;
			
			try {
				
				prepStatement= conn.prepareStatement(query);
				resultset = prepStatement.executeQuery();
			
				while(resultset.next()){
					count = resultset.getInt("count");
				}
				
			} catch (SQLException e) {
				throw new DaoException(e.getMessage());
				
			}
			return count;
		}
	
	public String corsoPiuFrequentato() {
		String corso = null;
		return corso;
	}
	
	public LocalDate dataInizioUltimoCorso() {
		LocalDate d = null ;
		return d;
	}
	
	
//	IV.   Durata media dei corsi ( in giorni lavorativi )	
	public double durataMediaCorsi() {
		double durata = 0;
		
		

		return durata;
	}
	

//	V.    Numero di commenti presenti
	public int numeroCommenti() throws DaoException{
		int commenti = 0;
		
		String query="select count(commenticorso) as commenti from DATI_CORSI ";
		conn= ConnectionFactory.getInstance();
		
		try {
			
			prepStatement= conn.prepareStatement(query);
			resultset = prepStatement.executeQuery();
		
			while(resultset.next()){
				commenti = resultset.getInt("commenti");
			}
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
			
		}
		return commenti;
		
	}
	
 
	public DatiDocenti docentePiuCorsi() throws DaoException{
		DatiDocenti docente = new DatiDocenti();
		
		String query="select count(*)  corsi, d.nomedocente from DATI_DOCENTI  d, DATI_CORSI  dc"
				+ " where  d.coddocente  = dc.coddocente group by d.nomedocente order by corsi desc";
		conn= ConnectionFactory.getInstance();
		int corsi=0;
		
		try {
			
			prepStatement= conn.prepareStatement(query);
			resultset = prepStatement.executeQuery();
		
			while(resultset.next()){
				corsi = resultset.getInt("corsi");
			}
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
			
		}
		return docente; 
	}
 			
	
}