package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_estados")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_Estado")
	private Integer id_estado;
	
	@Column(name="nome_estado")
	private String nome_estado;

	public String getNome_estado() {
		return nome_estado;
	}

	public void setNome_estado(String nome_estado) {
		this.nome_estado = nome_estado;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_estado == null) ? 0 : id_estado.hashCode());
		result = prime * result + ((nome_estado == null) ? 0 : nome_estado.hashCode());
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
		Estado other = (Estado) obj;
		if (id_estado == null) {
			if (other.id_estado != null)
				return false;
		} else if (!id_estado.equals(other.id_estado))
			return false;
		if (nome_estado == null) {
			if (other.nome_estado != null)
				return false;
		} else if (!nome_estado.equals(other.nome_estado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [id_estado=" + id_estado + ", nome_estado=" + nome_estado + "]";
	}

}
