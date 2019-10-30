package springbootapi.irepositorio.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maidclean.springboot.springbootapi.model.Usuario;

public interface IUsuarioRepositoryQuery extends JpaRepository<Usuario, Long>{

	List<Usuario> encontreUsuarioComParametros(Usuario usuarioParametros);
	
}
