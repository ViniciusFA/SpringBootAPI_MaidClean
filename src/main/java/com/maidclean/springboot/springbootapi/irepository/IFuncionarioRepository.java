package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.maidclean.springboot.springbootapi.model.Funcionario;

public interface IFuncionarioRepository extends Repository<Funcionario, Integer>{

	void save(Funcionario pessoa);
	 
	void delete(Funcionario pessoa);
 
	List<Funcionario> findAll();
 
	Funcionario findById(Long id);	
	
	
	
	
	/*@Query(value="SELECT * FROM tb_funcionarios u where u.ds_nome = :nome "
			+ "and u.ds_sobrenome =:sobrenome "
			+ "and u.vl_estado  =:estado "
			+ "and u.ds_cidade =:cidade "
			+ "and u.vl_sexo =: sexo "
			+ "and u.ds_experiencia =:experiencia")*/
/*	List<Funcionario> findAllByParam(String nome, 
								     String sobrenome,
								     Integer estado,
								     String cidade,
								     Boolean sexo,
								     String experiencia);
*/
	
	/*
	 * @Query(value="Select f FROM Funcionario f where f.nome =:nome " +
	 * "OR f.sobrenome =:sobrenome " + "OR f.estado =:estado " +
	 * "OR f.cidade =:cidade " + "OR f.isMale =:sexo " +
	 * "OR f.experiencia =:experiencia" ) <List>Funcionario fullSearch(String nome,
	 * String sobrenome, int estado, String cidade, boolean sexo, String
	 * experiencia);
	 */
	
	
}


