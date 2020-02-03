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

import com.maidclean.springboot.springbootapi.irepository.ICidadeRepository;
import com.maidclean.springboot.springbootapi.model.Cidade;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CidadeController {
	
	@Autowired
	private ICidadeRepository cidadeRepository;
	
	@RequestMapping(value = "/localidade/cidades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Cidade> buscarCidades(){
		return this.cidadeRepository.findAll();
	}

	@RequestMapping(value = "/localidade/cidades/{id_estado}",  method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Cidade> buscarById(@PathVariable("id_estado") Long id_estado) {
		return this.cidadeRepository.findById(id_estado);
	}

}
