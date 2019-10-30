package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
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

import springbootapi.irepositorio.usuario.IUsuarioRepositoryQuery;

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

	/*	*//**
			 * BUSCAR UMA PESSOA PELO CÓDIGO
			 * 
			 * @param codigo
			 * @return
			 */
				  @RequestMapping(value = "/usuario/{login}", params= {"login"}, method =
				  RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
				  public @ResponseBody Usuario buscar(@RequestParam("login") String login) {
				  System.out.println(login); return this.usuarioRepository.findByLogin(login);
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

			return new Response(1, "Usuário cadastrado com sucesso.", usuario.getId_role());

		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getId_role());
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

			return new Response(1, "Usuário atualizado com sucesso.", usuario.getId_role());
		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getId_role());
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
	 * @param id_role
	 * @return
	 */

	/*
	 * @RequestMapping(value = "/usuario", params= {"idRole"}, method =
	 * RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * public @ResponseBody List<Usuario>
	 * buscarUsuarioPorPerfil(@RequestParam("idRole") int idRole) { //int idRoleRef
	 * = Integer.parseInt(idRole); return
	 * this.usuarioRepository.findByIdRole(idRole); }
	 */

	@RequestMapping(value = "/usuario/listaUsuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> buscarParam(Usuario funcionario) {
		
		//Recebendo os atributos dos campos vindo do Front-End
		
		Usuario usuario = new Usuario();
		usuario.setNome(funcionario.getNome());
		Example example = Example.create(usuario).enableLike(MatchMode.ANYWHERE);
	
		
		String nome = funcionario.getNome();
		String sobrenome = funcionario.getSobrenome();
		String estado = funcionario.getEstado();
		String cidade = funcionario.getCidade();
		String experiencia = funcionario.getExperiencia();
		String sexo = funcionario.getSexo();
		
		System.out.println("\nNome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);
		System.out.println("Sexo: " + sexo);
		System.out.println("Experiência: " + experiencia);
		System.out.println("\n");
		
		List<Usuario> listaFuncionario = this.usuarioRepository.consultarParametro(nome,
																				   sobrenome,
																				   estado,
																				   cidade,
																				   sexo,
																				   experiencia);
		
		System.out.println(listaFuncionario);
		
		System.out.println("\n");
		for(int i =0;i<listaFuncionario.size();i++) {
			System.out.println("Funcionario "+ i + " : " + listaFuncionario);
		}
		System.out.println("\n");
		return listaFuncionario;
	}

	/**
	 * BUSCAR UM USUÁRIO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	
	  @RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.GET,
	  produces = MediaType.APPLICATION_JSON_UTF8_VALUE) public @ResponseBody
	  Usuario buscarById(@PathVariable("id_usuario") Long id_usuario) {
	  
	  return this.usuarioRepository.findById(id_usuario); }
	 

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
				return new Response(1, "Seja Bem-vindo.", usuario.getId_role());
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
	  public @ResponseBody Response excluir(@PathVariable("id_usuario") Long
	  id_usuario) {
	  
	  Usuario usuario = usuarioRepository.findById(id_usuario);
	  
	  try { usuarioRepository.delete(usuario);
	  
	  return new Response(1, "Registro excluído com sucesso.",
	  usuario.getId_role());
	  
	  } catch (Exception e) { return new Response(0, e.getMessage(),
	  usuario.getId_role()); } }
	 

}
