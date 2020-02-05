package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

import com.maidclean.springboot.springbootapi.model.Experiencia;
import com.maidclean.springboot.springbootapi.model.Vaga;

public interface IVagaRepository extends Repository<Vaga, Integer>, QueryByExampleExecutor<Vaga>{
	
	List<Vaga> findAll();
	
	void save(Vaga vaga);
	
	@Query(value="SELECT e.id_experiencia FROM tb_experiencia e where e.ds_tempo =:ds_tempo",nativeQuery = true)
	int buscarIdExperienciaByTempo(String ds_tempo);
	
}
