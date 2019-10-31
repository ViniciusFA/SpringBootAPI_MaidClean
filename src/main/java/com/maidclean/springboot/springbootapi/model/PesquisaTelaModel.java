package com.maidclean.springboot.springbootapi.model;

import java.util.Optional;

public class PesquisaTelaModel {

	private Optional<String> nome;
	private Optional<String> sobrenome;
	private Optional<String> cidade;
	private Optional<String> estado;
	private Optional<String> sexo;
	private Optional<String> experiencia;
	private int idRole;
	
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
	public Optional<String> getCidade() {
		return cidade;
	}
	public void setCidade(Optional<String> cidade) {
		this.cidade = cidade;
	}
	public Optional<String> getEstado() {
		return estado;
	}
	public void setEstado(Optional<String> estado) {
		this.estado = estado;
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

	
	
	
}
