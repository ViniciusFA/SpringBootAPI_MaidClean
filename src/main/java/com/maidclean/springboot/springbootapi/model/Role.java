package com.maidclean.springboot.springbootapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="tb_roles")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -9199006157939671165L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_role")
	private int id_role;	
	
	@Column(name="name_role")
	public String nameRule;	

	
	public String getNameRule() {
		return nameRule;
	}

	public void setNameRule(String nameRule) {
		this.nameRule = nameRule;
	}
	
	public int getId_role() {
		return id_role;
	}
	
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	@Override
	public String getAuthority() {
		return nameRule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_role;
		result = prime * result + ((nameRule == null) ? 0 : nameRule.hashCode());
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
		Role other = (Role) obj;
		if (id_role != other.id_role)
			return false;
		if (nameRule == null) {
			if (other.nameRule != null)
				return false;
		} else if (!nameRule.equals(other.nameRule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", nameRule=" + nameRule + "]";
	}
	
}
