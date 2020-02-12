package com.maidclean.springboot.springbootapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_agendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_agendamento")
	private Long idAgendamento;
	
	@Column(name="dt_agendamento")
	private Date dataAgendamento;

	public Long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAgendamento == null) ? 0 : dataAgendamento.hashCode());
		result = prime * result + ((idAgendamento == null) ? 0 : idAgendamento.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (dataAgendamento == null) {
			if (other.dataAgendamento != null)
				return false;
		} else if (!dataAgendamento.equals(other.dataAgendamento))
			return false;
		if (idAgendamento == null) {
			if (other.idAgendamento != null)
				return false;
		} else if (!idAgendamento.equals(other.idAgendamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agendamento [idAgendamento=" + idAgendamento + ", dataAgendamento=" + dataAgendamento + "]";
	}
	
	
}
