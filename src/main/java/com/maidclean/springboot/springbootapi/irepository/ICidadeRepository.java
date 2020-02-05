package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Cidade;

import java.util.List;


public interface ICidadeRepository  extends Repository<Cidade,Integer>{
	
	List<Cidade> findAll();
	
	@Query(value="SELECT * from tb_cidades c where c.id_estado =:id_estado", nativeQuery = true)
	 List<Cidade> findById(Long id_estado);	

	@Query(value="SELECT id_cidade from tb_cidades c where c.nome_cidade =:ds_cidade", nativeQuery = true)
	int buscaCidadeByName(String ds_cidade);
}
