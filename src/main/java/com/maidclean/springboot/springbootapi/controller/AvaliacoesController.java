package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IAvaliacoesRepository;
import com.maidclean.springboot.springbootapi.model.Avaliacoes;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AvaliacoesController {

	private Avaliacoes avaliacoes = null;
	@Autowired
	private IAvaliacoesRepository avaliacoesRepository;

	public AvaliacoesController(IAvaliacoesRepository avaliacoesRepository) {
		super();
		this.avaliacoesRepository = avaliacoesRepository;
	}

	/**
	 * BUSCAR AVALIACOES PELO ID DO USUÁRIO
	 * 
	 * @param id_usuario
	 * @return
	 */
	@RequestMapping(value = "/avaliacoes/{id_usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Avaliacoes getRatingUser(@PathVariable("id_usuario") int id_usuario) {

		avaliacoes = avaliacoesRepository.getRatingUser(id_usuario);

		if (avaliacoes != null) {
			return avaliacoes;
		} else {
			return new Avaliacoes();
		}
	}
}
