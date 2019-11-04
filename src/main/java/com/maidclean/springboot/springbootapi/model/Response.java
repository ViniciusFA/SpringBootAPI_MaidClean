package com.maidclean.springboot.springbootapi.model;

public class Response {

	private int codigo;
	private String mensagem;
	private int id_role;
 
	public Response(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	public Response(int codigo, String mensagem,int id_role) {
		this.codigo   = codigo;
		this.mensagem =  mensagem;
		this.id_role = id_role;
	}
 
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
 
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getId_role() {
		return id_role;
	}
	
}
