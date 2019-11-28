package com.ats.dao;


	
	import java.sql.*;

import com.ats.exception.DaoException;
import com.ats.utility.ConnectionFactory;


public class OrdineIdGenerator implements IdGeneratorInterface{
	private static OrdineIdGenerator idGen;
	private Connection conn; 
	private Statement stmt;
	private ResultSet rs;

	public OrdineIdGenerator(){
	}

	private Connection getConnection() throws DaoException {
		Connection con;
		con = ConnectionFactory.getInstance();
		return con;
	}
	
	
	public int getNextId() throws DaoException {
		int id = 0; 
		try{
			conn =  getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select DATI_CORSISTI_codcorsista_Seq.nextVal from dual");
			rs.next();
			id = rs.getInt(1);
		 
		} catch (SQLException sql) {
			System.out.println("errore");

		}
		return id;	

	}
	public int getCurrIdCorsista() throws DaoException {
		int id = 0; 
		try{
			conn =  getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select DATI_CORSISTI_codcorsista_Seq.currval from dual");
			rs.next();
			id = rs.getInt(1);
		 
		} catch (SQLException sql) {
			System.out.println("errore");

		}
		return id;	
		

	}
}
