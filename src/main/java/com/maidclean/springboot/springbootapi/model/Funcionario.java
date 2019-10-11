package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tb_funcionarios")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 4770619631728341970L;
	
	
	
	public Funcionario(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public static Funcionario create(Usuario usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario está vazio.Por favor preencha-o.");
		}
		return new Funcionario(usuario);
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
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
	private boolean hasWhatsapp;	
	
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
	private Integer estado;	
	
	@Column(name="ds_cep")
	private String cep;		
	
	@Column(name="vl_sexo")
	private boolean isMale;
	
	@Column(name="ds_sobrenome")
	private String sobrenome;
	
	@OneToOne
	@JoinColumn(name="id_usuario", nullable = false)
	private Usuario usuario;
	
	public Long getId() {
		return id;
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
	
	public boolean isHasWhatsapp() {
		return hasWhatsapp;
	}

	public void setHasWhatsapp(boolean hasWhatsapp) {
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
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "FuncionarioModel [id_funcionario=" + id + ", cpf=" + cpf + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", url_facebook="
				+ url_facebook + ", hasWhatsapp=" + hasWhatsapp + ", telefone=" + telefone + ", profissao=" + profissao
				+ ", experiencia=" + experiencia + ", endereco=" + endereco + ", complemento=" + complemento
				+ ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + ", isMale=" + isMale + "]";
	}
	
}
