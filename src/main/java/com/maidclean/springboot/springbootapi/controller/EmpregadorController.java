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

import com.maidclean.springboot.springbootapi.irepository.IEmpregadorRepository;
import com.maidclean.springboot.springbootapi.model.EmpregadorModel;
import com.maidclean.springboot.springbootapi.model.ResponseModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpregadorController {

	@Autowired
	private IEmpregadorRepository empregadorRepository;

	public EmpregadorController(IEmpregadorRepository empregadorRepository) {
		super();
		this.empregadorRepository = empregadorRepository;
	}
	
	/**
	 * SALVAR UM NOVO REGISTRO
	 * @param empregado
	 * @return
	 */
	@RequestMapping(value="/empregador", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
			, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel save(@RequestBody EmpregadorModel empregador) {
		try {
			this.empregadorRepository.save(empregador);
			
			return new ResponseModel(1, "Registro salvo com sucesso.");
		}catch(Exception e) {
			
			return new ResponseModel(0, e.getMessage());
		}
	}

	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param empregado
	 * @return
	 */
	@RequestMapping(value="empregador", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public @ResponseBody ResponseModel atualizar(@RequestBody EmpregadorModel empregador) {
		try {
			this.empregadorRepository.save(empregador);
			return new ResponseModel(1, "Registro atualizado com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
		
	}

	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="empregador", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<EmpregadorModel> consultar() {
		
			return this.empregadorRepository.findAll();	
	}
	
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/empregador/{id_empregador}", method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody EmpregadorModel buscar(@PathVariable("id_empregador") @RequestBody Integer id_empregador) {		
		   return this.empregadorRepository.findById(id_empregador);			
	}
	
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/empregador/{id_empregador}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id_empregador") @RequestBody Integer id_empregador) {
		EmpregadorModel empregador = this.empregadorRepository.findById(id_empregador);
		try {
			this.empregadorRepository.delete(empregador);
			return new ResponseModel(1, "Registro excluído com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
		
	}
}
