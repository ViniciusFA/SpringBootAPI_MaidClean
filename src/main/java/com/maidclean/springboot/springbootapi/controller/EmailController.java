package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maidclean.springboot.springbootapi.service.MailContentBuilderService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {

	
	  @Autowired 
	  private JavaMailSender mailSender;
	  
	  @Autowired
	  private MailContentBuilderService mailContentBuilder;
	  
	  @RequestMapping(value="/emailSend", method = RequestMethod.GET) 
	  public void prepareAndsendMail() { 
		
		  MimeMessagePreparator messagePreparator = mimeMessage -> {
			  String message = "";
			  MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			  messageHelper.setFrom("vinny_fa2000@hotmail.com");
			  messageHelper.setTo("vinny_fa2000@hotmail.com");
			  messageHelper.setSubject("Testing Mail in Spring Boot");
			  message = "teste";
			  String content = mailContentBuilder.build(message);
			  messageHelper.setText(content);
		  };
		  try {
			  mailSender.send(messagePreparator);
		  }catch(MailException e) {
			  
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
