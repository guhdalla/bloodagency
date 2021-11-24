package com.bloodagency.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodagency.model.Pessoa;
import com.bloodagency.model.enums.EstadoBrasil;
import com.bloodagency.repository.PessoaRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;

	public void importJson(String dir) {
		try {
			String json = String.join(" ", Files.readAllLines(Paths.get(dir), StandardCharsets.UTF_8));
			
			Gson gson = new GsonBuilder()
					   .setDateFormat("dd/MM/yyyy").create();
			
			Type listType = new TypeToken<ArrayList<Pessoa>>(){}.getType();
			List<Pessoa> pessoas = gson.fromJson(json, listType);
			pessoas.forEach(x -> create(x));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Pessoa create(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public List<Pessoa> findByEstado(EstadoBrasil estado) {
		return repository.findByEstado(estado);
	}
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}

}
