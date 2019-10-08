package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_usuarios")
public class UsuarioModel implements Serializable{

	private static final long serialVersionUID = -2606442091344673140L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="ds_login")
	private String login;
	
	@Column(name="nm_usuario")
	private String nome;
	
	@Column(name="ds_email")
	private String email;
	
	public UsuarioModel() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", login=" + login + ", nome=" + nome + ", email=" + email + "]";
	}

	
}
