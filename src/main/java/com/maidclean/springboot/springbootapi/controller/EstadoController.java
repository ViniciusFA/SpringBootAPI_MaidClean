package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.ICidadeRepository;
import com.maidclean.springboot.springbootapi.irepository.IEstadoRepository;
import com.maidclean.springboot.springbootapi.model.Estado;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstadoController {

	@Autowired
	private IEstadoRepository estadoRepository;
	
	@RequestMapping(value = "/localidade/estados", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Estado> buscarById(){
		return this.estadoRepository.findAll();
	}
	
	
	
}
