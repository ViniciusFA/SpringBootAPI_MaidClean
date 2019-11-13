package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.lang.Nullable;

import com.maidclean.springboot.springbootapi.model.PesquisaTelaModel;
import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.model.Usuario;


@org.springframework.stereotype.Repository
public interface IUsuarioRepository extends Repository<Usuario, Long>, QueryByExampleExecutor<Usuario>{
		
	  void save(Usuario pessoa);
	  		 
	  void delete(Usuario usuario);
	 
	  List<Usuario> findAll();
	  
	  Usuario findByIdUsuario(Long idUsuario);
	  	  
	  List<Usuario> findByIdRole(int idRole);
	  
	  @Query(value="SELECT * FROM tb_usuarios u where u.ds_email =:email", nativeQuery = true)
	  Usuario encontrarEmail(String email);
	 
	  @Query(value = "SELECT * FROM tb_usuarios u where u.ds_login = :login", nativeQuery = true)
	  Usuario findByLogin(String login);
	  
	  @Query("SELECT u FROM Usuario u where u.login =:login and u.senha =:senha")
	  Usuario encontrarLogin(String login, String senha);
	 	  
	  @Query("Select u from Usuario u where "
	  		+ "(ds_nome is null or ds_nome = :nome) "
	  		+ "and (ds_sobrenome is null or ds_sobrenome = :sobrenome) "	
			  
	  		//+ "and 	 (u.sobrenome =:sobrenome)")
	  		)
			  List<Usuario> consultarParametro(
					  	@Param(value = "nome") String nome,
					  	@Param(value = "sobrenome") String sobrenome
					  	/*@Param(value = "estado") String estado,
			  			@Param(value = "cidade") String cidade,
			  			@Param(value = "sexo") String sexo,
			  			@Param(value = "experiencia") String experiencia,
			  			@Param(value = "idRole") int idRole*/
			  			);		
	  		
}
