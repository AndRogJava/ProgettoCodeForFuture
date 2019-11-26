package com.ats.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

import com.ats.dao.DaoCorsista;
import com.ats.dao.DaoStatistiche;
import com.ats.exception.DaoException;
import com.ats.model.DatiDocenti;


public class StatisticheService {
	
	public StatisticheService() throws DaoException {
	}
	
	DaoStatistiche daoStat = new DaoStatistiche();
	
	
//	I.    Numero corsisti totali.	
	public int CorsistiTotali() throws DaoException  {
		return daoStat.corsistiTotali();
		
	}
//	II.   Nome del corso più frequentato
	public String CorsoPiuFrequentato() throws DaoException {
		return daoStat.corsoPiuFrequentato();
	
	}
	
//III.  Data di inizio ultimo corso
	public LocalDate DataInizioUltimoCorso() throws DaoException {
		return daoStat.dataInizioUltimoCorso();
		
	}
//	IV.   Durata media dei corsi ( in giorni lavorativi )	
	public double DurataMediaCorsi() throws DaoException {
		return daoStat.durataMediaCorsi();
	}
//	V.    Numero di commenti presenti
	public int NumeroCommenti() throws DaoException  {
		return daoStat.numeroCommenti();
	}

//	VI.   Elenco corsisti
	//da utilizzare quello già implementato in DaoDatiCorsisti
		
//	VII.  Docente che può tenere più tipologie di corso
	public LinkedList<DatiDocenti> DocentePiuCorsi() throws DaoException {
		return daoStat.docentePiuCorsi();
	}

//	VIII. Corsi con posti disponibili
	//da implementare in DaoDatiCorsiImpl
	
// IX. Docenti per nome Corso
	public LinkedList <DatiDocenti> docentiPerNomeCorsi(String nomecorso) throws DaoException{
		return daoStat.docentiPerNomeCorsi(nomecorso);
	}
}
