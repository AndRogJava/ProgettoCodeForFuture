package com.ats.daoTest;


import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.ats.dao.DaoCorsista;
import com.ats.dao.DaoDatiAmministratoriImpl;
import com.ats.dao.DaoDatiCorsiImpl;
import com.ats.dao.DaoDocente;

import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;
import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;


public class daoTest {

	public static void main(String[] args) throws DaoException {

		
		DatiCorsisti c2 = new DatiCorsisti();
		
		c2.setNomecorsista("Anna");
		c2.setCognomecorsista("Anni");
		c2.setCodcorsista(7);
		c2.setPrecedentiformativi("Matematica");
		
		
		
		
			DaoCorsista dc = new DaoCorsista();
			//System.out.println(dc.selectAll());
			//System.out.println(dc.getCorsistaById(7));
			//dc.addCorsista(c2);
			//dc.updateCorsista(c2);
			//dc.deleteCorsista(7);
		
	
			DatiAmministratori da = new DatiAmministratori();
			da.setCodadmin(124);
			da.setNomeadmin("Marcello");
			da.setCognomeadmin("Marcellinononono");
			
			DaoDatiAmministratoriImpl dda = new DaoDatiAmministratoriImpl();
			//System.out.println(dda.getallAmministratori());
			//dda.addAmministratore(da);
			//dda.deleteAmministratore(124);
			//dda.updateAmministratore(da);
			//System.out.println(dda.getAmministratorebyUsername(11));
	
			
			
			DatiDocenti d1 = new DatiDocenti();
			
			d1.setNomedocente("Marco");
			d1.setCognomedocente("Nebuloni");
			d1.setCvdocente("YYY");
			d1.setCoddocente(111);
		
			DaoDocente dd = new DaoDocente();
			//dd.addDocente(d1);
			//System.out.println(dd.selectAll());
			//dd.updateDocente(d1);
			//dd.deleteDocente(111);
			//System.out.println(dd.getDocenteById(100));
			
			
			DatiCorsi datc = new DatiCorsi ();
			datc.setCodcorso(33);
			datc.setCoddocente(87);
			datc.setAulacorso("4774747");
			datc.setCommenticorso("jgf");
			datc.setCostocorso(70);
			
			LocalDate data=LocalDate.of(2013, 01, 01);
			datc.setData_iniziocorso(data);
			
			LocalDate data1=LocalDate.of(2014, 01, 01);
			datc.setData_finecorso(data1);
			
			datc.setNomecorso("giava");
			
			
			
			DaoDatiCorsiImpl ddci = new DaoDatiCorsiImpl();
			ddci.addCorso(datc); //da verificare dopo SERVLET
			
			
			
			
//			try {
//				System.out.println(ddci.getallCorsi());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//			try {
//				ddci.deleteCorso(222);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			ddci.updateCorso(datc); //da verificare dopo SERVLET
//			
//			try {
//				System.out.println(ddci.getCorsobyCodCorso(223));
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
	}
	
}
