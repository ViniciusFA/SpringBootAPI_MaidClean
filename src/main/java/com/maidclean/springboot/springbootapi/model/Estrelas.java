package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stars")
public class Estrelas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_star")
	private Integer id_star;
	
	@Column(name="vl_star")
	private int valor_star;
	
	@Column(name="ds_star")
	private String nome_star;

	public Integer getId_star() {
		return id_star;
	}

	public void setId_star(Integer id_star) {
		this.id_star = id_star;
	}

	public int getValor_star() {
		return valor_star;
	}

	public void setValor_star(int valor_star) {
		this.valor_star = valor_star;
	}

	public String getNome_star() {
		return nome_star;
	}

	public void setNome_star(String nome_star) {
		this.nome_star = nome_star;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_star ^ (id_star >>> 32));
		result = prime * result + ((nome_star == null) ? 0 : nome_star.hashCode());
		result = prime * result + valor_star;
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
		Estrelas other = (Estrelas) obj;
		if (id_star != other.id_star)
			return false;
		if (nome_star == null) {
			if (other.nome_star != null)
				return false;
		} else if (!nome_star.equals(other.nome_star))
			return false;
		if (valor_star != other.valor_star)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estrelas [id_star=" + id_star + ", valor_star=" + valor_star + ", nome_star=" + nome_star + "]";
	}
	

}
