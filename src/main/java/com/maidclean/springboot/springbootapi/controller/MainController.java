package com.maidclean.springboot.springbootapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public String api() {
		return "api";
	}
		
	@RequestMapping(value = "/sucesso", method = RequestMethod.GET)
	public String sucesso() {
		return "respostas/cadastroSucesso";
	}
}
