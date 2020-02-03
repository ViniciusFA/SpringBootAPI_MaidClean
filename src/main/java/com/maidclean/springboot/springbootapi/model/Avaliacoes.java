package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_avaliacoes")
public class Avaliacoes implements Serializable{
		
	private static final long serialVersionUID = 5669264619519542415L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_avaliacao")
	private Long idAvaliacao;	
		
	@Column(name="vl_compromisso")
	private float compromisso;
	
	@Column(name="vl_organizacao")
	private float organizacao;
	
	@Column(name="vl_disciplina")
	private float disciplina;
	
	@Column(name="vl_limpeza")
	private float limpeza;
	
	@Column(name="vl_media_avaliacao")
	private double mediaAvaliacao;
		
	public Long getIdAvaliacao() {
		return idAvaliacao;
	}
		
	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
 
	public float getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(float organizacao) {
		this.organizacao = organizacao;
	}
	public float getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(float disciplina) {
		this.disciplina = disciplina;
	}
	public float getLimpeza() {
		return limpeza;
	}
	public void setLimpeza(float limpeza) {
		this.limpeza = limpeza;
	}
	public float getCompromisso() {
		return compromisso;
	}	
	public void setCompromisso(float compromisso) {
		this.compromisso = compromisso;
	}	
	
	public double getMediaAvaliacao() {
		return mediaAvaliacao;
	}
	public void setMediaAvaliacao(double mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}		
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(compromisso);
		result = prime * result + Float.floatToIntBits(disciplina);
		result = prime * result + ((idAvaliacao == null) ? 0 : idAvaliacao.hashCode());
		result = prime * result + Float.floatToIntBits(limpeza);
		long temp;
		temp = Double.doubleToLongBits(mediaAvaliacao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(organizacao);
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
		Avaliacoes other = (Avaliacoes) obj;
		if (Float.floatToIntBits(compromisso) != Float.floatToIntBits(other.compromisso))
			return false;
		if (Float.floatToIntBits(disciplina) != Float.floatToIntBits(other.disciplina))
			return false;
		if (idAvaliacao == null) {
			if (other.idAvaliacao != null)
				return false;
		} else if (!idAvaliacao.equals(other.idAvaliacao))
			return false;
		if (Float.floatToIntBits(limpeza) != Float.floatToIntBits(other.limpeza))
			return false;
		if (Double.doubleToLongBits(mediaAvaliacao) != Double.doubleToLongBits(other.mediaAvaliacao))
			return false;
		if (Float.floatToIntBits(organizacao) != Float.floatToIntBits(other.organizacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaliacoes [idAvaliacao=" + idAvaliacao + ", compromisso=" + compromisso + ", organizacao="
				+ organizacao + ", disciplina=" + disciplina + ", limpeza=" + limpeza + ", mediaAvaliacao="
				+ mediaAvaliacao + "]";
	}
	
}
