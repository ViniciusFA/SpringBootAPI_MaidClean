package com.maidclean.springboot.springbootapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{nome}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("nome") String nome) {
				
		return this.usuarioRepository.findByLogin(nome);
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

			return new Response(1, "Usuário cadastrado com sucesso.",usuario.getId_role());

		} catch (Exception e) {
			return new Response(0, e.getMessage(),usuario.getId_role());
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
			return new Response(0, e.getMessage(),usuario.getId_role());
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
	 * BUSCAR UM USUÁRIO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("id_usuario") Long id_usuario) {

		return this.usuarioRepository.findById(id_usuario);
	}
	
	/**
	 * BUSCAR UM USUÁRIO PELO USUÁRIO E SENHA
	 * 
	 * @param login and senha
	 * @return
	 */
	@RequestMapping(value="/usuario/{login}/{senha}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public @ResponseBody Response login(@PathVariable("login") String login,
			 							 @PathVariable("senha") String senha){
		try {
			 usuario = this.usuarioRepository.encontrarLogin(login,senha);
			 if(usuario != null ) {
				 System.out.println(usuario);
				 return new Response(1, "Seja Bem-vindo.",usuario.getId_role());
			 } else {
				 System.out.println(usuario);
				 return new Response(0, "Usuário não encontrado", 0);
			 }			 
		} catch(Exception e) {
			 return new Response(0, e.getMessage(), 0); 
		} 		 
	 }
	
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("id_usuario") Long id_usuario) {

		Usuario usuario = usuarioRepository.findById(id_usuario);

		try {
			usuarioRepository.delete(usuario);

			return new Response(1, "Registro excluído com sucesso.", usuario.getId_role());

		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getId_role());
		}
	}

	
}
