package com.maidclean.springboot.springbootapi.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.domain.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.Funcionario;
import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.model.Usuario;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	private Usuario usuario = null;
	@Autowired
	private IUsuarioRepository usuarioRepository;

	
	public UsuarioController(IUsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

			/**
			 * BUSCAR UMA PESSOA PELO CÓDIGO
			 * 
			 * @param codigo
			 * @return
			 */
	@RequestMapping(value = "/usuario/{login}", params= {"login"}, method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@RequestParam("login") String login) {
		System.out.println(login); 
	return this.usuarioRepository.findByLogin(login);
	 }
				 

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param usuário
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response save(@RequestBody Usuario usuario) {
		try {
			this.usuarioRepository.save(usuario);
			return new Response(1, "Usuário cadastrado com sucesso.", usuario.getIdRole());
		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getIdRole());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UM USUÁRIO
	 * 
	 * @param usuário
	 * @return
	 */
	@RequestMapping(value = "/funcionario", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response atualizar(@RequestBody Usuario usuario) {
		try {
			this.usuarioRepository.save(usuario);

			return new Response(1, "Usuário atualizado com sucesso.", usuario.getIdRole());
		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getIdRole());
		}
	}

	/**
	 * CONSULTAR TODAS OS USUÁRIOS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultar() {

		return this.usuarioRepository.findAll();
	}

	/**
	 * BUSCAR UM USUÁRIO PELO PERFIL
	 * 
	 * @param idRole
	 * @return
	 */	
	  @RequestMapping(value = "/usuario", params= {"idRole"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public @ResponseBody List<Usuario> buscarUsuarioPorPerfil(@RequestParam("idRole") int idRole) { 
	  
		 Usuario usuario = new Usuario();
		 usuario.setIdRole(idRole);
	  return this.usuarioRepository.findByIdRole(usuario.getIdRole()); 
	  }
	 

	/**
	* BUSCAR UM USUÁRIO COM PARAMETROS DINÂMICOS
	* 
	* @param usuario
	* @return
	*/	 
	@RequestMapping(value = "/usuario/listaUsuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Iterable<Usuario> buscarParam(Usuario usuario) {
			
		usuario.setIdRole(2);	
		
		//mostra conteudo dos parametros na tela.		
		System.out.println("\nNome: " + usuario.getNome());
		System.out.println("Sobrenome: " + usuario.getSobrenome());
		System.out.println("Estado: " + usuario.getEstado());
		System.out.println("Cidade: " + usuario.getCidade());		
		System.out.println("Experiência: " + usuario.getExperiencia());
		System.out.println("Sexo: " + usuario.getSexo());
		System.out.println("Id_Role: " + usuario.getIdRole());
		System.out.println("\n");
		
		Example<Usuario> usuarioExample = Example.of(usuario, ExampleMatcher.matchingAll()
											 			   .withIgnoreNullValues());
				
		//lista que receberá todos os usuarios encontrados no banco
		 Iterable<Usuario> listaFuncionario =  this.usuarioRepository.findAll(usuarioExample);
			
		 //iteração para mostrar a lista de funcionarios encontrados no banco
		 for (Usuario u : listaFuncionario) {
	          System.out.println("\n"+u);
	      }
		 
		System.out.println(listaFuncionario);
		
		return listaFuncionario;
	}

	/**
	 * BUSCAR UM USUÁRIO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */	
	  @RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE) public @ResponseBody
	  Usuario buscarById(@PathVariable("id_usuario") Long id_usuario) {	  
	  return this.usuarioRepository.findByIdUsuario(id_usuario); 
	  }
	 

	/**
	 * BUSCAR UM USUÁRIO PELO USUÁRIO E SENHA
	 * 
	 * @param login and senha
	 * @return
	 */
	@RequestMapping(value = "/usuario/{login}/{senha}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response login(@PathVariable("login") String login, 
										@PathVariable("senha") String senha) {
		try {
			usuario = this.usuarioRepository.encontrarLogin(login, senha);
			if (usuario != null) {				
				return new Response(1, "Seja Bem-vindo.", usuario.getIdRole());
			} else {
				System.out.println(usuario);
				return new Response(0, "Usuário não encontrado", 0);
			}
		} catch (Exception e) {
			return new Response(0, e.getMessage(), 0);
		}
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */	
	  @RequestMapping(value = "/usuario/{id_usuario}", method =
	  RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	  public @ResponseBody Response excluir(@PathVariable("id_usuario") Long id_usuario) {
	  
	  Usuario usuario = usuarioRepository.findByIdUsuario(id_usuario);	  
	  try { usuarioRepository.delete(usuario);	  
	  return new Response(1, "Registro excluído com sucesso.", usuario.getIdRole());
	  
	  } catch (Exception e) { 
		  return new Response(0, e.getMessage(),usuario.getIdRole()); 
	  	}
	  }
	 

}
