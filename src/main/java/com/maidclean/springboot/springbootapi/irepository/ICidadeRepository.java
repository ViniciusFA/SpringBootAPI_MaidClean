package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Cidade;
import com.maidclean.springboot.springbootapi.model.Estado;

import java.util.List;


public interface ICidadeRepository  extends Repository<Cidade,Integer>{
	
	@Query(value="SELECT * from tb_cidades c where c.id_estado =:id_estado", nativeQuery = true)
	 List<Cidade> findById(Long id_estado);
	
	List<Cidade> findAll();

}
