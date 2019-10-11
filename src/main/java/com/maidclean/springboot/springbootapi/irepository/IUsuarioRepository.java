package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maidclean.springboot.springbootapi.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	  //Usuario findById(Integer id);
	
	  @Query(value = "SELECT * FROM tb_usuarios u where u.ds_login = :login", nativeQuery = true)
	  Usuario findByLogin(String login);	  
	  
	  List<Usuario> findAll();
	  
	  void delete(Usuario usuario);
	  	
	  
}
