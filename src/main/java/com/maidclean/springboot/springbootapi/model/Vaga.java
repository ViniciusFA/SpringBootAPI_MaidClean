package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_vagas")
public class Vaga implements Serializable{
	
	private static final long serialVersionUID = 161312777442840210L;
	
	public Vaga() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_vaga")	
	private int id_vaga;
	
	@Column(name="ds_titulo")
	private String titulo;
	
	@Column(name="ds_subtitulo")
	private String subtitulo;
	
	@Column(name="ds_descricao")
	private String descricao;
	
	@Column(name="ds_nome_empregador")
	private String nomeEmpregador;
	
	@Column(name="ds_estado")
	private String estado;
	
	@Column(name="ds_cidade")
	private String cidade;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeEmpregador() {
		return nomeEmpregador;
	}

	public void setNomeEmpregador(String nomeEmpregador) {
		this.nomeEmpregador = nomeEmpregador;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId_vaga() {
		return id_vaga;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id_vaga;
		result = prime * result + ((nomeEmpregador == null) ? 0 : nomeEmpregador.hashCode());
		result = prime * result + ((subtitulo == null) ? 0 : subtitulo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Vaga other = (Vaga) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_vaga != other.id_vaga)
			return false;
		if (nomeEmpregador == null) {
			if (other.nomeEmpregador != null)
				return false;
		} else if (!nomeEmpregador.equals(other.nomeEmpregador))
			return false;
		if (subtitulo == null) {
			if (other.subtitulo != null)
				return false;
		} else if (!subtitulo.equals(other.subtitulo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vaga [id_vaga=" + id_vaga + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", descricao="
				+ descricao + ", nomeEmpregador=" + nomeEmpregador + ", estado=" + estado + ", cidade=" + cidade + "]";
	}
	
}
