package com.maidclean.springboot.springbootapi.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilderService {

	private TemplateEngine templateEngine;
	
	public MailContentBuilderService(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}
	
	public String build (String message) {
		Context context = new Context();
		context.setVariable("message", message);
		return templateEngine.process("mailTemplate", context);
	}
	
}
