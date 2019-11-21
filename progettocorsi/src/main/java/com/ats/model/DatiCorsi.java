package com.ats.model;

import java.io.Serializable;
import java.time.LocalDate;

public class DatiCorsi implements Serializable{
	private int codcorso;
	private int coddocente;
	private String nomecorso;
	private LocalDate data_iniziocorso;
	private LocalDate data_finecorso;
	private int costocorso;
	private String commenticorso;
	private String  aulacorso;
	
	public DatiCorsi() {
		
	}

	public int getCodcorso() {
		return codcorso;
	}

	public void setCodcorso(int codcorso) {
		this.codcorso = codcorso;
	}

	public int getCoddocente() {
		return coddocente;
	}

	public void setCoddocente(int coddocente) {
		this.coddocente = coddocente;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public LocalDate getData_iniziocorso() {
		return data_iniziocorso;
	}

	public void setData_iniziocorso(LocalDate data_iniziocorso) {
		this.data_iniziocorso = data_iniziocorso;
	}

	public LocalDate getData_finecorso() {
		return data_finecorso;
	}

	public void setData_finecorso(LocalDate data_finecorso) {
		this.data_finecorso = data_finecorso;
	}

	public int getCostocorso() {
		return costocorso;
	}

	public void setCostocorso(int costocorso) {
		this.costocorso = costocorso;
	}

	public String getCommenticorso() {
		return commenticorso;
	}

	public void setCommenticorso(String commenticorso) {
		this.commenticorso = commenticorso;
	}

	public String getAulacorso() {
		return aulacorso;
	}

	public void setAulacorso(String aulacorso) {
		this.aulacorso = aulacorso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulacorso == null) ? 0 : aulacorso.hashCode());
		result = prime * result + codcorso;
		result = prime * result + coddocente;
		result = prime * result + ((commenticorso == null) ? 0 : commenticorso.hashCode());
		result = prime * result + costocorso;
		result = prime * result + ((data_finecorso == null) ? 0 : data_finecorso.hashCode());
		result = prime * result + ((data_iniziocorso == null) ? 0 : data_iniziocorso.hashCode());
		result = prime * result + ((nomecorso == null) ? 0 : nomecorso.hashCode());
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
		DatiCorsi other = (DatiCorsi) obj;
		if (aulacorso == null) {
			if (other.aulacorso != null)
				return false;
		} else if (!aulacorso.equals(other.aulacorso))
			return false;
		if (codcorso != other.codcorso)
			return false;
		if (coddocente != other.coddocente)
			return false;
		if (commenticorso == null) {
			if (other.commenticorso != null)
				return false;
		} else if (!commenticorso.equals(other.commenticorso))
			return false;
		if (costocorso != other.costocorso)
			return false;
		if (data_finecorso == null) {
			if (other.data_finecorso != null)
				return false;
		} else if (!data_finecorso.equals(other.data_finecorso))
			return false;
		if (data_iniziocorso == null) {
			if (other.data_iniziocorso != null)
				return false;
		} else if (!data_iniziocorso.equals(other.data_iniziocorso))
			return false;
		if (nomecorso == null) {
			if (other.nomecorso != null)
				return false;
		} else if (!nomecorso.equals(other.nomecorso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DatiCorsi [codcorso=" + codcorso + ", coddocente=" + coddocente + ", nomecorso=" + nomecorso
				+ ", data_iniziocorso=" + data_iniziocorso + ", data_finecorso=" + data_finecorso + ", costocorso="
				+ costocorso + ", commenticorso=" + commenticorso + ", aulacorso=" + aulacorso + "]";
	}
	

}
