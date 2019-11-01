package com.maidclean.springboot.springbootapi.model;

import java.util.Optional;

public class PesquisaFuncionario {

	private Optional<String> nome;
	private Optional<String> sobrenome;
	private Optional<String> estado;
	private Optional<String> cidade;
	private Optional<String> sexo;
	private Optional<String> experiencia;
	private int idRole;
	
	public PesquisaFuncionario() {}

	public Optional<String> getNome() {
		return nome;
	}

	public void setNome(Optional<String> nome) {
		this.nome = nome;
	}

	public Optional<String> getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(Optional<String> sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Optional<String> getEstado() {
		return estado;
	}

	public void setEstado(Optional<String> estado) {
		this.estado = estado;
	}

	public Optional<String> getCidade() {
		return cidade;
	}

	public void setCidade(Optional<String> cidade) {
		this.cidade = cidade;
	}

	public Optional<String> getSexo() {
		return sexo;
	}

	public void setSexo(Optional<String> sexo) {
		this.sexo = sexo;
	}

	public Optional<String> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Optional<String> experiencia) {
		this.experiencia = experiencia;
	}
	

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((experiencia == null) ? 0 : experiencia.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		PesquisaFuncionario other = (PesquisaFuncionario) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		return true;
	}

	@Override
	public String toString() {
		return "PesquisaFuncionario [nome=" + nome + ", sobrenome=" + sobrenome + ", estado=" + estado + ", cidade="
				+ cidade + ", sexo=" + sexo + ", experiencia=" + experiencia + "]";
	}
	
}
