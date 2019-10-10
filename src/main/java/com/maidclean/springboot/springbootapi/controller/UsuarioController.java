package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public UsuarioController(IUsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="/usuario", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  List<Usuario> consultar(){	
				
		return this.usuarioRepository.findAll();		
	}
	
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("id_usuario") Integer id_usuario) {
				
		return this.usuarioRepository.findById(id_usuario);
	}
	
	/**
	 * LOGAR UM USUÁRIO
	 * @param funcionario
	 * @return
	 */
	@RequestMapping(value="/usuario", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
			, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response Logar(@RequestBody Usuario usuario) {
		
		try {
			
			String login = usuario.getLogin();			
			System.out.println("nome do usuario: " + usuario.getLogin());
			this.usuarioRepository.findByLogin(login);
			
			return new Response(1, "Usuário " + login +  " encontrado com sucesso.");
			
		}catch(Exception e) {				
			return new Response(0, e.getMessage() );
		}
		
	}


	
}
