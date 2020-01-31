package com.maidclean.springboot.springbootapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidades")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_cidade")
	private Integer id_cidade;
	
	@Column(name="nome_cidade")
	private String nome_cidade;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_estado")
	private Estado estado;

	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getId_cidade() {
		return id_cidade;
	}
	
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	
	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id_cidade == null) ? 0 : id_cidade.hashCode());
		result = prime * result + ((nome_cidade == null) ? 0 : nome_cidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_cidade == null) {
			if (other.id_cidade != null)
				return false;
		} else if (!id_cidade.equals(other.id_cidade))
			return false;
		if (nome_cidade == null) {
			if (other.nome_cidade != null)
				return false;
		} else if (!nome_cidade.equals(other.nome_cidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [id_cidade=" + id_cidade + ", nome_cidade=" + nome_cidade + ", estado=" + estado + "]";
	}

	
}
