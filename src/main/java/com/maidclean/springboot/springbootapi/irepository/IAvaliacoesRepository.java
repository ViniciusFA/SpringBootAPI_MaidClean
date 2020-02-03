package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.repository.Repository;
import org.springframework.data.jpa.repository.Query;

import com.maidclean.springboot.springbootapi.model.Avaliacoes;

import java.util.List;

@org.springframework.stereotype.Repository
public interface IAvaliacoesRepository extends Repository<Avaliacoes,Long>{			
	
	  @Query(value="SELECT * FROM tb_avaliacoes a where a.id_usuario =:id_usuario",
	  nativeQuery = true) Avaliacoes getRatingUser(int id_usuario);	 
	
	 List<Avaliacoes> findAll();
	 
	 @Query(value="SELECT * FROM tb_avaliacoes a where id_star =:id_star", nativeQuery = true)
	 List<Avaliacoes> buscarIdStar(int id_star);
	 
	 Avaliacoes findByIdAvaliacao(Long idAvaliacao);
	 
	 void save(Avaliacoes avaliacao);
	 
	/*
	 * @Query(
	 * value="select * from tb_avaliacoes where id_avaliacao =: id_avaliation"
	 * ,nativeQuery = true) Avaliacoes getAvaliations(int id_avaliation);
	 */
	
	  
}
