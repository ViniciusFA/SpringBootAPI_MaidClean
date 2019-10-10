package com.maidclean.springboot.springbootapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="tb_roles")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -9199006157939671165L;

	@Id
	public String nameRule;
	
	@ManyToMany
	@JsonIgnore
	private List<Usuario> usuarios;
		
	
	public String getNameRule() {
		return nameRule;
	}

	public void setNameRule(String nameRule) {
		this.nameRule = nameRule;
	}

	@Override
	public String getAuthority() {
		return nameRule;
	}

}
