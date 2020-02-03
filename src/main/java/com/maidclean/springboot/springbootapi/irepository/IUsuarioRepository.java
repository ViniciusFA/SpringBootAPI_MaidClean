package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.maidclean.springboot.springbootapi.model.Usuario;


@org.springframework.stereotype.Repository
public interface IUsuarioRepository extends Repository<Usuario, Long>, QueryByExampleExecutor<Usuario>{
		
	  void save(Usuario pessoa);
	  		 
	  void delete(Usuario usuario);
	 
	  List<Usuario> findAll();
	  
	  Usuario findByIdUsuario(Long idUsuario);
	  
	  @Query(value="SELECT * FROM tb_usuarios u JOIN tb_avaliacoes av ON (u.id_avaliacao = av.id_avaliacao)",
				 nativeQuery = true)
		 List<Object> encontrarTodosCampos();
	  	  
	  @Query(value="SELECT * FROM tb_usuarios u where u.id_role =:idRole", nativeQuery = true)
	  List<Usuario> encontrarIdRole(int idRole);
	  
	  @Query(value="SELECT * FROM tb_usuarios u where u.ds_email =:email", nativeQuery = true)
	  Usuario encontrarEmail(String email);
	 
	  @Query(value = "SELECT * FROM tb_usuarios u where u.ds_login =:login", nativeQuery = true)
	  Usuario findByLogin(String login);
	  
	  @Query(value="SELECT * FROM tb_usuarios u where u.id_usuario =:id_usuario", nativeQuery = true)
	  Usuario getRatingUser(int id_usuario);
	  
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
	  		
	  @Query(value="select id_avaliacao from tb_usuarios where id_usuario =:idUsuario",nativeQuery = true)
	  int buscaIdAvaliation(int idUsuario);
	  
}
