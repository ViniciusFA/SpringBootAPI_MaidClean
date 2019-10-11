package com.maidclean.springboot.springbootapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
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
	@RequestMapping(value = "/usuario/{nm_usuario}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("nm_usuario") String nm_usuario) {
				
		return this.usuarioRepository.findByLogin(nm_usuario);
	}
	

	
}
