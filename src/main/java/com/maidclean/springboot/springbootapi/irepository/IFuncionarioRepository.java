package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Funcionario;

public interface IFuncionarioRepository extends Repository<Funcionario, Integer>{

	void save(Funcionario pessoa);
	 
	void delete(Funcionario pessoa);
 
	List<Funcionario> findAll();
 
	Funcionario findById(Long id);
	
	//select * from tb_funcionarios where ds_login = 'vitorAlgue' and ds_senha = 'vitorA';
	@Query("SELECT f FROM Funcionario f where f.login =:login and f.senha =:senha")
	Funcionario encontrarLogin(String login, String senha);

}


