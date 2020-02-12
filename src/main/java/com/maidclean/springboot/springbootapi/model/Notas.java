package com.maidclean.springboot.springbootapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_notas")
public class Notas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_notas")
	private Long idNotas;
	
	@Column(name="dt_nota")
	private Date dataNota;
	
	@Column(name="ds_conteudo")
	private String conteudoNota;

	public Long getIdNotas() {
		return idNotas;
	}

	public void setIdNotas(Long idNotas) {
		this.idNotas = idNotas;
	}

	public Date getDataNota() {
		return dataNota;
	}

	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}

	public String getConteudoNota() {
		return conteudoNota;
	}

	public void setConteudoNota(String conteudoNota) {
		this.conteudoNota = conteudoNota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudoNota == null) ? 0 : conteudoNota.hashCode());
		result = prime * result + ((dataNota == null) ? 0 : dataNota.hashCode());
		result = prime * result + ((idNotas == null) ? 0 : idNotas.hashCode());
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
		Notas other = (Notas) obj;
		if (conteudoNota == null) {
			if (other.conteudoNota != null)
				return false;
		} else if (!conteudoNota.equals(other.conteudoNota))
			return false;
		if (dataNota == null) {
			if (other.dataNota != null)
				return false;
		} else if (!dataNota.equals(other.dataNota))
			return false;
		if (idNotas == null) {
			if (other.idNotas != null)
				return false;
		} else if (!idNotas.equals(other.idNotas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notas [idNotas=" + idNotas + ", dataNota=" + dataNota + ", conteudoNota=" + conteudoNota + "]";
	}
	
	
}
