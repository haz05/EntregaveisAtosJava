package com.vitor.Ex2API.Controller;

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

import com.vitor.Ex2API.Models.Disciplina;
import com.vitor.Ex2API.Models.Estudante;
import com.vitor.Ex2API.Repositories.DisciplinaRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de Disciplinas")
@RestController
@RequestMapping("/cadastroDisciplina")
public class DisciplinaCadastro {
	
	@Autowired
	private DisciplinaRepository disciplinarepository;
	
	@ApiOperation(value = "Cadastra uma disciplina", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Disciplina adicionar(@RequestBody Disciplina cadastro) {
		
		return disciplinarepository.save(cadastro);
		
	}
	
	@ApiOperation(value = "Retorna as disciplinas", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/cadastrar")
	public List<Disciplina> getCadastro(){
		return disciplinarepository.findAll();
	}
	
	@ApiOperation(value = "Retorna a disciplina, passando como parametro o ID", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/{id}")
	public Optional<Disciplina> getCadastro(@PathVariable Long id) {
		try {
			
			return disciplinarepository.findById(id);	
		}catch(Exception e){
			return null;
		}
	}
	
	@ApiOperation(value = "Retorna a disciplina, passando como parametro o nome", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/nome/{nome}")
	public List<Disciplina> getCadastroFunc(@PathVariable String nome){
		return disciplinarepository.findByNome(nome);
		
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
	
	@ApiOperation(value = "Altera o numero de vagas maxima de uma disciplina, passando o nome como parametro. Retorna a insercao.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{nome}")
	public Disciplina updateCadastro(@RequestBody Disciplina cadastro, @PathVariable String nome) {
		
		Disciplina d = (Disciplina) disciplinarepository.findByNome(nome);
		
		if(d == null) {
			return null;
		}else {
			d.setVagasmax(cadastro.getVagasmax());
			return disciplinarepository.save(d);
		}
	}
	
	@ApiOperation(value = "Deletar algum estudante", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		disciplinarepository.deleteById(id);
	}


}
