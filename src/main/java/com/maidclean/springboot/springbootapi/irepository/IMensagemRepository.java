package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Mensagens;

@org.springframework.stereotype.Repository
public interface IMensagemRepository extends Repository<Mensagens,Long>{

	void save(Mensagens mensagem);
	
	
	
}
