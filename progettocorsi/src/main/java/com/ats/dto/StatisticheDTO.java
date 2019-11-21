package com.ats.dto;

import com.ats.model.DatiCorsi;
import com.ats.model.DatiCorsisti;
import com.ats.model.DatiDocenti;

public class StatisticheDTO {
	private DatiCorsi corso;
	private DatiCorsisti corsisti;
	private DatiDocenti docenti;
	
	public StatisticheDTO(){
		
	}

	public DatiCorsi getCorso() {
		return corso;
	}

	public void setCorso(DatiCorsi corso) {
		this.corso = corso;
	}

	public DatiCorsisti getCorsisti() {
		return corsisti;
	}

	public void setCorsisti(DatiCorsisti corsisti) {
		this.corsisti = corsisti;
	}

	public DatiDocenti getDocenti() {
		return docenti;
	}

	public void setDocenti(DatiDocenti docenti) {
		this.docenti = docenti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corsisti == null) ? 0 : corsisti.hashCode());
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((docenti == null) ? 0 : docenti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatisticheDTO other = (StatisticheDTO) obj;
		if (corsisti == null) {
			if (other.corsisti != null)
				return false;
		} else if (!corsisti.equals(other.corsisti))
			return false;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		if (docenti == null) {
			if (other.docenti != null)
				return false;
		} else if (!docenti.equals(other.docenti))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StatisticheDTO [corso=" + corso + ", corsisti=" + corsisti + ", docenti=" + docenti + "]";
	}

	
	

}
