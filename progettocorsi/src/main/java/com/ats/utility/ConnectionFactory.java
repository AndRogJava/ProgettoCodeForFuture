package com.ats.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import com.ats.exception.DaoException;

public class ConnectionFactory {
	private static Connection conn;
	private static ResourceBundle rb = ResourceBundle.getBundle("risorse/info");
	private static String stringConnection = rb.getString("jdbc.stringConnection");
	private static String idConnection=rb.getString("jdbc.username");
	private static String passConnection=rb.getString("jdbc.password");
	
	
	
	private ConnectionFactory() throws DaoException{
		
		try {
			conn = DriverManager.getConnection(stringConnection,idConnection,passConnection);
		} catch (Exception e) {
			throw new DaoException();
		}
	}
	
	public static Connection getInstance()throws DaoException{
		if(conn==null)
			new ConnectionFactory();
		
		return conn; 
	}
}
