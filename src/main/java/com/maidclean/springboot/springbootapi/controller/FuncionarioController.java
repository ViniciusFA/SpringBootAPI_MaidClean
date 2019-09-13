package com.maidclean.springboot.springbootapi.controller;

import java.sql.SQLDataException;
import java.sql.SQLException;
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

import com.maidclean.springboot.springbootapi.model.FuncionarioModel;
import com.maidclean.springboot.springbootapi.model.ResponseModel;
import com.maidclean.springboot.springbootapi.repository.FuncionarioRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param funcionario
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
			, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel save(@RequestBody FuncionarioModel funcionario) {
		
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new ResponseModel(1, "Registro salvo com sucesso.");
			
		}catch(Exception e) {				
			return new ResponseModel(0, e.getMessage() );
		}
		
	}
	
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param funcionario
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody FuncionarioModel funcionario) {
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new ResponseModel(1, "Registro atualizado com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="/funcionario", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  List<FuncionarioModel> consultar(){	
		
		
		return this.funcionarioRepository.findAll();		
	}
	
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/funcionario/{id_funcionario}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody FuncionarioModel buscar(@PathVariable("id_funcionario") Integer id_funcionario) {
		
		
		
		return this.funcionarioRepository.findById(id_funcionario);
	}
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/funcionario/{id_funcionario}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id_funcionario") Integer id_funcionario) {
		
		FuncionarioModel funcionario = funcionarioRepository.findById(id_funcionario);
		
		try {
			funcionarioRepository.delete(funcionario);
			
			return new ResponseModel(1, "Registro excluído com sucesso.");
			
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
}
