package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IAvaliacoesRepository;
import com.maidclean.springboot.springbootapi.irepository.IStarsRepository;
import com.maidclean.springboot.springbootapi.model.Avaliacoes;
import com.maidclean.springboot.springbootapi.model.Estrelas;
import com.maidclean.springboot.springbootapi.model.Usuario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AvaliacoesController {

	@Autowired
	private IAvaliacoesRepository avaliacoesRepository;
		
	private List<Avaliacoes> listaAvaliacoes = new ArrayList<>();
	private Avaliacoes avaliacoes = null;
	Estrelas stars = new Estrelas();
	

	public AvaliacoesController(IAvaliacoesRepository avaliacoesRepository) {
		super();
		this.avaliacoesRepository = avaliacoesRepository;
	}

	/**
	 * BUSCAR TODAS AS AVALIACOES
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/avaliacoes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Avaliacoes> getAllAvaliations() {
		this.listaAvaliacoes = avaliacoesRepository.findAll();
		return this.listaAvaliacoes;
	}

	/**
	 * BUSCAR AVALIACOES PELO ID DO USUÁRIO
	 * 
	 * @param id_usuario
	 * @return
	 */
	@RequestMapping(value = "/avaliacoes/{id_usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Avaliacoes getRatingUser(@PathVariable("id_usuario") int id_usuario) {

		avaliacoes = avaliacoesRepository.getRatingUser(id_usuario);

		if (avaliacoes != null) {
			return avaliacoes;
		} else {
			return new Avaliacoes();
		}
	}

	/**
	 * CALCULAR A MÉDIA DE ACORDO COM AS AVALIACOES
	 * 
	 * @param id_usuario
	 * @return
	 */
	@RequestMapping(value = "/avaliacoes/media", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody HashMap<Long, Double> getAverageAvaliations() {

		Avaliacoes avaliacoes = new Avaliacoes();
		double media = 0.0;
		double mediaArredondada = 0.0;
		long idAvaliacao = 0;
		int starsResult = 0;
		BigDecimal bd;

		Usuario user = new Usuario();

		HashMap<Long, Double> mapAvaliation = new HashMap<Long, Double>();

		for (Avaliacoes av : this.listaAvaliacoes) {
			idAvaliacao = av.getIdAvaliacao();	
			media = (av.getCompromisso() + av.getLimpeza() + av.getOrganizacao() + av.getDisciplina()) / 4;	
			bd = new BigDecimal(media).setScale(2, RoundingMode.HALF_EVEN);	
			//getting the value of BigDecimal and converting it in double
			mediaArredondada = bd.doubleValue();
			//adding idAvaliation and Avarage ub HashMap
			mapAvaliation.put(av.getIdAvaliacao(), mediaArredondada);	
			//getting the avaliation through id
			avaliacoes = this.avaliacoesRepository.findByIdAvaliacao(idAvaliacao);				
			
			
			//starsResult = this.showStars(mediaArredondada);
			starsResult = this.getIdStar(mediaArredondada);
			
			//set star and average in Object Avaliacoes;
			avaliacoes.setMediaAvaliacao(mediaArredondada);
			//saving update in dataBase
			this.avaliacoesRepository.save(avaliacoes);			
		}
		return mapAvaliation;
	}

	//show stars in the view using this result
	public int getIdStar(double media) {
	
		if (media < 1.0)
			this.stars.setId_star(1);
			//this.stars = 0;		
		else if (media >= 1 && media < 3)
			this.stars.setId_star(2);
			//this.stars = 1;
		else if (media >= 3 && media < 5)
			this.stars.setId_star(3);
			//this.stars = 2;
		else if (media >= 5 && media < 7)
			this.stars.setId_star(4);
			//this.stars = 3;
		else if (media >= 7 && media < 9)
			this.stars.setId_star(5);
			//this.stars = 4;
		else
			this.stars.setId_star(6);
			//this.stars = 5;		

		return this.stars.getId_star();
	}

	
	
}
