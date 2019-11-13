package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/emailSend", method = RequestMethod.GET)
	public String sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setText("Pra redefinir a sua senha clique no link abaixo.");		
		msg.setTo("vinny_fa2000@hotmail.com");
		msg.setFrom("vinny_fa2000@hotmail.com");
		msg.setSubject("Testing mail in SPring Boot.");
		
		try {
			mailSender.send(msg);
			return "Email enviado com sucesso.";
		}catch(Exception e) {
			e.printStackTrace();
			return "Erro ao enviar o email.";
		}		
	}
	
}
