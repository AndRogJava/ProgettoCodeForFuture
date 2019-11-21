package com.ats.model;

import java.io.Serializable;

public class DatiCorsisti implements Serializable{
	private String nomecorsista;
	private String cognomecorsista;
	private int codcorsista;
	private String precedentiformativi;
	
	public DatiCorsisti() {
		
	}

	public String getNomecorsista() {
		return nomecorsista;
	}

	public void setNomecorsista(String nomecorsista) {
		this.nomecorsista = nomecorsista;
	}

	public String getCognomecorsista() {
		return cognomecorsista;
	}

	public void setCognomecorsista(String cognomecorsista) {
		this.cognomecorsista = cognomecorsista;
	}

	public int getCodcorsista() {
		return codcorsista;
	}

	public void setCodcorsista(int codcorsista) {
		this.codcorsista = codcorsista;
	}

	public String getPrecedentiformativi() {
		return precedentiformativi;
	}

	public void setPrecedentiformativi(String precedentiformativi) {
		this.precedentiformativi = precedentiformativi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codcorsista;
		result = prime * result + ((cognomecorsista == null) ? 0 : cognomecorsista.hashCode());
		result = prime * result + ((nomecorsista == null) ? 0 : nomecorsista.hashCode());
		result = prime * result + ((precedentiformativi == null) ? 0 : precedentiformativi.hashCode());
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
		DatiCorsisti other = (DatiCorsisti) obj;
		if (codcorsista != other.codcorsista)
			return false;
		if (cognomecorsista == null) {
			if (other.cognomecorsista != null)
				return false;
		} else if (!cognomecorsista.equals(other.cognomecorsista))
			return false;
		if (nomecorsista == null) {
			if (other.nomecorsista != null)
				return false;
		} else if (!nomecorsista.equals(other.nomecorsista))
			return false;
		if (precedentiformativi == null) {
			if (other.precedentiformativi != null)
				return false;
		} else if (!precedentiformativi.equals(other.precedentiformativi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiCorsisti [nomecorsista=" + nomecorsista + ", cognomecorsista=" + cognomecorsista + ", codcorsista="
				+ codcorsista + ", precedentiformativi=" + precedentiformativi + "]";
	}
	
	
	

}
