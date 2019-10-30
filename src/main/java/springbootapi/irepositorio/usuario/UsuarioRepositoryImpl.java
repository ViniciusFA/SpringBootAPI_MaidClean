package springbootapi.irepositorio.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maidclean.springboot.springbootapi.model.Usuario;

@Repository
public class UsuarioRepositoryImpl implements IUsuarioRepositoryQuery{

	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping()
	@Override
	public List<Usuario> encontreUsuarioComParametros(Usuario usuarioParametros) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Usuario> createQuery = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> root = createQuery.from(Usuario.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(StringUtils.hasText(usuarioParametros.getNome())) {
			predicates.add(criteriaBuilder.like(root.get("nome"),"%"+usuarioParametros.getNome()+"%"));
		}
		if(StringUtils.hasText(usuarioParametros.getSobrenome())) {
			predicates.add(criteriaBuilder.like(root.get("sobrenome"),"%"+usuarioParametros.getSobrenome()+"%"));
		}
		if(StringUtils.hasText(usuarioParametros.getEstado())) {
			predicates.add(criteriaBuilder.like(root.get("estado"),"%"+usuarioParametros.getEstado()+"%"));
		}
		if(StringUtils.hasText(usuarioParametros.getCidade())) {
			predicates.add(criteriaBuilder.like(root.get("cidade"),"%"+usuarioParametros.getCidade()+"%"));
		}
		if(StringUtils.hasText(usuarioParametros.getSexo())) {
			predicates.add(criteriaBuilder.like(root.get("sexo"),"%"+usuarioParametros.getSexo()+"%"));
		}
		if(StringUtils.hasText(usuarioParametros.getExperiencia())) {
			predicates.add(criteriaBuilder.like(root.get("experiencia"),"%"+usuarioParametros.getExperiencia()+"%"));
		}
		
		createQuery.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Usuario> typedQuery = entityManager.createQuery(createQuery);
		return typedQuery.getResultList();				
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Usuario> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Usuario> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
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

}
