package com.bloodagency.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bloodagency.service.PessoaService;

@Configuration
public class ImportJsonApplication {

	@Autowired
	private PessoaService service;
	
	private String dir = "./data.json";

	public static void main(String[] args) {
		new SpringApplicationBuilder(ImportJsonApplication.class).run(args);
	}

	@Bean
	public void loaderJson() {
		service.importJson(dir);
	}
}
