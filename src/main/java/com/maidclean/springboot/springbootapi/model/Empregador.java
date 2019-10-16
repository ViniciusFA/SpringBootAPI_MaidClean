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
public class Empregador implements Serializable{
	
	private static final long serialVersionUID = 5408753583413586310L;
	
	public Empregador() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_empregador")	
	private Long id_empregador;	
	
	@Column(name="ds_cnpj_cpf")	
	private String cnpj;	
	
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
	
	@Column(name="ds_telefone")	
	private String telefone;	
	
	@Column(name="ds_residencia")	
	private String residencia;	
	
	@Column(name="ds_endereco")	
	private String endereco;	
	
	@Column(name="ds_complemento")	
	private String complemento;	
	
	@Column(name="ds_cidade")	
	private String cidade;	
	
	@Column(name="ds_estado")	
	private String estado;	
	
	@Column(name="ds_cep")	
	private String cep;	
	
	@Column(name="ds_sexo")	
	private String sexo;
	
	public Long getId() {
		return id_empregador;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
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
			
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "EmpregadorModel [id_empregador=" + id_empregador + ", cnpj_cpf=" + cnpj + ", nome=" + nome + ", sobrenome="
				+ sobrenome + ", login=" + login + ", senha=" + senha + ", email=" + email + ", telefone=" + telefone + ", residencia="
				+ residencia + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + ", sexo=" + sexo + "]";
	}	
	
}
