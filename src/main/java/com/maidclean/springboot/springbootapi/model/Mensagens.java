package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_mensagens")
public class Mensagens implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="id_mensagem")
	private Long idMensagem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_rem")
	private Usuario idUserRem;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_des")
	private Usuario idUserDes;
	
	@Column(name="ds_mensagem")
	private String dsMessage;

	public Long getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}

	public Usuario getIdUserRem() {
		return idUserRem;
	}

	public void setIdUserRem(Usuario idUserRem) {
		this.idUserRem = idUserRem;
	}

	public Usuario getIdUserDes() {
		return idUserDes;
	}

	public void setIdUserDes(Usuario idUserDes) {
		this.idUserDes = idUserDes;
	}

	public String getDsMessage() {
		return dsMessage;
	}

	public void setDsMessage(String dsMessage) {
		this.dsMessage = dsMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsMessage == null) ? 0 : dsMessage.hashCode());
		result = prime * result + ((idMensagem == null) ? 0 : idMensagem.hashCode());
		result = prime * result + ((idUserDes == null) ? 0 : idUserDes.hashCode());
		result = prime * result + ((idUserRem == null) ? 0 : idUserRem.hashCode());
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
		Mensagens other = (Mensagens) obj;
		if (dsMessage == null) {
			if (other.dsMessage != null)
				return false;
		} else if (!dsMessage.equals(other.dsMessage))
			return false;
		if (idMensagem == null) {
			if (other.idMensagem != null)
				return false;
		} else if (!idMensagem.equals(other.idMensagem))
			return false;
		if (idUserDes == null) {
			if (other.idUserDes != null)
				return false;
		} else if (!idUserDes.equals(other.idUserDes))
			return false;
		if (idUserRem == null) {
			if (other.idUserRem != null)
				return false;
		} else if (!idUserRem.equals(other.idUserRem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensagens [idMensagem=" + idMensagem + ", idUserRem=" + idUserRem + ", idUserDes=" + idUserDes
				+ ", dsMessage=" + dsMessage + "]";
	}
	
}
