package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maidclean.springboot.springbootapi.model.Funcionario;
import com.maidclean.springboot.springbootapi.model.Usuario;

public interface IUsuarioRepository extends Repository<Usuario, Long>{
		
	  @Query(value = "SELECT * FROM tb_usuarios u where u.ds_login = :login", nativeQuery = true)
	  Usuario findByLogin(String login);	  
	  	  	  	
	    void save(Usuario pessoa);
		 
		void delete(Usuario usuario);
	 
		List<Usuario> findAll();
	 
		Usuario findById(Long id);
		
		@Query("SELECT u FROM Usuario u where u.nm_usuario =:login and u.senha =:senha")
		Usuario encontrarLogin(String login, String senha);
	  
}
