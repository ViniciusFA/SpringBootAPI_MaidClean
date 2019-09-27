package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.FuncionarioModel;

public interface IFuncionarioRepository extends Repository<FuncionarioModel, Integer>{

	void save(FuncionarioModel pessoa);
	 
	void delete(FuncionarioModel pessoa);
 
	List<FuncionarioModel> findAll();
 
	FuncionarioModel findById(Integer id);
		
}
