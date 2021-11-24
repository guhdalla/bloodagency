package com.bloodagency.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bloodagency.service.PessoaService;

@Configuration
public class ImportJsonConfiguration {

	@Autowired
	private PessoaService service;
	
	public String dir = "./data.json";

	@Bean
	public void loaderJson() {
		service.importJson(dir);
	}
}
