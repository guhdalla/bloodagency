package com.bloodagency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloodagency.model.Pessoa;
import com.bloodagency.model.enums.EstadoBrasil;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByEstado(EstadoBrasil estado);

}
