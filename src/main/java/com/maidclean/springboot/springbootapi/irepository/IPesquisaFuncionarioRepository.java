package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.maidclean.springboot.springbootapi.model.Usuario;


public interface IPesquisaFuncionarioRepository extends Repository<Usuario,Integer>, JpaSpecificationExecutor<Usuario>{

	/*
	 * @Query("SELECT u FROM Usuario u where u.nome =:nome " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade "
	 * +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND u.sexo =:sexo "
	 * +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND fu.sexo =:sexo AND u.experiencia =:experiencia"
	 * ) List<Usuario> consultarParametro(
	 * 
	 * @Param(value = "nome") String nome,
	 * 
	 * @Param(value = "sobrenome") String sobrenome,
	 * 
	 * @Param(value = "estado") String estado,
	 * 
	 * @Param(value = "cidade") String cidade,
	 * 
	 * @Param(value = "sexo") String sexo,
	 * 
	 * @Param(value = "experiencia") String experiencia);
	 */
	
}
