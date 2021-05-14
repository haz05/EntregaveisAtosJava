package com.vfbp.ProjetoFinalVitorFernandes.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vfbp.ProjetoFinalVitorFernandes.Models.ProdutoModel;



public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	
	List<ProdutoModel> findByCodigo(String codigo); // Cria um novo findBy que busca por funcao(deve ter o mesmo nome que a variavel)


}
