package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.repository.Repository;
import java.util.List;
import com.maidclean.springboot.springbootapi.model.Vaga;

public interface IVagaRepository extends Repository<Vaga, Integer>{
	
	List<Vaga> findAll();

}
