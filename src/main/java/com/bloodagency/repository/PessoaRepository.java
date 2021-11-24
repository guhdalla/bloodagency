package com.bloodagency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodagency.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
