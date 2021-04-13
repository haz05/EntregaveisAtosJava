package com.vitorfernandes.projeto02API.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vitorfernandes.projeto02API.Models.Cidade;
import com.vitorfernandes.projeto02API.Repositories.CidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/cadastro")
public class CidadeCadastro {
	
	@Autowired
	private CidadeRepository cidaderepository;
	@ApiOperation(value = "Cadastra um ano e a quantidade populacional", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cadastro) {
		
		return cidaderepository.save(cadastro);
		
	}
	
	@ApiOperation(value = "Retorna os anos cadastrados", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/cadastrar")
	public List<Cidade> getCadastro(){
		return cidaderepository.findAll();
	}
	
	@ApiOperation(value = "Retorna o ano e a quantidade, passando como parametro o ID", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/{id}")
	public Optional<Cidade> getCadastro(@PathVariable Long id) {
		try {
			
			return cidaderepository.findById(id);	
		}catch(Exception e){
			return null;
		}
	}
	
	@ApiOperation(value = "Altera um ano, recebendo um ano e o ID por parametro. Retorna o novo dado.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	public Cidade updateCadastro(@RequestBody Cidade cadastro, @PathVariable Long id) {
		
		Cidade c = cidaderepository.getOne(id);
		
		if(c == null) {
			return null;
		}else {
			c.setAno(cadastro.getAno());
			c.setQnt(cadastro.getQnt());
			return cidaderepository.save(c);
		}
	}
	
	@ApiOperation(value = "Deletar algum ano", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		cidaderepository.deleteById(id);
	}

}
