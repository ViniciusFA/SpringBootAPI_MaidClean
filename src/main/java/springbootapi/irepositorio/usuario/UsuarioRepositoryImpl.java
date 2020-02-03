package springbootapi.irepositorio.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery{
	
	@PersistenceContext
	private EntityManager entityManager;

}
