package com.maidclean.springboot.springbootapi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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


	
