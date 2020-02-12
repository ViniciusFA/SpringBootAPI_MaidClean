package com.maidclean.springboot.springbootapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_calendario")
public class Calendario {
 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_calendar")
	private Long idCalendario;
	
	@OneToOne
	@JoinColumn(name="id_historico")
	private Historico historico;
	
	@OneToMany
	@JoinColumn(name="id_agendamento")
	private List<Agendamento> agendamento;
	
	@OneToMany
	@JoinColumn(name="id_notas")
	private List<Notas> notas;

	public Long getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(Long idCalendario) {
		this.idCalendario = idCalendario;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

	public List<Notas> getNotas() {
		return notas;
	}

	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agendamento == null) ? 0 : agendamento.hashCode());
		result = prime * result + ((historico == null) ? 0 : historico.hashCode());
		result = prime * result + ((idCalendario == null) ? 0 : idCalendario.hashCode());
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
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
		Calendario other = (Calendario) obj;
		if (agendamento == null) {
			if (other.agendamento != null)
				return false;
		} else if (!agendamento.equals(other.agendamento))
			return false;
		if (historico == null) {
			if (other.historico != null)
				return false;
		} else if (!historico.equals(other.historico))
			return false;
		if (idCalendario == null) {
			if (other.idCalendario != null)
				return false;
		} else if (!idCalendario.equals(other.idCalendario))
			return false;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calendario [idCalendario=" + idCalendario + ", historico=" + historico + ", agendamento=" + agendamento
				+ ", notas=" + notas + "]";
	}
	
}
