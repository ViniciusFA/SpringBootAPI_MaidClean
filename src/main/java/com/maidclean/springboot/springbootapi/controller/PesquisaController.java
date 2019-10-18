package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IFuncionarioRepository;
import com.maidclean.springboot.springbootapi.irepository.IPesquisaFuncionarioRepository;
import com.maidclean.springboot.springbootapi.model.Funcionario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PesquisaController {

	@Autowired
	private IPesquisaFuncionarioRepository pesquisaFuncionarioRepository;

	public PesquisaController(IPesquisaFuncionarioRepository pesquisaFuncionarioRepository) {
		super();
		this.pesquisaFuncionarioRepository = pesquisaFuncionarioRepository;
	}
	
	@RequestMapping(value = "/funcionario/listaFuncionarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Funcionario> buscarParam(Funcionario funcionario) {
		//Recebendo os atributos dos campos vindo do Front-End
		String nome = funcionario.getNome();
		String sobrenome = funcionario.getSobrenome();
		String estado = funcionario.getEstado();
		String cidade = funcionario.getCidade();
		String sexo = funcionario.getSexo();
		String experiencia = funcionario.getExperiencia();
		
		System.out.println("\nNome: " + nome);
		System.out.println("Sobrenome: " + sobrenome);
		System.out.println("Estado: " + estado);
		System.out.println("Cidade: " + cidade);
		System.out.println("Sexo: " + sexo);
		System.out.println("Experiência: " + experiencia);
		System.out.println("\n");
		
		List<Funcionario> listaFuncionario = this.pesquisaFuncionarioRepository.consultarParametro(
				nome, 
				sobrenome, 
				estado, 
				cidade, 
				sexo, 
				experiencia
				);
		
		System.out.println("\n");
		for(int i =0;i<listaFuncionario.size();i++) {
			System.out.println("Funcionario "+ i + " : " + listaFuncionario);
		}
		System.out.println("\n");
		return listaFuncionario;
	}
	
	
}
