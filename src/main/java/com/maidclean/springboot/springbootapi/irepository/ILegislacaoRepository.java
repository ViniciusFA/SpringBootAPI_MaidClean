package com.maidclean.springboot.springbootapi.irepository;

import java.io.File;
import java.net.URL;

import com.maidclean.springboot.springbootapi.model.Response;

public interface ILegislacaoRepository {

	Response DownloadPage(URL url, File file);
	
}
