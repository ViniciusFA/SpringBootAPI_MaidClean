package springbootapi.irepositorio.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery{

	@Autowired
	private IUsuarioRepository userRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	/*
	 * @Override public Iterable<Usuario> findUsuarioWithParameters(Usuario
	 * usuarioParametros) { CriteriaBuilder criteriaBuilder =
	 * entityManager.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Usuario> createQuery =
	 * criteriaBuilder.createQuery(Usuario.class); Root<Usuario> root =
	 * createQuery.from(Usuario.class);
	 * 
	 * List<Predicate> predicates = new ArrayList<Predicate>();
	 * 
	 * if(StringUtils.hasText(usuarioParametros.getNome())) {
	 * predicates.add(criteriaBuilder.like(root.get("nome"),"%"+usuarioParametros.
	 * getNome()+"%")); } if(StringUtils.hasText(usuarioParametros.getSobrenome()))
	 * { predicates.add(criteriaBuilder.like(root.get("sobrenome"),"%"+
	 * usuarioParametros.getSobrenome()+"%")); }
	 * if(StringUtils.hasText(usuarioParametros.getEstado())) {
	 * predicates.add(criteriaBuilder.like(root.get("estado"),"%"+usuarioParametros.
	 * getEstado()+"%")); } if(StringUtils.hasText(usuarioParametros.getCidade())) {
	 * predicates.add(criteriaBuilder.like(root.get("cidade"),"%"+usuarioParametros.
	 * getCidade()+"%")); } if(StringUtils.hasText(usuarioParametros.getSexo())) {
	 * predicates.add(criteriaBuilder.like(root.get("sexo"),"%"+usuarioParametros.
	 * getSexo()+"%")); }
	 * if(StringUtils.hasText(usuarioParametros.getExperiencia())) {
	 * predicates.add(criteriaBuilder.like(root.get("experiencia"),"%"+
	 * usuarioParametros.getExperiencia()+"%")); }
	 * 
	 * createQuery.where(predicates.toArray(new Predicate[0]));
	 * 
	 * TypedQuery<Usuario> typedQuery = entityManager.createQuery(createQuery);
	 * 
	 * 
	 * return typedQuery.getResultList(); }
	 */

}
