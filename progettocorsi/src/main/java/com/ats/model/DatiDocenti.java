package com.ats.model;

import java.io.Serializable;

public class DatiDocenti implements Serializable{
	private String nomedocente;
	private String cognomedocente;
	private String cvdocente;
	private int coddocente;
	
	public DatiDocenti () {
		
	}

	public String getNomedocente() {
		return nomedocente;
	}

	public void setNomedocente(String nomedocente) {
		this.nomedocente = nomedocente;
	}

	public String getCognomedocente() {
		return cognomedocente;
	}

	public void setCognomedocente(String cognomedocente) {
		this.cognomedocente = cognomedocente;
	}

	public String getCvdocente() {
		return cvdocente;
	}

	public void setCvdocente(String cvdocente) {
		this.cvdocente = cvdocente;
	}

	public int getCoddocente() {
		return coddocente;
	}

	public void setCoddocente(int coddocente) {
		this.coddocente = coddocente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coddocente;
		result = prime * result + ((cognomedocente == null) ? 0 : cognomedocente.hashCode());
		result = prime * result + ((cvdocente == null) ? 0 : cvdocente.hashCode());
		result = prime * result + ((nomedocente == null) ? 0 : nomedocente.hashCode());
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
		DatiDocenti other = (DatiDocenti) obj;
		if (coddocente != other.coddocente)
			return false;
		if (cognomedocente == null) {
			if (other.cognomedocente != null)
				return false;
		} else if (!cognomedocente.equals(other.cognomedocente))
			return false;
		if (cvdocente == null) {
			if (other.cvdocente != null)
				return false;
		} else if (!cvdocente.equals(other.cvdocente))
			return false;
		if (nomedocente == null) {
			if (other.nomedocente != null)
				return false;
		} else if (!nomedocente.equals(other.nomedocente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiDocenti [nomedocente=" + nomedocente + ", cognomedocente=" + cognomedocente + ", cvdocente="
				+ cvdocente + ", coddocente=" + coddocente + "]";
	}
	

}
