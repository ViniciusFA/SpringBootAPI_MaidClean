package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_historico")
public class Historico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_historico")
	private Long idHistorico;
	
	@OneToOne
	@JoinColumn(name="id_avaliacao")
	private Avaliacoes avaliacao;

	public Long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Avaliacoes getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacoes avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avaliacao == null) ? 0 : avaliacao.hashCode());
		result = prime * result + ((idHistorico == null) ? 0 : idHistorico.hashCode());
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
		Historico other = (Historico) obj;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (idHistorico == null) {
			if (other.idHistorico != null)
				return false;
		} else if (!idHistorico.equals(other.idHistorico))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Historico [idHistorico=" + idHistorico + ", avaliacao=" + avaliacao + "]";
	}
	
	
}
