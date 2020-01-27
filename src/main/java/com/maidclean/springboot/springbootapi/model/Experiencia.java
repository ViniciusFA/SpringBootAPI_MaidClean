package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_experiencia")
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_experiencia")
	private long idExperiencia;
	
	@Column(name="ds_tempo")
	private String tempo;

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public long getIdExperiencia() {
		return idExperiencia;
	}	
	
	public void setIdExperiencia(long idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idExperiencia ^ (idExperiencia >>> 32));
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
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
		Experiencia other = (Experiencia) obj;
		if (idExperiencia != other.idExperiencia)
			return false;
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Experiencia [idExperiencia=" + idExperiencia + ", tempo=" + tempo + "]";
	}
		
}
