package com.maidclean.springboot.springbootapi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.maidclean.springboot.springbootapi.model.ImagemPerfil;
import com.maidclean.springboot.springbootapi.model.Usuario;

@Component
public class Disco {

	@Value("${contato.disco.raiz}")
	private String raiz;
	
	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;
	
	public Usuario salvarFotoDiretorio(MultipartFile foto, Usuario user) {
		this.salvar(this.diretorioFotos, foto, user);
		return user;
	}
	
	public void salvar(String diretorio, MultipartFile arquivo, Usuario user) {
		
		SimpleDateFormat dateFormatada = new SimpleDateFormat("dd-MM-yyyy");
		String dataAtual = dateFormatada.format(new Date());
		String nameFile, nameFullPathFile,extensao,namePath = "";
		String[] extensaoSplit;
		
		ImagemPerfil image = new ImagemPerfil();
		
		nameFile = user.getIdUsuario() + user.getNome() + dataAtual;
		
		extensaoSplit = arquivo.getContentType().split("/",2);
		extensao = extensaoSplit[1];
		
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(nameFile + "." + extensao);		
		
		namePath = diretorioPath.toString();
		  		
		image.setIdImage(user.getIdUsuario());
		image.setName_image(nameFile);
		image.setPath_image(namePath);
		image.setType_image(arquivo.getContentType());
		
		user.setFoto(image);
		
		try {
			Files.createDirectories(diretorioPath);			
			arquivo.transferTo(arquivoPath.toFile());
			
		}catch(IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar o arquivo." );
		}
	}	

}

