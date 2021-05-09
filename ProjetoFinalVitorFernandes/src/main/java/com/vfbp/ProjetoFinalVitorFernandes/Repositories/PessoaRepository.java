package com.vfbp.ProjetoFinalVitorFernandes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vfbp.ProjetoFinalVitorFernandes.Models.PessoaModel;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>{
	 PessoaModel findByLogin(String Login); 

}
