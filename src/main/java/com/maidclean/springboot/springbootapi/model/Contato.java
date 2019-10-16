package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tb_contatos")
public class Contato implements Serializable{

	private static final long serialVersionUID = -8526802374793214301L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contato")
	private int id;	
	@Column(name = "ds_nome")
	private String nome;	
	@Column(name = "ds_sobrenome")
	private String sobrenome;	
	@Column(name = "ds_email")
	private String email;	
	@Column(name = "ds_motivo")
	private String motivo;	
	@Column(name = "ds_mensagem")
	private String mensagem;
	@Column(name = "dt_contato")
	private Date dataContato;
	
	public Contato() {}

	public int getId_contato() {
		return id;
	}

	public void setId_contato(int id_contato) {
		this.id = id_contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Date getDataContato() {
		return dataContato;
	}

	public void setDataContato(Date dataContato) {
		this.dataContato = dataContato;
	}

	@Override
	public String toString() {
		return "ContatoModel [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", motivo=" + motivo + ", mensagem=" + mensagem + ", dataContato=" + dataContato + "]";
	}

}
