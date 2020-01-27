package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Avaliacoes;
import com.maidclean.springboot.springbootapi.model.Estrelas;

@org.springframework.stereotype.Repository
public interface IStarsRepository  extends Repository<Estrelas,Long>{
	
	List<Estrelas> findAll();
	
	@Query(value="SELECT * FROM tb_stars where vl_star =:vl_star", nativeQuery = true)
	Estrelas buscarVlStar(int vl_star);

}
