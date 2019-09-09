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

import com.maidclean.springboot.springbootapi.model.FuncionarioModel;
import com.maidclean.springboot.springbootapi.model.ResponseModel;
import com.maidclean.springboot.springbootapi.repository.FuncionarioRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel save(@RequestBody FuncionarioModel funcionario) {
		
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new ResponseModel(1, "Funcionário" + funcionario.getNome() 
			+ "cadastrado com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/funcionario", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody FuncionarioModel funcionario) {
		try {
			this.funcionarioRepository.save(funcionario);
			
			return new ResponseModel(1, "Funcionário" + funcionario.getNome() 
			+ "cadastrado com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="/listaFuncionarios", method = RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody  List<FuncionarioModel> consultar(){
		
		return this.funcionarioRepository.findAll();		
	}
	
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/funcionario/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody FuncionarioModel buscar(@PathVariable("codigo") Integer id_funcionario) {
		
		return this.funcionarioRepository.findById(id_funcionario);
	}
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/funcionario/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer id_funcionario) {
		
		FuncionarioModel funcionario = funcionarioRepository.findById(id_funcionario);
		
		try {
			funcionarioRepository.delete(funcionario);
			
			return new ResponseModel(1, "Funcionário" + funcionario.getNome() 
			+ "cadastrado com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
}
