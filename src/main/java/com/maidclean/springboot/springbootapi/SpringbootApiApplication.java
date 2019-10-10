package com.maidclean.springboot.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringbootApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiApplication.class, args);
		//System.out.print("\nSenha criptografada: " + new BCryptPasswordEncoder().encode("123") + "\n");
		
	}

}
