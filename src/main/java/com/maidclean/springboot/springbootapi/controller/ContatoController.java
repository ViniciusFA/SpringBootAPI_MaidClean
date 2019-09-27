package com.maidclean.springboot.springbootapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

import com.maidclean.springboot.springbootapi.irepository.IContatoRepository;
import com.maidclean.springboot.springbootapi.model.ContatoModel;
import com.maidclean.springboot.springbootapi.model.EmpregadorModel;
import com.maidclean.springboot.springbootapi.model.ResponseModel;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContatoController {

	@Autowired
	private IContatoRepository contatoRepository;

	public ContatoController(IContatoRepository contatoRepository) {
		super();
		this.contatoRepository = contatoRepository;
	}
	

	/**
	 * SALVAR UMA NOVA MENSAGEM
	 * @param contato
	 * @return
	 */
	@RequestMapping(value="/contato", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
			, produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public @ResponseBody ResponseModel save(@RequestBody ContatoModel contato) {
		try {
						
			DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 			
			contato.setDataContato(new Date());
			
			
			this.contatoRepository.save(contato);
			return new ResponseModel(1, "Mensagem enviada com sucesso. Em breve entraremos em contato.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
	
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */	
	@RequestMapping(value="/contato", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<ContatoModel> consultar() {
		
			return this.contatoRepository.findAll();
	}
	
	/**
	 * BUSCAR UM CONTATO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/contato/{id_contato}", method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ContatoModel buscar(@PathVariable("id_contato") @RequestBody Integer id_contato) {		
		   return this.contatoRepository.findById(id_contato);			
	}
	
	/***
	 * EXCLUIR UM CONTATO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/contato/{id_contato}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id_contato") @RequestBody Integer id_contato) {
		ContatoModel contato = this.contatoRepository.findById(id_contato);
		try {
			this.contatoRepository.delete(contato);
			return new ResponseModel(1, "Registro excluído com sucesso.");
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
		
	}
}
	
