package com.vitorfernandes.projeto02API.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorfernandes.projeto02API.Models.Individuos;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuos, Long>{
	/*
	@Query("Select p.nome from pessoa p where p.nome = :nome")
	List<Individuos> findByFuncao(@Param("nome") String funcao);
	*/
	List<Individuos> findByFuncao(String funcao);

}
