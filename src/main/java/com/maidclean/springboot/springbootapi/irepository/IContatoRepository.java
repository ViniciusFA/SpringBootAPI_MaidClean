package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.ContatoModel;

public interface IContatoRepository extends Repository<ContatoModel, Long>{

	void save(ContatoModel contato);
	
	void delete(ContatoModel pessoa);
	 
	List<ContatoModel> findAll();
 
	ContatoModel findById(Integer id);
	
}
