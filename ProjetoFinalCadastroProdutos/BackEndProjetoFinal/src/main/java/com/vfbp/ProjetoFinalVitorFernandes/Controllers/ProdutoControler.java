package com.vfbp.ProjetoFinalVitorFernandes.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vfbp.ProjetoFinalVitorFernandes.Models.ProdutoModel;
import com.vfbp.ProjetoFinalVitorFernandes.Repositories.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PRODUTOS")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutoControler {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@ApiOperation(value = "Cadastra um produto", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoModel adicionar(@RequestBody ProdutoModel cadastro) {
		
		return produtoRepository.save(cadastro);
		
	}
	
	@ApiOperation(value = "Retorna os produtos", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/cadastrar")
	public List<ProdutoModel> getCadastro(){
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value = "Retorna o produto, passando como parametro o ID", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/{id}")
	public float getCadastro(@PathVariable Long id) {
		try {
			
			return produtoRepository.findById(id).get().getPreco();	
		}catch(Exception e){
			return (Float) null;
		}
	}
	
	@ApiOperation(value = "Retorna o produto, passando como parametro o codigo", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/codigo/{codigo}")
	public List<ProdutoModel> getCadastroFunc(@PathVariable String codigo){
		return produtoRepository.findByCodigo(codigo);
	
	}
	
	@ApiOperation(value = "Altera um produto, recebendo o ID por parametro. Retorna a insercao.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	public ProdutoModel updateCadastro(@RequestBody ProdutoModel cadastro, @PathVariable Long id) {
		
		ProdutoModel p = produtoRepository.getOne(id);
		
		if(p == null) {
			return null;
		}else {
			p.setCodigo(cadastro.getCodigo());
			p.setDenominacao(cadastro.getDenominacao());
			p.setPreco(cadastro.getPreco());
			return produtoRepository.save(p);
		}
	}
	
	@ApiOperation(value = "Deletar algum produto", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}

	
}
