package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IFuncionarioRepository;
import com.maidclean.springboot.springbootapi.irepository.IPesquisaFuncionarioRepository;
import com.maidclean.springboot.springbootapi.model.Funcionario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PesquisaController {

	@Autowired
	private IFuncionarioRepository funcionarioRepository;

	public PesquisaController(IFuncionarioRepository funcionarioRepository) {
		super();
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	
}
