package com.ats.daoTest;


import com.ats.dao.DaoCorsista;
import com.ats.dao.DaoDatiAmministratoriImpl;
import com.ats.dao.DaoDocente;
import com.ats.exception.DaoException;
import com.ats.model.DatiAmministratori;
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
			
			d1.setNomedocente("Piero");
			d1.setCognomedocente("Nebuloni");
			d1.setCvdocente("YYY");
			d1.setCoddocente(111);
		
			DaoDocente dd = new DaoDocente();
			dd.addDocente(d1);
			System.out.println(dd.selectAll());
			
			
			
	}
	
}
