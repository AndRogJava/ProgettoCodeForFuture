package com.ats.daoTest;


import com.ats.dao.DaoCorsista;
import com.ats.exception.DaoException;
import com.ats.model.DatiCorsisti;


public class daoTest {

	public static void main(String[] args) throws DaoException {
		DatiCorsisti c1 = new DatiCorsisti();
		c1.setCodcorsista(1);
		c1.setNomecorsista("Francesca");
		c1.setCognomecorsista("Meroni");
		c1.setPrecedentiformativi("Inglese");
		
//		DatiCorsisti c2 = new DatiCorsisti ();
//		c2.setCodcorsista(456);
//		c2.setNomecorsista("Piero");
//		c2.setCognomecorsista("Verdi");
//		c2.setPrecedentiformativi("YYY");
		
		
			DaoCorsista dc = new DaoCorsista();
			//dc.addCorsista(c1);
//			dc.deleteCorsista(456);
//			dc.updateCorsista(c1);
			
			System.out.println(dc.selectAll());
	}
	
}
