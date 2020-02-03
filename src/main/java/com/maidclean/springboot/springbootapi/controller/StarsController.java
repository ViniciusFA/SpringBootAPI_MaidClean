package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IStarsRepository;
import com.maidclean.springboot.springbootapi.model.Estrelas;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StarsController {
	
	@Autowired
	private IStarsRepository starRepository;

	public StarsController(IStarsRepository starRepository) {
		super();
		this.starRepository = starRepository;
	}

	@RequestMapping(value="/estrelas", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Estrelas> getStars(){
		return starRepository.findAll();
	}
	
}
