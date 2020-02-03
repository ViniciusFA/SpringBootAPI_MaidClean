package com.maidclean.springboot.springbootapi.controller;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IAvaliacoesRepository;
import com.maidclean.springboot.springbootapi.irepository.IEstadoRepository;
import com.maidclean.springboot.springbootapi.irepository.IExperienciaRepository;
import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.Avaliacoes;
import com.maidclean.springboot.springbootapi.model.Cidade;
import com.maidclean.springboot.springbootapi.model.Estado;
import com.maidclean.springboot.springbootapi.model.Estrelas;
import com.maidclean.springboot.springbootapi.model.Experiencia;
import com.maidclean.springboot.springbootapi.model.PesquisaFuncionario;
import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.model.Role;
import com.maidclean.springboot.springbootapi.model.Usuario;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {

	private Usuario usuario = null;
	@Autowired
	private IUsuarioRepository usuarioRepository;
	@Autowired
	private IAvaliacoesRepository avaliacoesRepository;
	@Autowired
	private IExperienciaRepository experienciaRepository;
	@Autowired
	private IEstadoRepository estadoRepository;

	public UsuarioController(IUsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/login/{login}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscar(@PathVariable("login") String login) {
		System.out.println(login);
		return this.usuarioRepository.findByLogin(login);
	}

	/**
	 * SALVAR UM NOVO REGISTRO
	 * 
	 * @param usuário
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response save(@RequestBody Usuario usuario) {

		System.out.println(usuario);
		int id_estado = usuario.getEstado().getId_estado();
		int id_cidade = usuario.getCidade().getId_cidade();
		
		
		String stateCityNames = estadoRepository.getStateAndCityNames(id_estado, id_cidade);
		String[] stateCityNamesList = stateCityNames.split(",", 3);
		String nome_estado = stateCityNamesList[0];
		String nome_cidade = stateCityNamesList[1];
		
		usuario.getEstado().setId_estado(id_estado);
		usuario.getEstado().setNome_estado(nome_estado);
		usuario.getCidade().setId_cidade(id_cidade);
		usuario.getCidade().setNome_cidade(nome_cidade);
		
		
		System.out.println(usuario);
		try {
			//get name of state cause it's not null in database
			
			this.usuarioRepository.save(usuario);
			if (usuario.getRole().getId_role() == 3) {
				return new Response(1, "Empregador cadastrado com sucesso.", usuario.getRole().getId_role());
			} else if (usuario.getRole().getId_role() == 2) {
				return new Response(1, "Funcionário cadastrado com sucesso.", usuario.getRole().getId_role());
			} else {
				return new Response(1, "Administrador cadastrado com sucesso.", usuario.getRole().getId_role());
			}
		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getRole().getId_role());
		}
	}

	/**
	 * CONSULTAR TODAS OS USUÁRIOS
	 * 
	 * @return
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> consultar() {

		return this.usuarioRepository.findAll();
	}

	/**
	 * BUSCAR UM USUÁRIO PELO PERFIL
	 * 
	 * @param idRole
	 * @return
	 */
	@RequestMapping(value = "/idRole/{idRole}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Usuario> buscarUsuarioPorPerfil(@PathVariable("idRole") int idRole) {

		return this.usuarioRepository.encontrarIdRole(idRole);
	}

	/**
	 * BUSCAR UM USUÁRIO COM PARAMETROS DINÂMICOS
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/usuario/listaUsuarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// public @ResponseBody Iterable<Usuario> buscarParam(Usuario usuario) {
	public @ResponseBody Iterable<Usuario> buscarParam(PesquisaFuncionario camposPesquisa) {
		Usuario user = new Usuario();

		Role role = new Role();
		role.setId_role(camposPesquisa.getIdRole());
		user.setRole(role);
				
		
		// Populando o objeto Usuário para buscar no banco posteriormente
		// nome				
		if (camposPesquisa.getNome() != "") 
			user.setNome(camposPesquisa.getNome());
		else
			user.setNome(null);
		
		// sobrenome
		if (camposPesquisa.getSobrenome() != "") 
			user.setSobrenome(camposPesquisa.getSobrenome());	
		else
			user.setSobrenome(null);
				
		// estado
		if (camposPesquisa.getEstado() != "") {
			Estado estado = new Estado();
			estado.setId_estado(Integer.parseInt(camposPesquisa.getEstado()));
			user.setEstado(estado);
		}else
			user.setEstado(null);
		
		// cidade
		if (camposPesquisa.getCidade() != "") {
			Cidade cidade = new Cidade();
			cidade.setId_cidade(Integer.parseInt(camposPesquisa.getCidade()));
			user.setCidade(cidade);
		}else
			user.setCidade(null);
		
				
		// avaliacao
		if (camposPesquisa.getStar() != "") {					
			Estrelas estrelas = new Estrelas();
			int id_star = 1;
			int vl_star = 0;
			
			String[] starSplit= camposPesquisa.getStar().split(" - ");
			id_star += Integer.parseInt(starSplit[0]);	
			vl_star = Integer.parseInt(starSplit[0]);
			
			estrelas.setId_star(id_star);
			estrelas.setValor_star(vl_star);
			
			user.setStars(estrelas);					
		}else
			user.setStars(null);
		
		// experiencia
		if (camposPesquisa.getExperiencia() != "") {
			Experiencia experiencia = new Experiencia();
			
			int id_experiencia  = experienciaRepository.buscarIdPeloNome(camposPesquisa.getExperiencia());
			experiencia.setIdExperiencia(id_experiencia);
			
			user.setExperiencia(experiencia);
		}else
			user.setExperiencia(null);
		

		Example<Usuario> usuarioExample = Example.of(user,
				ExampleMatcher.matchingAll()
				.withIgnoreNullValues());

		Iterable<Usuario> listaFuncionario = this.usuarioRepository.findAll(usuarioExample);

		for (Usuario u : listaFuncionario) {
			System.out.println("\n" + u);
		}

		return listaFuncionario;
	}

	/**
	 * BUSCAR UM USUÁRIO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/idUsuario/{id_usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Usuario buscarById(@PathVariable("id_usuario") Long id_usuario) {
		usuario = this.usuarioRepository.findByIdUsuario(id_usuario);
		return usuario;
	}

	/**
	 * LOGAR UM USUÁRIO PELO USUÁRIO E SENHA
	 * 
	 * @param login and senha
	 * @return
	 */
	@RequestMapping(value = "/usuario/{login}/{senha}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response login(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		try {
			usuario = this.usuarioRepository.encontrarLogin(login, senha);
			if (usuario != null) {
				System.out.println(usuario.getRole().getId_role());
				return new Response(1, "Seja Bem-vindo.", usuario.getRole().getId_role());
			} else {
				System.out.println(usuario);
				return new Response(0, "Usuário não encontrado", 0);
			}
		} catch (Exception e) {
			return new Response(0, e.getMessage(), 0);
		}
	}

	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value = "/usuario/{id_usuario}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("id_usuario") Long id_usuario) {

		Usuario usuario = usuarioRepository.findByIdUsuario(id_usuario);
		try {
			usuarioRepository.delete(usuario);
			return new Response(1, "Registro excluído com sucesso.", usuario.getRole().getId_role());

		} catch (Exception e) {
			return new Response(0, e.getMessage(), usuario.getRole().getId_role());
		}
	}

	/**
	 * BUSCAR UM USUÁRIO PELO EMAIL
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/usuario/email/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response redefinirPassword(@PathVariable("email") String email) {
		try {
			usuario = this.usuarioRepository.encontrarEmail(email);
			if (usuario != null) {
				return new Response(1, "Verifique o email.");
			} else {
				return new Response(0, "Email não encontrado.");
			}
		} catch (Exception e) {
			return new Response(0, e.getMessage());
		}
	}
	
	/**
	 * BUSCAR AVALIACOES PELO ID DO USUÁRIO
	 * 
	 * @param id_usuario
	 * @return
	 */
	@RequestMapping(value = "/avaliacoes/{id_usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Avaliacoes getRatingUser(@PathVariable("id_usuario") int id_usuario) {

		Avaliacoes avaliacao = new Avaliacoes();
		long id_avaliacao = usuarioRepository.buscaIdAvaliation(id_usuario);
		avaliacao = avaliacoesRepository.findByIdAvaliacao(id_avaliacao);
		

		if (avaliacao != null) {
			return avaliacao;
		} else {
			return new Avaliacoes();
		}
	}

}
