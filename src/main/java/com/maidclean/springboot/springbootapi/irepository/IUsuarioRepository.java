package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.lang.Nullable;

import com.maidclean.springboot.springbootapi.model.Usuario;


@org.springframework.stereotype.Repository
public interface IUsuarioRepository extends Repository<Usuario, Long>, QueryByExampleExecutor<Usuario>{
		
	  @Query(value = "SELECT * FROM tb_usuarios u where u.ds_login = :login", nativeQuery = true)
	  Usuario findByLogin(String login);	  
	  	  	  	
	  void save(Usuario pessoa);
		 
	  void delete(Usuario usuario);
	 
	  List<Usuario> findAll();
	  
	  //List<Usuario> findByIdRole(int idRole);
	 
	  Usuario findById(Long id);	
	  
		
	  @Query("SELECT u FROM Usuario u where u.login =:login and u.senha =:senha")
	  Usuario encontrarLogin(String login, String senha);
	  
	  /*@Query("SELECT u FROM Usuario u where u.idRole =:perfil AND u.nome =:nome "
				+ "OR u.nome =:nome AND u.sobrenome =:sobrenome "
				+ "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado "
				+ "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade "
				+ "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND u.sexo =:sexo "
				+ "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND u.sexo =:sexo AND u.experiencia =:experiencia")*/
	  	/*@Query("SELECT u FROM Usuario u where (1=1) " + 
	  			"AND (:nome = NULL OR u.nome =:nome) " + 
	  			"AND (:sobrenome = NULL OR u.sobrenome =:sobrenome) " + 
	  			"AND (:estado = NULL OR u.estado =:estado) " + 
	  			"AND (:cidade = NULL OR u.cidade =:cidade) " + 
	  			"AND (:sexo = NULL OR u.sexo =:sexo) " + 
	  			"AND (:experiencia = NULL OR u.experiencia =:experiencia) " + 
	  			"AND (:perfil = NULL OR u.idRole =:perfil)")*/
	  
	/*
	 * @Query("SELECT u FROM Usuario u where u.idRole =:perfil 
	 * AND u.nome =:nome " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado " +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade "
	 * +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND u.sexo =:sexo "
	 * +
	 * "OR u.nome =:nome AND u.sobrenome =:sobrenome  AND u.estado =:estado AND u.cidade =:cidade AND u.sexo =:sexo AND u.experiencia =:experiencia"
	 * )
	 */
	/*
	 * @Query("SELECT u FROM Usuario u where  " +
	 * " (:nome is null or u.nome =:nome) " +
	 * "AND (:sobrenome is null or u.sobrenome =:sobrenome) " +
	 * "AND (:estado is null or u.estado =:estado) " +
	 * "AND (:cidade is null or u.cidade =:cidade) " +
	 * "AND (:sexo is null or u.sexo =:sexo) " +
	 * "AND (:experiencia is null OR u.experiencia =:experiencia) " +
	 * "AND (:perfil is null or u.id_role =:perfil)")
	 */
	  @Query("SELECT u FROM Usuario u "
	  		+ "where (u.nome=:nome AND u.sobrenome =:sobrenome) "
	  		+ "or    (u.nome=:nome AND u.sobrenome =:sobrenome AND u.estado =:estado) " 
	  		+ "or    (u.nome=:nome AND u.sobrenome =:sobrenome AND u.estado =:estado AND u.cidade =:cidade) " 
	  		+ "or    (u.nome=:nome AND u.sobrenome =:sobrenome AND u.estado =:estado AND u.cidade =:cidade "
	  		+ "						AND u.sexo =:sexo)" 
	  		+ "or    (u.nome=:nome AND u.sobrenome =:sobrenome AND u.estado =:estado AND u.cidade =:cidade "
	  		+ "						AND u.sexo =:sexo AND u.experiencia =:experiencia)" 
	  		
	  		
			  
			  )
		  List<Usuario> consultarParametro(
				  	@Param(value = "nome") String nome,
				  	@Param(value = "sobrenome") String sobrenome,
		  			@Param(value = "estado") String estado,
		  			@Param(value = "cidade") String cidade,
		  			@Param(value = "sexo") String sexo,
		  			@Param(value = "experiencia") String experiencia);					
				
	  	
	  		
}
