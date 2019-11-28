package com.ats.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ats.exception.DaoException;
import com.ats.utility.ConnectionFactory;

public class OrdineIdGeneratorCorsiCorsisti implements IdGeneratorInterface{
	private static OrdineIdGenerator idGen;
	private Connection conn; 
	private Statement stmt;
	private ResultSet rs;

	public OrdineIdGeneratorCorsiCorsisti() throws DaoException{
		conn = ConnectionFactory.getInstance();
	}

	
	
	public int getNextId() throws DaoException {
		int id = 0; 
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select CorsoCorsista_Seq.nextVal from dual");
			rs.next();
			id = rs.getInt(1);
		 
		} catch (SQLException sql) {
			System.out.println("errore");

		}
		return id;	

	}
	
	
	public int getCurrId() throws DaoException {
		int id = 0; 
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select CorsoCorsista_Seq.currval from dual");
			rs.next();
			id = rs.getInt(1);
		 
		} catch (SQLException sql) {
			System.out.println("errore");

		}
		return id;	

	}
}
