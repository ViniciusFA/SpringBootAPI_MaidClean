package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class FuncionarioModel {

	private int id;
	private int cpf;
	private String nome;
	private String sobrenome;
	private String login;
	private String senha;
	private String email;
	private String url_facebook;
	private boolean hasWhatsapp;
	private int telefone;
	private String profissao;
	private String experiencia;
	private String endereco;
	private String complemento;
	private String cidade;
	private int estado;
	private int cep;
	private int avaliacao;
	private boolean isMale;
	
	public FuncionarioModel() {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_funcionario")
	public int getId() {
		return id;
	}

	public void setId(int id_funcionario) {
		this.id = id_funcionario;
	}

	@Column(name="cpf")
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Column(name="ds_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="ds_sobrenome")
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name="ds_login")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="ds_senha")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Column(name="ds_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="ds_facebook")
	public String getUrl_facebook() {
		return url_facebook;
	}

	public void setUrl_facebook(String url_facebook) {
		this.url_facebook = url_facebook;
	}

	@Column(name="haswhatsapp")
	public boolean isHasWhatsapp() {
		return hasWhatsapp;
	}

	public void setHasWhatsapp(boolean hasWhatsapp) {
		this.hasWhatsapp = hasWhatsapp;
	}

	@Column(name="telefone")
	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Column(name="profissao")
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Column(name="experiencia")
	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Column(name="ds_endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name="ds_complemento")
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name="nm_cidade")
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name="vl_estado")
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name="cep")
	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	@Column(name="vl_avaliacao")
	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Column(name="vl_sexo")
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
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
