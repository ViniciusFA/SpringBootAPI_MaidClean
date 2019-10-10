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

import com.maidclean.springboot.springbootapi.irepository.IFuncionarioRepository;
import com.maidclean.springboot.springbootapi.model.Funcionario;
import com.maidclean.springboot.springbootapi.model.Response;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FuncionarioController {

	@Autowired
	private IFuncionarioRepository funcionarioRepository;
	
	public FuncionarioController(IFuncionarioRepository funcionarioRepository) {
		super();
		this.funcionarioRepository = funcionarioRepository;
	}

	
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param funcionario
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
			, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response save(@RequestBody Funcionario funcionario) {
		
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new Response(1, "Registro salvo com sucesso.");
			
		}catch(Exception e) {				
			return new Response(0, e.getMessage() );
		}
		
	}
	
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param funcionario
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response atualizar(@RequestBody Funcionario funcionario) {
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new Response(1, "Registro atualizado com sucesso.");
		}catch(Exception e) {
			return new Response(0, e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="/funcionario", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  List<Funcionario> consultar(){	
		
		
		return this.funcionarioRepository.findAll();		
	}
	
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/funcionario/{id_funcionario}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Funcionario buscar(@PathVariable("id_funcionario") Integer id_funcionario) {
				
		return this.funcionarioRepository.findById(id_funcionario);
	}
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/funcionario/{id_funcionario}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("id_funcionario") Integer id_funcionario) {
		
		Funcionario funcionario = funcionarioRepository.findById(id_funcionario);
		
		try {
			funcionarioRepository.delete(funcionario);
			
			return new Response(1, "Registro excluído com sucesso.");
			
		}catch(Exception e) {
			return new Response(0, e.getMessage());
		}
	}
	
}
