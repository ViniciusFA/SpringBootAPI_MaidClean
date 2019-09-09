package com.maidclean.springboot.springbootapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.FuncionarioModel;

public interface FuncionarioRepository extends Repository<FuncionarioModel, Long>{

	void save(FuncionarioModel pessoa);
	 
	void delete(FuncionarioModel pessoa);
 
	List<FuncionarioModel> findAll();
 
	FuncionarioModel findById(Integer id);
		
}
