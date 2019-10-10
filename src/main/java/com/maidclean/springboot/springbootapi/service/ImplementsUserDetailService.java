package com.maidclean.springboot.springbootapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.Usuario;

@Repository
@Transactional
public class ImplementsUserDetailService implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não cadastrado.");
		}
		return new User(usuario.getUsername(),usuario.getPassword(), true, true, true, true , usuario.getAuthorities());
	}

}
