package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

import com.maidclean.springboot.springbootapi.model.Vaga;

public interface IVagaRepository extends Repository<Vaga, Integer>, QueryByExampleExecutor<Vaga>{
	
	List<Vaga> findAll();
	
	void save(Vaga vaga);
	
}
