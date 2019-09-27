package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empregadores")
public class EmpregadorModel implements Serializable{
	
	private static final long serialVersionUID = 5408753583413586310L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_empregador")	
	private int id;	
	@Column(name="cpf")	
	private Long cpf;	
	@Column(name="ds_nome")	
	private String nome;	
	@Column(name="ds_sobrenome")	
	private String sobrenome;	
	@Column(name="ds_login")	
	private String login;	
	@Column(name="ds_senha")	
	private String senha;	
	@Column(name="ds_email")	
	private String email;	
	@Column(name="ds_facebook")	
	private String url_facebook;	
	@Column(name="haswhatsapp")	
	private boolean hasWhatsapp;	
	@Column(name="telefone")	
	private Long telefone;	
	@Column(name="residencia")	
	private String residencia;	
	@Column(name="ds_endereco")	
	private String endereco;	
	@Column(name="ds_complemento")	
	private String complemento;	
	@Column(name="nm_cidade")	
	private String cidade;	
	@Column(name="vl_estado")	
	private int estado;	
	@Column(name="cep")	
	private Long cep;	
	@Column(name="vl_sexo")	
	private boolean isMale;
	
	public EmpregadorModel() {}

	
	public int getId() {
		return id;
	}

	public void setId(int id_empregador) {
		this.id = id_empregador;
	}
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUrl_facebook() {
		return url_facebook;
	}

	public void setUrl_facebook(String url_facebook) {
		this.url_facebook = url_facebook;
	}
	
	public boolean isHasWhatsapp() {
		return hasWhatsapp;
	}

	public void setHasWhatsapp(boolean hasWhatsapp) {
		this.hasWhatsapp = hasWhatsapp;
	}
	
	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	
	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}
	
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	@Override
	public String toString() {
		return "EmpregadorModel [id_empregador=" + id + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", url_facebook="
				+ url_facebook + ", hasWhatsapp=" + hasWhatsapp + ", telefone=" + telefone + ", residencia="
				+ residencia + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + ", isMale=" + isMale + "]";
	}	
	
}
