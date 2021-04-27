package com.vitor.Ex2API.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.Ex2API.Models.Estudante;



@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
	List<Estudante> findByNome(String nome);
	//Optional<Estudante> findByNome1(String nome);
	

}
