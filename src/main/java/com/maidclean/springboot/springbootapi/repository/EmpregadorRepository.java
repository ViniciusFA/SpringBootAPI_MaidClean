package com.maidclean.springboot.springbootapi.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.EmpregadorModel;
import com.maidclean.springboot.springbootapi.model.FuncionarioModel;

public interface EmpregadorRepository extends Repository<EmpregadorModel, Long>{

	void save(EmpregadorModel pessoa);
	 
	void delete(EmpregadorModel pessoa);
 
	List<EmpregadorModel> findAll();
 
	EmpregadorModel findById(Integer id);
	
}
