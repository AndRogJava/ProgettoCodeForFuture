package com.ats.model;

import java.io.Serializable;

public class CorsiCorsisti implements Serializable {
	private int codcorsista;
	private int codcorso;
	private int codcorso_corsista;
	
	public CorsiCorsisti () {
		
	}

	public int getCodcorsista() {
		return codcorsista;
	}

	public void setCodcorsista(int codcorsista) {
		this.codcorsista = codcorsista;
	}

	public int getCodcorso() {
		return codcorso;
	}

	public void setCodcorso(int codcorso) {
		this.codcorso = codcorso;
	}

	public int getCodcorso_corsista() {
		return codcorso_corsista;
	}

	public void setCodcorso_corsista(int codcorso_corsista) {
		this.codcorso_corsista = codcorso_corsista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codcorsista;
		result = prime * result + codcorso;
		result = prime * result + codcorso_corsista;
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
		CorsiCorsisti other = (CorsiCorsisti) obj;
		if (codcorsista != other.codcorsista)
			return false;
		if (codcorso != other.codcorso)
			return false;
		if (codcorso_corsista != other.codcorso_corsista)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CorsiCorsisti [codcorsista=" + codcorsista + ", codcorso=" + codcorso + ", codcorso_corsista="
				+ codcorso_corsista + "]";
	}
	
	

}
