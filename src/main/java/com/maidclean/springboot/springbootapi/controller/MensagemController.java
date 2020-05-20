package com.maidclean.springboot.springbootapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.irepository.IMensagemRepository;
import com.maidclean.springboot.springbootapi.model.Mensagens;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MensagemController {
//http://localhost:4200/api/messages/191/172
	@Autowired
	private IMensagemRepository mensagemRepository;
	
	@RequestMapping(value = "/messages/{idUserRem}/{idUserDest}", method = RequestMethod.GET)
	public List<Mensagens> getAllMessages(@PathVariable("idUserRem") int idUserRem, 
			@PathVariable("idUserDest") int idUserDest){
		
		List<Mensagens> mensagens = new ArrayList<Mensagens>();
		mensagens = this.mensagemRepository.getMensagensByIdRem(idUserRem,idUserDest);
		
		return mensagens;
	}
}
