package com.maidclean.springboot.springbootapi.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name="tb_usuarios")
public class Usuario implements UserDetails, Serializable{

	private static final long serialVersionUID = -2606442091344673140L;		

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="ds_login")
	private String login;

	@Column(name="ds_senha")
	private String senha;

	@Column(name="ds_nome")
	private String nome;

	@Column(name="ds_sobrenome")
	private String sobrenome;	

	@Column(name="ds_cpf_cnpj")
	private String cpf_cnpj;

	@Column(name="ds_facebook")
	private String facebook;

	@Column(name="ds_has_Whatsapp")
	private String hasWhatsapp;

	@Column(name="ds_telefone")
	private String telefone;

	@Column(name="ds_profissao")
	private String profissao;

	@OneToOne
	@JoinColumn(name="id_experiencia")
	private Experiencia experiencia;

	@Column(name="ds_endereco")
	private String endereco;

	@Column(name="ds_complemento")
	private String complemento;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_cidade")
	private Cidade cidade;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_estado")
	private Estado estado;

	@Column(name="ds_cep")
	private String cep;

	@Column(name="ds_sexo")
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name="id_stars")
	private Estrelas stars;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_avaliacao")
	private Avaliacoes avaliacao;

	@Column(name="ds_residencia")
	private String residencia;

	@OneToOne
	@JoinColumn(name="id_role")
	private Role role;	

	@Column(name="ds_email")
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_image")	
	private ImagemPerfil foto;
	
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

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getHasWhatsapp() {
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

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
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

	public Avaliacoes getAvaliacao() {
	//public Avaliacoes getAvaliacao() {	
		return avaliacao;
	}

	public void setAvaliacao(Avaliacoes avaliacao) {
	//public void setAvaliacao(Avaliacoes avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
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
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public Estrelas getStars() {
		return stars;
	}

	public void setStars(Estrelas stars) {
		this.stars = stars;
	}

	public ImagemPerfil getFoto() {
		return foto;
	}

	public void setFoto(ImagemPerfil foto) {
		this.foto = foto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avaliacao == null) ? 0 : avaliacao.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf_cnpj == null) ? 0 : cpf_cnpj.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((experiencia == null) ? 0 : experiencia.hashCode());
		result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((hasWhatsapp == null) ? 0 : hasWhatsapp.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((profissao == null) ? 0 : profissao.hashCode());
		result = prime * result + ((residencia == null) ? 0 : residencia.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((stars == null) ? 0 : stars.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Usuario other = (Usuario) obj;
		if (avaliacao == null) {
			if (other.avaliacao != null)
				return false;
		} else if (!avaliacao.equals(other.avaliacao))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf_cnpj == null) {
			if (other.cpf_cnpj != null)
				return false;
		} else if (!cpf_cnpj.equals(other.cpf_cnpj))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (experiencia == null) {
			if (other.experiencia != null)
				return false;
		} else if (!experiencia.equals(other.experiencia))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (hasWhatsapp == null) {
			if (other.hasWhatsapp != null)
				return false;
		} else if (!hasWhatsapp.equals(other.hasWhatsapp))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (profissao == null) {
			if (other.profissao != null)
				return false;
		} else if (!profissao.equals(other.profissao))
			return false;
		if (residencia == null) {
			if (other.residencia != null)
				return false;
		} else if (!residencia.equals(other.residencia))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (stars == null) {
			if (other.stars != null)
				return false;
		} else if (!stars.equals(other.stars))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + ", nome=" + nome
				+ ", sobrenome=" + sobrenome + ", cpf_cnpj=" + cpf_cnpj + ", facebook=" + facebook + ", hasWhatsapp="
				+ hasWhatsapp + ", telefone=" + telefone + ", profissao=" + profissao + ", experiencia=" + experiencia
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", estado="
				+ estado + ", cep=" + cep + ", sexo=" + sexo + ", id_star=" + stars + ", avaliacao=" + avaliacao
				+ ", residencia=" + residencia + ", role=" + role + ", email=" + email + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}


}
