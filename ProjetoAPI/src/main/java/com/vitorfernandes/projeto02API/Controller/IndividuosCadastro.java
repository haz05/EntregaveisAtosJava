package com.vitorfernandes.projeto02API.Controller;

import java.util.ArrayList;
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

import com.vitorfernandes.projeto02API.Models.Individuos;
import com.vitorfernandes.projeto02API.Repositories.IndividuoFuncRepository;
import com.vitorfernandes.projeto02API.Repositories.IndividuoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/cadastroIndividuo")
public class IndividuosCadastro {
	
	@Autowired
	private IndividuoFuncRepository individuofuncrepository;
	
	@Autowired
	private IndividuoRepository individuorepository;
	@ApiOperation(value = "Cadastra um individuo e sua funcao", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Individuos adicionar(@RequestBody Individuos cadastro) {
		
		return individuorepository.save(cadastro);
		
	}
	
	@ApiOperation(value = "Retorna os individuos", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/cadastrar")
	public List<Individuos> getCadastro(){
		return individuorepository.findAll();
	}
	
	@ApiOperation(value = "Retorna o individuo, passando como parametro o ID", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/{id}")
	public Optional<Individuos> getCadastro(@PathVariable Long id) {
		try {
			
			return individuorepository.findById(id);	
		}catch(Exception e){
			return null;
		}
	}
	
	@ApiOperation(value = "Retorna o individuo, passando como parametro a funcao", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/funcao/{funcao}")
	public List<Individuos> getCadastroFunc(@PathVariable String funcao){
		return individuorepository.findByFuncao(funcao);
		
		
		/*
		List<Individuos> var = individuorepository.findAll();
		List<Individuos> filtrados = new ArrayList<Individuos>();
		
		if(var == null) {
			return null;
		}else {
			
			for (Individuos individuo : var) 
			{
				if(individuo.getFuncao() == func)
				{
					filtrados.add(individuo);
				}
			}
			
			return filtrados;
		}
		*/
		
	}
	
	@ApiOperation(value = "Altera um individuo, recebendo um nome e o ID por parametro. Retorna a insercao.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	public Individuos updateCadastro(@RequestBody Individuos cadastro, @PathVariable Long id) {
		
		Individuos i = individuorepository.getOne(id);
		
		if(i == null) {
			return null;
		}else {
			i.setNome(cadastro.getNome());
			i.setFuncao(cadastro.getFuncao());
			return individuorepository.save(i);
		}
	}
	
	@ApiOperation(value = "Deletar algum individuo", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		individuorepository.deleteById(id);
	}

}
