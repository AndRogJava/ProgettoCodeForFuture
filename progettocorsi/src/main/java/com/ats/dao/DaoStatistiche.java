package com.ats.dao;
import com.ats.dto.*;
import java.sql.Connection;
import java.sql.Date;
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
//	I.    Numero corsisti totali.		
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
//	II.   Nome del corso più frequentato
	public String corsoPiuFrequentato() {
		String corso = null;
		return corso;
	}
//	III.  Data di inizio ultimo corso	
	public Date dataInizioUltimoCorso() {
		Date d = null ;
		return d;
	}

//	IV.   Durata media dei corsi ( in giorni lavorativi )	
	public double durataMediaCorsi() {
		double durata = 0;
		return durata;
	}
//	V.    Numero di commenti presenti
	public int numeroCommenti() {
		int commenti = 0;
		return commenti;
		
	}
//	VI.   Elenco corsisti
	//da utilizzare quello già implementato in DaoDatiCorsisti
		
//	VII.  Docente che può tenere più tipologie di corso
	public DatiDocenti docentePiuCorsi() {
		DatiDocenti docente = new DatiDocenti();
		return docente;
	}
			
//	VIII. Corsi con posti disponibili
	//da implementare in DaoDatiCorsiImpl

	
}