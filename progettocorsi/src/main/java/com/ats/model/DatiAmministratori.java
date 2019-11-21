package com.ats.model;

import java.io.Serializable;

public class DatiAmministratori implements Serializable{
	
	private String nomeadmin;
	private String cognomeadmin;
	private int codadmin;
	
	public DatiAmministratori() {
		
	}
	public void setNomeadmin(String nomeadmin) {
		this.nomeadmin=nomeadmin;
	}
	public String getNomeadmin() {
		return nomeadmin;
	}
	public void setCognomeadmin(String cognomeadmin) {
		this.cognomeadmin=cognomeadmin;
	}
	public String getCognomeadmin() {
		return cognomeadmin;
	}
	public void setCodadmin(int codadmin) {
		this.codadmin=codadmin;
	}
	public int  getCodadmin() {
		return codadmin;
	}
	@Override
	public String toString() {
		return "DatiAmministratori [nomeadmin=" + nomeadmin + ", cognomeadmin=" + cognomeadmin + ", codadmin="
				+ codadmin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codadmin;
		result = prime * result + ((cognomeadmin == null) ? 0 : cognomeadmin.hashCode());
		result = prime * result + ((nomeadmin == null) ? 0 : nomeadmin.hashCode());
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
		DatiAmministratori other = (DatiAmministratori) obj;
		if (codadmin != other.codadmin)
			return false;
		if (cognomeadmin == null) {
			if (other.cognomeadmin != null)
				return false;
		} else if (!cognomeadmin.equals(other.cognomeadmin))
			return false;
		if (nomeadmin == null) {
			if (other.nomeadmin != null)
				return false;
		} else if (!nomeadmin.equals(other.nomeadmin))
			return false;
		return true;
	}

}
