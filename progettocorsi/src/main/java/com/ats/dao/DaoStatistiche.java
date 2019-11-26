package com.ats.dao;
import com.ats.dto.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;
import com.ats.utility.ConnectionFactory;

public class DaoStatistiche {
	private static final String String = null;
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

	public String corsoPiuFrequentato() throws DaoException {
		String corso = null;
		String query="select count(*)  count, dt.nomecorso from CORSI_CORSISTI  cc, DATI_CORSI dt where  cc.codcorso  = dt.codcorso group by  dt.nomecorso, cc.codcorso order by count asc";
		conn= ConnectionFactory.getInstance();
		

		try {

			prepStatement= conn.prepareStatement(query);
			resultset = prepStatement.executeQuery();

			while(resultset.next()){
				corso = resultset.getString("nomecorso");
			
			
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());

		}
		return corso;



	}	


	public LocalDate dataInizioUltimoCorso() throws DaoException {
		StatisticheDTO statistiche = new StatisticheDTO (); 
		LocalDate data = null;
		String query= "select data_iniziocorso from Dati_CORSI where data_iniziocorso = (select max(data_iniziocorso) from DATI_CORSI )";
		conn= ConnectionFactory.getInstance();
		try {

			prepStatement= conn.prepareStatement(query);

			resultset = prepStatement.executeQuery();

			while(resultset.next()){
				statistiche = new StatisticheDTO ();

				 data = resultset.getDate("data_iniziocorso").toLocalDate();

			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());

		}

		
		return data ;
	}
	


	//	IV.   Durata media dei corsi ( in mesi )	
	public double durataMediaCorsi() throws DaoException {

		String query= "select data_iniziocorso, data_finecorso from DATI_CORSI";
		conn= ConnectionFactory.getInstance();

		double media = 0;

		try {
 

			prepStatement= conn.prepareStatement(query);

			resultset = prepStatement.executeQuery();
			ArrayList <Period> periodi = new ArrayList <Period> ();
			double mesitotali = 0;

			while(resultset.next()){
				LocalDate datainizio = resultset.getDate("data_iniziocorso").toLocalDate();
			
				LocalDate datafine= resultset.getDate("data_finecorso").toLocalDate();
				

			

				Period intervalPeriod =  Period.between(datainizio,datafine);
				periodi.add(intervalPeriod);
				System.out.println(intervalPeriod);
				double mesi = intervalPeriod.getMonths();
				System.out.println(mesi);
				System.out.println(mesitotali+= mesi);
			}

				media += mesitotali/this.numeroCorsi();
			


		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(e.getMessage());
		}


		return media;
	}


	
	private int numeroCorsi() throws DaoException {

		String query= "select count(codcorso) numerocorsi from DATI_CORSI";
		conn= ConnectionFactory.getInstance();
		int count=0;
		try {

			prepStatement= conn.prepareStatement(query);
			resultset = prepStatement.executeQuery();

			while(resultset.next()){
				count = resultset.getInt("numerocorsi");
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage());

		}
		return count;



	}	



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
	
 
	public LinkedList<DatiDocenti> docentePiuCorsi () throws DaoException{
		
		StatisticheDTO statistiche = new StatisticheDTO ();
		
		String query="select count(*)  corsi, d.nomedocente from DATI_DOCENTI  d, DATI_CORSI  dc"
				+ " where  d.coddocente  = dc.coddocente group by d.nomedocente order by corsi desc";
		conn= ConnectionFactory.getInstance();
		int corsi=0;
		String nomeDocente = null;
		DatiDocenti docente = null;
		LinkedList<DatiDocenti> docenticorsi = new LinkedList <DatiDocenti> ();
		
		try {
			
			prepStatement= conn.prepareStatement(query);
			resultset = prepStatement.executeQuery();
			
			while(resultset.next()){
			
				 docente = new DatiDocenti();
			docente.setNomedocente(resultset.getString("nomedocente"));
			docenticorsi.add(docente);
			
			}
			
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
			
		}
		return docenticorsi;
	}
	
	public LinkedList <DatiDocenti> docentiPerNomeCorsi(String nomecorso) throws DaoException{
		
		LinkedList <DatiDocenti> listaDocentiPerNomeCorso= new LinkedList <DatiDocenti> ();
		
		try {
		conn= ConnectionFactory.getInstance();
		
		
		String query= "select* from dati_docenti dd join dati_corsi dc on dd.coddocente = dc.coddocente where dc.nomecorso=?";
			
			prepStatement= conn.prepareStatement(query);
			prepStatement.setString(1, nomecorso);
			resultset = prepStatement.executeQuery();
			while(resultset.next()){
				DatiDocenti docentetmp = new DatiDocenti();
				docentetmp.setCoddocente(resultset.getInt("CODDOCENTE"));
				docentetmp.setCognomedocente(resultset.getString("COGNOMEDOCENTE"));
				docentetmp.setNomedocente(resultset.getString("NOMEDOCENTE"));
				docentetmp.setCvdocente(resultset.getString("CV_DOCENTE"));
				listaDocentiPerNomeCorso.add(docentetmp);
			}
		} catch (SQLException e) {
			e.getMessage();
			
		}
		
		return listaDocentiPerNomeCorso;
	}




 	
	public HashMap <String, Integer> corsiConPostiDisponibili () throws DaoException {
		
		HashMap <String, Integer>  listaCorsiDisponibili = new HashMap <String, Integer>();
		String query= "select count (CORSI_CORSISTI.codcorsista) partecipanti, DATI_CORSI.nomecorso from DATI_CORSI, CORSI_CORSISTI, DATI_CORSISTI WHERE DATI_CORSI.codcorso = CORSI_CORSISTI.codcorso and DATI_CORSISTI.codcorsista = CORSI_CORSISTI.codcorsista group by DATI_CORSI.nomecorso";
		conn= ConnectionFactory.getInstance();
		Integer partecipanti = 0;
		String nomecorso = null;
		final  int NUMERO_PARTECIPANTI= 12;
//	//	LinkedList<String> listaCorsi = new LinkedList <String> ();
		try {
			
		prepStatement= conn.prepareStatement(query);
		resultset = prepStatement.executeQuery();

		while(resultset.next()){
		
    		 partecipanti = resultset.getInt("partecipanti");
    		 nomecorso = resultset.getString("nomecorso");
    		
    		
    		 listaCorsiDisponibili.put(nomecorso, partecipanti);
		
    		 
 		 if (partecipanti>NUMERO_PARTECIPANTI) {
  			 System.out.println(nomecorso +":" + "Siamo spiacenti, il corso non ha più posti disponibili");
   		 }else {
   			 System.out.println(nomecorso + ":"+ "Il corso ha ancora posti disponibili!");
   		 }
  	 
		}
	} catch (SQLException e) {
		throw new DaoException(e.getMessage());

	}
		

		return listaCorsiDisponibili;
		
	
}
	

	}
