package com.maidclean.springboot.springbootapi.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.Mensagens;

@org.springframework.stereotype.Repository
public interface IMensagemRepository extends Repository<Mensagens,Long>{

	void save(Mensagens mensagem);
	
	@Query(value="select ds_mensagem from tb_mensagens where id_usuario_rem =:idRemetente and"
			+ " id_usuario_des =:idDestinatario", nativeQuery = true)	
	List<Mensagens> getMensagensByIdRem(int idRemetente, int idDestinatario);
	
}
