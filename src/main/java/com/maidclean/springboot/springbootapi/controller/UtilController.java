package com.maidclean.springboot.springbootapi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maidclean.springboot.springbootapi.irepository.IImagePerfilRepository;
import com.maidclean.springboot.springbootapi.irepository.IUsuarioRepository;
import com.maidclean.springboot.springbootapi.model.ImagemPerfil;
import com.maidclean.springboot.springbootapi.model.Usuario;
import com.maidclean.springboot.springbootapi.util.Disco;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilController {
	@Autowired
	private Disco disco;
	
	@Autowired
	private IImagePerfilRepository imagePerfilrepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	private Usuario usuario = new Usuario();

	
	/**
	 * RECEBE O USUARIO VINDO DO FRONT END
	 * 
	 * @param uSUARIO
	 * @return
	 */
	@RequestMapping(value="/foto/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public @ResponseBody void receberUser(@RequestBody  Usuario user) {		
		this.usuario = user;
	}
	
	
	/**
	 * SALVAR UMA FOTO NO DIRETORIO E SALVA AS INFORMAÇÕES NO BANCO
	 * 
	 * @param MultipartFile
	 * @return
	 */
	@RequestMapping(value="/foto", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public @ResponseBody String uploadPicture( @RequestParam("foto") MultipartFile foto) {		
		String retorno = "";
		
		try {			
			disco.salvarFotoDiretorio(foto, this.usuario);			
			
			this.salvarFotoDB(this.usuario);
			
			retorno = "Foto salva com sucesso";			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			retorno = e.getMessage();			
		}	
		
		System.out.println(retorno);
		return retorno;				
	}
	
	public void salvarFotoDB(Usuario user) {
		ImagemPerfil imageProfile = new ImagemPerfil();
		
		try {			
			imageProfile.setIdImage(user.getIdUsuario());
			imageProfile.setName_image(user.getFoto().getName_image());
			imageProfile.setPath_image(user.getFoto().getPath_image());
			imageProfile.setType_image(user.getFoto().getType_image());
			
			user.setFoto(imageProfile);
			
			this.imagePerfilrepository.save(imageProfile);	
			
			
			this.usuarioRepository.save(user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/**
	 * PEGA AS INFORMAÇÕES DA FOTO NO BANCO PARA ATUALIZAR A FOTO DO PERFIL DO USUARIO
	 * 
	 * @param uSUARIO
	 * @return
	 */
	@RequestMapping(value="/foto/imgSource/{idUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getPhotoProfile(@PathVariable("idUsuario") int idUsuario) {	
		String[] pathFullFileArray,extensaoSplit;
		String extensao = "", pathFullExtension ="";
		String imgSrcPath =  this.imagePerfilrepository.getPhotoProfile(idUsuario)
				;
		if(imgSrcPath != null) {
			String[] imgSourceArray = imgSrcPath.split(",",3);		
			String pathFullFile = imgSourceArray[0] + "\\";
			pathFullFile += imgSourceArray[1] + '.';
			
			extensaoSplit = imgSourceArray[2].split("/",2);
			extensao = extensaoSplit[1];
			
			pathFullFileArray = pathFullFile.split("src", 2);
			pathFullFile = pathFullFileArray[1];
			pathFullFile = pathFullFile.replace('\\', '/');
			
			pathFullExtension = pathFullFile + extensao;
			
			return pathFullExtension;
		}else
			return "/assets/img/funcionario/photo-here.jpg";
		
		
	}
	

}
