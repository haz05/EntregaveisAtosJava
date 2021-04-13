package com.vitorfernandes.projeto02API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitorfernandes.projeto02API.Models.Pessoa;

@Repository

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
