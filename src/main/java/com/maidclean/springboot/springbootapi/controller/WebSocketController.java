package com.maidclean.springboot.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class WebSocketController {

	private final SimpMessagingTemplate template;	
	private String horaAtualString = new SimpleDateFormat("HH:mm:ss").format(new Date());
	
	private String HoraString = "";
	private String MinutosString = "";
	private String SegundosString = "";
	
	@Autowired
	WebSocketController(SimpMessagingTemplate template){
		this.template = template;
	}
	
	@MessageMapping("send/message")
	public void onReceivedMessage(String message,String user) {
		arrumarHora(horaAtualString);
		
		this.template.convertAndSend("/chat",horaAtualString+ "- "+message);			
		System.out.println(horaAtualString+ " - "+message);	
	}
	
	//Arruma a hora devido o horario de verão que não aconteceu ese ano/2019 no Brasil
	//Horario está adiantada em 1 hora
	public void arrumarHora(String horaAtual) {				
		Date horaAtuall = Calendar.getInstance().getTime();
		int hora = horaAtuall.getHours() - 1;		
		int minutos = horaAtuall.getMinutes();
		int segundos = horaAtuall.getSeconds();	
		
		//adiciona um 0 na frente do valor se a hora for menor que 10
		if(hora >= 0 && hora < 10) {
			HoraString = "0";
			HoraString += Integer.toString(hora);
		}else {
			HoraString = Integer.toString(hora);
		}
		
		//adiciona um 0 na frente do valor se os minutos for menor que 10
		 if(minutos >= 0 && minutos < 10) {
			MinutosString = "0";
			MinutosString += Integer.toString(minutos);
		}else {
			MinutosString = Integer.toString(minutos);
		}
		
		//adiciona um 0 na frente do valor se os minutos for menor que 10
		if(segundos >= 0 && segundos < 10) {
			SegundosString = "0";
			SegundosString += Integer.toString(segundos);
		}else {
			SegundosString = Integer.toString(segundos);
		}
		
		//concatena a hora,minutos e segundos em uma variavel só
		horaAtual = HoraString + ":" + MinutosString + ":" + SegundosString;				
		horaAtualString = horaAtual;		
	}
	
}
