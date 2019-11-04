package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IVagaRepository;
import com.maidclean.springboot.springbootapi.model.Funcionario;
import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.model.Vaga;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VagaController {

	@Autowired
	private IVagaRepository vagaRepository;
	
	
	/**
	 * CONSULTAR TODAS AS VAGAS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/vagas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Vaga> consultar() {
	
		return this.vagaRepository.findAll();
	}
	
	/**
	 * SALVAR UMA VAGA
	 * 
	 * @return
	 */
	@RequestMapping(value = "/vagas", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response save(@RequestBody Vaga vaga) {
		System.out.println(vaga);
		try {
			this.vagaRepository.save(vaga);
			return new Response(1,"Vaga Registrada com sucesso.");
		}catch(Exception e ) {
			return new Response(0, e.getMessage());			
		} 
	}
	
}
