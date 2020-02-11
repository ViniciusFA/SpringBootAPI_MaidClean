package com.maidclean.springboot.springbootapi.irepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.maidclean.springboot.springbootapi.model.ImagemPerfil;
import com.maidclean.springboot.springbootapi.model.Usuario;

public interface IImagePerfilRepository extends Repository<ImagemPerfil, Long>{
	
	void save(ImagemPerfil image);
	
	ImagemPerfil findByIdImage(ImagemPerfil imagePerfil);
	
	@Query(value="SELECT im.ds_path, im.ds_name,im.ds_type FROM tb_images im INNER JOIN "
			+ " tb_usuarios u ON im.id_image = u.id_image WHERE"
			+ " u.id_usuario =:idUsuario", nativeQuery = true)
	String getPhotoProfile(int idUsuario);
	
	
	

}
