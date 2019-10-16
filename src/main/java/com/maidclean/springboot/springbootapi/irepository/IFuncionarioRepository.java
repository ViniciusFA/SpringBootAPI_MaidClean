package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Funcionario;

public interface IFuncionarioRepository extends Repository<Funcionario, Integer>{

	void save(Funcionario pessoa);
	 
	void delete(Funcionario pessoa);
 
	List<Funcionario> findAll();
 
	Funcionario findById(Long id);
	
	
	
}


