package com.maidclean.springboot.springbootapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_roles")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -9199006157939671165L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="name_rule")
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
