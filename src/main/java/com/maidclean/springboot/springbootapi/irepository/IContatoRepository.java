package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Contato;

public interface IContatoRepository extends Repository<Contato, Long>{

	void save(Contato contato);
	
	void delete(Contato pessoa);
	 
	List<Contato> findAll();
 
	Contato findById(Integer id);
	
}
