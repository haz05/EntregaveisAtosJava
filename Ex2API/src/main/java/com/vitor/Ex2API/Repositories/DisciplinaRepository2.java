package com.vitor.Ex2API.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.Ex2API.Models.Disciplina;


@Repository
public interface DisciplinaRepository2 extends JpaRepository<Disciplina, Long>{
	//public List<Disciplina> findByNome(String nome);
	
	Optional<Disciplina> findByNome(String nome);
}
