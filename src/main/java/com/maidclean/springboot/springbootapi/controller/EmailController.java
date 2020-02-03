package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.maidclean.springboot.springbootapi.model.Response;
import com.maidclean.springboot.springbootapi.service.MailContentBuilderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {

	
	  @Autowired 
	  private JavaMailSender mailSender;
	  
	  @Autowired
	  private MailContentBuilderService mailContentBuilder;
	  
	  @RequestMapping(value="/emailSend/{email}", method = RequestMethod.GET) 
	  public @ResponseBody Response prepareAndsendMail(@PathVariable("email") String email, String nome) { 
		
		
		  try {
			  MimeMessagePreparator messagePreparator = mimeMessage -> {
				  String message = "";
				  MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
				  messageHelper.setFrom("vinny_fa2000@hotmail.com");
				  messageHelper.setTo(email);
				  messageHelper.setSubject("Testando Email no Spring Boot");
				  message = "Título";
				  String contentHTML = mailContentBuilder.build(message,nome);
				  messageHelper.setText(contentHTML,true);
				 //messageHelper.setText("<html><body><button>Clique aqui</button></body></html>",true);
			  };
			  mailSender.send(messagePreparator);
			  return new Response(1,"Um link para redefinição de senha \n foi encaminhado para o seu email.");	
			  
		  }catch(MailException e) {
			  e.getMessage();
			  return new Response(0, "Erro ao enviar email..");			  
		  }		  
		  /*
		   * public String prepareAndsendMail(String email) { 
			 * SimpleMailMessage msg = new SimpleMailMessage();
			 * msg.setText("Pra redefinir a sua senha clique no link abaixo.");
			 * msg.setTo("vinny_fa2000@hotmail.com");
			 * msg.setFrom("vinny_fa2000@hotmail.com");
			 * msg.setSubject("Testing mail in SPring Boot.");
			 * 
			 * try { 
			 * mailSender.send(msg); 
			 * return "Email enviado com sucesso.";
			 * }
			 * catch(Exception e) { 
			 * e.printStackTrace(); 
			 * return "Erro ao enviar o email.";
			 * }	
			 * }	 
			 */
	  
	  }
	 
}
