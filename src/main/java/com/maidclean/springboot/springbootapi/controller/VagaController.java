package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.ICidadeRepository;
import com.maidclean.springboot.springbootapi.irepository.IEstadoRepository;
import com.maidclean.springboot.springbootapi.irepository.IExperienciaRepository;
import com.maidclean.springboot.springbootapi.irepository.IVagaRepository;
import com.maidclean.springboot.springbootapi.model.Cidade;
import com.maidclean.springboot.springbootapi.model.Estado;
import com.maidclean.springboot.springbootapi.model.Experiencia;
import com.maidclean.springboot.springbootapi.model.PesquisaVaga;
import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.model.Usuario;
import com.maidclean.springboot.springbootapi.model.Vaga;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VagaController {

	@Autowired
	private IVagaRepository vagaRepository;
		
	@Autowired
	private IEstadoRepository estadoRepository;
	
	@Autowired
	private IExperienciaRepository experienciaRepository;
	
	@Autowired
	private ICidadeRepository cidadeRepository;
	
	
	/**
	 * CONSULTAR TODAS AS VAGAS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/vagas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Vaga> consultar() {
	
		//get to name in tb_usuarios with foreign key id_usuario		
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
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(Long.parseLong(vaga.getIdEmpregador()));
		
		vaga.setIdUsuario(usuario);
		try {
			int id_estado = Integer.parseInt(vaga.getEstado().getNome_estado());
			int id_cidade = Integer.parseInt(vaga.getCidade().getNome_cidade());
			String cityAndState = "";

			cityAndState = estadoRepository.getStateAndCityNames(id_estado, id_cidade);

			String[] listCityAndState = cityAndState.split(",", 3);
			vaga.getEstado().setNome_estado(listCityAndState[0]);
			vaga.getCidade().setNome_cidade(listCityAndState[2]);
			this.vagaRepository.save(vaga);
			
			return new Response(1, "Vaga Registrada com sucesso.");
		} catch (Exception e) {
			return new Response(0, e.getMessage());
		}
	}
	

	/**
	* BUSCAR UMA VAGA COM PARAMETROS DINÂMICOS
	* 
	* @param vaga
	* @return
	*/	 
	@RequestMapping(value="/vagas/listaVagas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Iterable<Vaga> pesquisarVaga(PesquisaVaga camposPesquisa){
	
		Vaga vaga = new Vaga();
		Estado estado = new Estado();
		Cidade cidade = new Cidade();	
		Experiencia experiencia = new Experiencia();
		int id_estado = 0;
		
		if(camposPesquisa.getTitulo().isEmpty() || camposPesquisa.getTitulo() == "") 
			vaga.setTitulo(null);
		else
			vaga.setTitulo(camposPesquisa.getTitulo());
		
		if(camposPesquisa.getSubtitulo().isEmpty() || camposPesquisa.getSubtitulo() == "") 
			vaga.setSubtitulo(null);	
		else
			vaga.setSubtitulo(camposPesquisa.getSubtitulo());
		
		if(camposPesquisa.getExperiencia().isEmpty() || camposPesquisa.getExperiencia() == "")
			vaga.setExperiencia(null);
		else {
			int id_experiencia = experienciaRepository.buscarIdExperienciaByTempo(camposPesquisa.getExperiencia());			
			experiencia.setIdExperiencia(id_experiencia);
			experiencia.setTempo(camposPesquisa.getExperiencia());
			vaga.setExperiencia(experiencia);
		}
		
		if(camposPesquisa.getEstado().isEmpty() || camposPesquisa.getEstado() == "")
			vaga.setEstado(null);
		else {
			id_estado = Integer.parseInt(camposPesquisa.getEstado());
			estado.setId_estado(id_estado);
			vaga.setEstado(estado);
		}
		
		if(camposPesquisa.getCidade().isEmpty() || camposPesquisa.getCidade() == "")
			vaga.setCidade(null);
		else {
			int id_cidade = cidadeRepository.buscaCidadeByName(camposPesquisa.getCidade());
			cidade.setId_cidade(id_cidade);
			vaga.setCidade(cidade);
		}
		
		Example<Vaga> vagaExample = Example.of(vaga, ExampleMatcher.matchingAll()
													.withIgnoreNullValues()
													.withIgnorePaths("id_vaga")
													.withIgnoreNullValues());
		
		Iterable<Vaga> retornoVagas = this.vagaRepository.findAll(vagaExample);
		
		//iteração para mostrar a lista de funcionarios encontrados no banco
		 for (Vaga v : retornoVagas) {
			 System.out.println("\nUsuário encontrado:");
	          System.out.println(""+ v +"\n");
	      }		
		
		return retornoVagas;
	}
	
}
