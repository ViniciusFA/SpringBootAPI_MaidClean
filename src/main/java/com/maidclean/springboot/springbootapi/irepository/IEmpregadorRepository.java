package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.EmpregadorModel;
import com.maidclean.springboot.springbootapi.model.FuncionarioModel;

public interface IEmpregadorRepository extends Repository<EmpregadorModel, Long>{

	void save(EmpregadorModel pessoa);
	 
	void delete(EmpregadorModel pessoa);
 
	List<EmpregadorModel> findAll();
 
	EmpregadorModel findById(Integer id);                   
}                                                          
                                                           