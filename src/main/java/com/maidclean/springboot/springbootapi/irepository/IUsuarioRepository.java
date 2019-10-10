package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maidclean.springboot.springbootapi.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	  Usuario findById(Integer id);
	
	  @Query(value = "SELECT u.login FROM Usuario u where u.login = :login", nativeQuery = true)
	  Usuario findByLogin(@Param("login") String login);	  
	  
	  List<Usuario> findAll();
	  
	  void delete(Usuario usuario);
	  	
}
