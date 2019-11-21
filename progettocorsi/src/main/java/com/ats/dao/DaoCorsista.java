package com.ats.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.ats.utility.ConnectionFactory;

import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;

public class DaoCorsista implements IDaoCorsista{
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		public DaoCorsista() throws DaoException {
			conn = ConnectionFactory.getInstance();
		}

		public void addCorsista(DatiCorsisti corsista) throws DaoException {
			
			try {
				String query = "insert into DATI_CORSISTI" + "values(?,?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, corsista.getNomecorsista());
				ps.setString(2, corsista.getCognomecorsista());
				ps.setInt(3, corsista.getCodcorsista());
				ps.setString(4, corsista.getPrecedentiformativi());
				
				ps.executeUpdate();
				ps.close();
				conn.close();
			}
			catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}	
		}

		public void updateCorsista(DatiCorsisti corsista) throws DaoException {
			
			try {
				String query = "update DATI_CORSISTI set nomecorsista=?, cognomecorsista=?, precedentiformativi=? where codcorsista=?";
				ps = conn.prepareStatement(query);
			
				ps.setString(1, corsista.getNomecorsista());
				ps.setString(2, corsista.getCognomecorsista());
				ps.setString(3, corsista.getPrecedentiformativi());
				ps.setInt(4, corsista.getCodcorsista());
			
				ps.executeUpdate();
				ps.close();
				conn.close();
			}
			catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}
		}

		public void deleteCorsista(int codcorsista) throws DaoException {
			
			try {
				String query = "delete from DATI_CORSISTI where codcorsista=?";
				ps = conn.prepareStatement(query);
			
				ps.setInt(1, codcorsista);
			
				ps.executeUpdate();
				ps.close();
				conn.close();
			}
			catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}
		}

		public LinkedList<DatiCorsisti> selectAll() throws DaoException {
			
			try {
				String query = "select * from DATI_CORSISTI";
			
				LinkedList <DatiCorsisti> daticorsisti = new LinkedList<DatiCorsisti>();
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
			
				while (rs.next()) {
					DatiCorsisti tmp = new DatiCorsisti();
					tmp.setNomecorsista(rs.getString("nomecorsista"));
					tmp.setCognomecorsista(rs.getString("cognomecorsista"));
					tmp.setCodcorsista(rs.getInt("codcorsista"));
					tmp.setPrecedentiformativi(rs.getString("precedentiformativi"));
				
					daticorsisti.add(tmp);
				}
				return daticorsisti;
			
				}
				catch (SQLException e) {
					throw new DaoException(e.getMessage());
				}
			
		}
			

		public DatiCorsisti getCorsistaById(int codcorsista) throws DaoException {
			
			try {
				String query = "select * from DATI_CORSISTI where codcorsista=?";
			
				ps = conn.prepareStatement(query);
				ps.setInt(1,  codcorsista);
				rs = ps.executeQuery();
				DatiCorsisti tmp = null;
			
				while (rs.next()) {
					tmp = new DatiCorsisti();
					tmp.setNomecorsista(rs.getString("nomecorsista"));
					tmp.setCognomecorsista(rs.getString("cognomecorsista"));
					tmp.setCodcorsista(rs.getInt("codcorsista"));
					tmp.setPrecedentiformativi(rs.getString("precedentiformativi"));
				
				}
				return tmp;
				}
				catch (SQLException e) {
					throw new DaoException(e.getMessage());
				}
		}
}
		
		
		
		

