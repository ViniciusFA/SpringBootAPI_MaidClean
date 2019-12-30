package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import com.maidclean.springboot.springbootapi.model.Avaliacoes;

@org.springframework.stereotype.Repository
public interface IAvaliacoesRepository extends Repository<Avaliacoes,Long>{	
		
	@Query(value="SELECT * FROM tb_avaliacoes a where a.id_usuario =:id_usuario", nativeQuery = true)
	  Avaliacoes getRatingUser(int id_usuario);
	  
}
