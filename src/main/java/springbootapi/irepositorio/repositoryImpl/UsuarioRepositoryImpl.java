package springbootapi.irepositorio.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.Usuario;

public class UsuarioRepositoryImpl implements IUsuarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> Iterable<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> Iterable<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Usuario> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Usuario pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByIdRole(int idRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario encontrarLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	//implementando 
	@Override
	public List findAll(String nome, String sobrenome) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery query = cb.createQuery(Usuario.class);
		Root root = query.from(Usuario.class);
		
		List filterPredicates = new ArrayList();
		filterPredicates.add(root.get("nome"));
		filterPredicates.add(root.get("sobrenome"));
		
		if(nome != null && !nome.isEmpty())
		{
		filterPredicates.add(cb.like(root.get("nome"), nome));	
		}
		else if(sobrenome != null && !sobrenome.isEmpty()) {
			filterPredicates.add(cb.like(root.get("sobrenome"), sobrenome));	
		}
		query.select(cb.construct(Usuario.class,
									root.get("nome"),
									root.get("sobrenome")))
									.where (cb.and(filterPredicates.toArray(new Predicate[0]))));
		
		return null;
	}

	@Override
	public List<Usuario> consultarParametro(String nome, String sobrenome) {
		// TODO Auto-generated method stub
		return null;
	}

}
