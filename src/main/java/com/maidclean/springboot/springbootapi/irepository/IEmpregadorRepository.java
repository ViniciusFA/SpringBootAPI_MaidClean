package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Empregador;

public interface IEmpregadorRepository extends Repository<Empregador, Long>{

	void save(Empregador pessoa);
	 
	void delete(Empregador pessoa);
 
	List<Empregador> findAll();
 
	Empregador findById(Long id);                  
}                                                          
                                                           