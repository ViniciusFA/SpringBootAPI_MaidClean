package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Funcionario;

public interface IPesquisaFuncionarioRepository extends Repository<Funcionario,Integer>, JpaSpecificationExecutor<Funcionario>{

	
}
