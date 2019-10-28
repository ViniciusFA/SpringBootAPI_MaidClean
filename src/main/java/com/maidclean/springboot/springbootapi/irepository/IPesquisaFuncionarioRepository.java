package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.maidclean.springboot.springbootapi.model.Funcionario;

public interface IPesquisaFuncionarioRepository extends Repository<Funcionario,Integer>, JpaSpecificationExecutor<Funcionario>{

	@Query("SELECT f FROM Funcionario f where f.nome =:nome "
			+ "OR f.nome =:nome AND f.sobrenome =:sobrenome "
			+ "OR f.nome =:nome AND f.sobrenome =:sobrenome  AND f.estado =:estado "
			+ "OR f.nome =:nome AND f.sobrenome =:sobrenome  AND f.estado =:estado AND f.cidade =:cidade "
			+ "OR f.nome =:nome AND f.sobrenome =:sobrenome  AND f.estado =:estado AND f.cidade =:cidade AND f.sexo =:sexo "
			+ "OR f.nome =:nome AND f.sobrenome =:sobrenome  AND f.estado =:estado AND f.cidade =:cidade AND f.sexo =:sexo AND f.experiencia =:experiencia")
	List<Funcionario> consultarParametro(
			@Param(value = "nome") String nome, 
			@Param(value = "sobrenome") String sobrenome,
			@Param(value = "estado") String estado,
			@Param(value = "cidade") String cidade,
			@Param(value = "sexo") String sexo,
			@Param(value = "experiencia") String experiencia);
	
}
