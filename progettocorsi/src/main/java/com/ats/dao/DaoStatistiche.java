package com.ats.dao;
import com.ats.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
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
}
