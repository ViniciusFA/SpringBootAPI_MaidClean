package com.maidclean.springboot.springbootapi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import com.maidclean.springboot.springbootapi.service.ImplementsUserDetailService;

@EnableWebSecurity
@Configuration
public class SecutiryConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailService userDetailsService;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		//gerando um password criptografada
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		//.antMatchers(HttpMethod.GET, "/").permitAll()
		//.antMatchers(HttpMethod.POST, "/").permitAll()
		//.antMatchers(HttpMethod.GET, "/usuario").hasRole("ADMIN")
		//.antMatchers(HttpMethod.POST, "/usuario").hasRole("ADMIN")
		//.anyRequest().authenticated()
		.and().formLogin().permitAll();
		//.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}


	
