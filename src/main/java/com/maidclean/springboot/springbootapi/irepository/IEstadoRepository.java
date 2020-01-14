package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Cidade;
import com.maidclean.springboot.springbootapi.model.Estado;

public interface IEstadoRepository extends Repository<Estado,Integer> {

	List<Estado> findAll();
	
}
