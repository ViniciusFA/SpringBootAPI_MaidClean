package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IExperienciaRepository;
import com.maidclean.springboot.springbootapi.model.Experiencia;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ExperienciaController {
	
	@Autowired
	private IExperienciaRepository experienciaRepository;

	public ExperienciaController(IExperienciaRepository experienciaRepository) {
		super();
		this.experienciaRepository = experienciaRepository;
	}
	
	@RequestMapping(value="/experiencia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Experiencia> getAllExperiences(){
		
		return experienciaRepository.findAll();		
	}
	
}
