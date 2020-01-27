package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Experiencia;

@org.springframework.stereotype.Repository
public interface IExperienciaRepository extends Repository<Experiencia, Long>{
	
	List<Experiencia> findAll();
	
	@Query(value="SELECT id_experiencia FROM tb_experiencia where ds_tempo =:tempo",nativeQuery = true)
	int buscarIdPeloNome(String tempo);

}
