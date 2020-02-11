package com.maidclean.springboot.springbootapi.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="tb_images")
public class ImagemPerfil implements Serializable{
	
	@Id
	@Column(name="id_image")
	private Long idImage;
	
	@Column(name="ds_name")
	private String name_image;
	
	@Column(name="ds_path")
	private String path_image;
	
	@Column(name="ds_type")
	private String type_image;	

	public Long getIdImage() {
		return idImage;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public String getName_image() {
		return name_image;
	}

	public void setName_image(String name_image) {
		this.name_image = name_image;
	}	
	
	public String getPath_image() {
		return path_image;
	}

	public void setPath_image(String path_image) {
		this.path_image = path_image;
	}

	public String getType_image() {
		return type_image;
	}

	public void setType_image(String type_image) {
		this.type_image = type_image;
	}
		
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idImage == null) ? 0 : idImage.hashCode());
		result = prime * result + ((name_image == null) ? 0 : name_image.hashCode());
		result = prime * result + ((path_image == null) ? 0 : path_image.hashCode());
		result = prime * result + ((type_image == null) ? 0 : type_image.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemPerfil other = (ImagemPerfil) obj;
		if (idImage == null) {
			if (other.idImage != null)
				return false;
		} else if (!idImage.equals(other.idImage))
			return false;
		if (name_image == null) {
			if (other.name_image != null)
				return false;
		} else if (!name_image.equals(other.name_image))
			return false;
		if (path_image == null) {
			if (other.path_image != null)
				return false;
		} else if (!path_image.equals(other.path_image))
			return false;
		if (type_image == null) {
			if (other.type_image != null)
				return false;
		} else if (!type_image.equals(other.type_image))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImagemPerfil [id_image=" + idImage + ", name_image=" + name_image + ", path_image=" + path_image
				+ ", type_image=" + type_image + "]";
	}
	/*
	 * @Override public String getName() { // TODO Auto-generated method stub return
	 * null; }
	 * 
	 * @Override public String getOriginalFilename() { // TODO Auto-generated method
	 * stub return null; }
	 * 
	 * @Override public String getContentType() { // TODO Auto-generated method stub
	 * return null; }
	 * 
	 * @Override public boolean isEmpty() { // TODO Auto-generated method stub
	 * return false; }
	 * 
	 * @Override public long getSize() { // TODO Auto-generated method stub return
	 * 0; }
	 * 
	 * @Override public byte[] getBytes() throws IOException { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public InputStream getInputStream() throws IOException { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void transferTo(File dest) throws IOException,
	 * IllegalStateException { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	
}
