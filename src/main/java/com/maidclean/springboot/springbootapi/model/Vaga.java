package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_vagas")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 161312777442840210L;

	public Vaga() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vaga")
	private Integer id;

	@Column(name = "ds_titulo")
	private String titulo;

	@Column(name = "ds_subtitulo")
	private String subtitulo;

	@Column(name = "ds_descricao")
	private String descricao;
	
	@Transient
	private String idEmpregador;

	@Transient
	private String nomeEmpregador;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name ="id_experiencia")
	private Experiencia experiencia;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setIdUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getIdEmpregador() {
		return idEmpregador;
	}
	

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idEmpregador == null) ? 0 : idEmpregador.hashCode());
		result = prime * result + ((experiencia == null) ? 0 : experiencia.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idEmpregador == null) {
			if (other.idEmpregador != null)
				return false;
		} else if (!idEmpregador.equals(other.idEmpregador))
			return false;
		if (experiencia == null) {
			if (other.experiencia != null)
				return false;
		} else if (!experiencia.equals(other.experiencia))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
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
		return "Vaga [id=" + id + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", descricao=" + descricao
				+ ", idEmpregador=" + idEmpregador + ", nomeEmpregador=" + nomeEmpregador + ", estado=" + estado
				+ ", cidade=" + cidade + ", idUsuario=" + usuario + ", idExperiencia=" + experiencia + "]";
	}

}
