package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionarios")
public class FuncionarioModel implements Serializable{

	private static final long serialVersionUID = 4770619631728341970L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;		
	@Column(name="ds_nome")
	private String nome;	
	@Column(name="ds_cpf")
	private String cpf;			
	@Column(name="ds_login")
	private String login;	
	@Column(name="ds_senha")	
	private String senha;	
	@Column(name="ds_email")
	private String email;	
	@Column(name="ds_facebook")
	private String url_facebook;	
	@Column(name="vl_haswhatsapp")
	private String hasWhatsapp;	
	@Column(name="ds_telefone")
	private String telefone;	
	@Column(name="ds_profissao")	
	private String profissao;	
	@Column(name="ds_experiencia")
	private String experiencia;		
	@Column(name="ds_endereco")
	private String endereco;	
	@Column(name="ds_complemento")
	private String complemento;	
	@Column(name="ds_cidade")
	private String cidade;		
	@Column(name="vl_estado")
	private String estado;	
	@Column(name="ds_cep")
	private String cep;	
	@Column(name="vl_avaliacao")
	private String avaliacao;	
	@Column(name="vl_sexo")
	private String isMale;
	@Column(name="ds_sobrenome")
	private String sobrenome;
	
	public FuncionarioModel() {}


	public int getId() {
		return id;
	}
	
	public void setId(int id_funcionario) {
		this.id = id_funcionario;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
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
	
	public String isHasWhatsapp() {
		return hasWhatsapp;
	}

	public void setHasWhatsapp(String hasWhatsapp) {
		this.hasWhatsapp = hasWhatsapp;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
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
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String isMale() {
		return isMale;
	}

	public void setMale(String isMale) {
		this.isMale = isMale;
	}

	@Override
	public String toString() {
		return "FuncionarioModel [id_funcionario=" + id + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", url_facebook="
				+ url_facebook + ", hasWhatsapp=" + hasWhatsapp + ", telefone=" + telefone + ", profissao=" + profissao
				+ ", experiencia=" + experiencia + ", endereco=" + endereco + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", avaliacao=" + avaliacao
				+ ", isMale=" + isMale + "]";
	}
	
}
