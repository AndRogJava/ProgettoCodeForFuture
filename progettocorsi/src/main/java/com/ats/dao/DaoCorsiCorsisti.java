package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.ats.exception.DaoException;
import com.ats.model.CorsiCorsisti;
import com.ats.utility.ConnectionFactory;

public class DaoCorsiCorsisti implements IDaoCorsiCosisti{
	

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	

	public DaoCorsiCorsisti() throws DaoException {
		conn = ConnectionFactory.getInstance();
	}

	public void addRelazioneCorsoCorsista(CorsiCorsisti relazione) throws DaoException {
		String query = "insert into CORSI_CORSISTI values(?,?,?)";
		
		
		try {
			ps = conn.prepareStatement(query);

			OrdineIdGeneratorCorsiCorsisti oig=new OrdineIdGeneratorCorsiCorsisti();
			int newId = oig.getNextId();
			ps.setInt(3,newId);
			ps.setInt(1, relazione.getCodcorsista());
			ps.setInt(2, relazione.getCodcorso());
			

			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}	
		
	}

	public LinkedList<CorsiCorsisti> selectAllByCodCorsista(int codCorsista) throws DaoException {
		try {
			String query = "select * from CORSI_CORSISTI where CODCORSISTA=?";

			LinkedList <CorsiCorsisti> elencoCorsiPerCorsista = new LinkedList<CorsiCorsisti>();
			ps = conn.prepareStatement(query);
			ps.setInt(1,codCorsista);
			rs = ps.executeQuery();

			while (rs.next()) {
				CorsiCorsisti tmp = new CorsiCorsisti();
				tmp.setCodcorsista(rs.getInt("CODCORSISTA"));
				tmp.setCodcorso(rs.getInt("CODCORSO"));
				tmp.setCodcorso_corsista(rs.getInt("codcorso_corsista"));

				elencoCorsiPerCorsista.add(tmp);
			}
			ps.executeUpdate();
			ps.close();
			conn.close();
			return elencoCorsiPerCorsista;
			
			

		}
		catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	}

}
