package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Estado;

public interface IEstadoRepository extends Repository<Estado,Integer> {

	List<Estado> findAll();
	
	@Query(value="SELECT e.nome_estado, c.nome_cidade FROM tb_estados e join tb_cidades c ON"
			+ "(e.id_estado = c.id_estado) where e.id_estado =:id_estado and c.id_cidade =:id_cidade", 
				nativeQuery = true)
	String getStateAndCityNames(int id_estado, int id_cidade);
	
	
	
	
}
