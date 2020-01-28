package com.maidclean.springboot.springbootapi.controller;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.maidclean.springboot.springbootapi.model.Contato;
import com.maidclean.springboot.springbootapi.model.Response;

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
	 * 
	 * @param contato
	 * @return
	 */

	@RequestMapping(value = "/contato", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response save(@RequestBody Contato contato) {
		try {

			// DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			contato.setDataContato(new Date());

			this.contatoRepository.save(contato);
			return new Response(1, "Mensagem enviada com sucesso.\n Em breve entraremos em contato.");
		} catch (Exception e) {
			return new Response(0, e.getMessage());
		}
	}

	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * 
	 * @return
	 */

	@RequestMapping(value = "/contato", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Contato> consultar() {
		return this.contatoRepository.findAll();
	}

	/**
	 * BUSCAR UM CONTATO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */

	@RequestMapping(value = "/contato/{id_contato}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Contato buscar(@PathVariable("id_contato") @RequestBody Integer id_contato) {
		return this.contatoRepository.findById(id_contato);
	}

	/***
	 * EXCLUIR UM CONTATO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/contato/{id_contato}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("id_contato") @RequestBody Integer id_contato) {
		Contato contato = this.contatoRepository.findById(id_contato);
		try {
			this.contatoRepository.delete(contato);
			return new Response(1, "Registro excluído com sucesso.");
		} catch (Exception e) {
			return new Response(0, e.getMessage());
		}

	}

}
