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

import com.vitor.Ex2API.Models.Estudante;
import com.vitor.Ex2API.Repositories.EstudanteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de Estudantes")
@RestController
@RequestMapping("/cadastroEstudante")
public class EstudanteCadastro {
	
	@Autowired
	private EstudanteRepository estudanterepository;
	
	@ApiOperation(value = "Cadastra um estudante", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Estudante adicionar(@RequestBody Estudante cadastro) {
		
		return estudanterepository.save(cadastro);
		
	}
	
	@ApiOperation(value = "Retorna os estudantes", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/cadastrar")
	public List<Estudante> getCadastro(){
		return estudanterepository.findAll();
	}
	
	@ApiOperation(value = "Retorna o estudante, passando como parametro o ID", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/{id}")
	public Optional<Estudante> getCadastro(@PathVariable Long id) {
		try {
			
			return estudanterepository.findById(id);	
		}catch(Exception e){
			return null;
		}
	}
	
	@ApiOperation(value = "Retorna o estudante, passando como parametro o nome", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/nome/{nome}")
	public List<Estudante> getCadastroFunc(@PathVariable String nome){
		return estudanterepository.findByNome(nome);
		
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
	
	@ApiOperation(value = "Altera um estudante, recebendo os dados e o nome para indentificar. Retorna a insercao.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{nome}")
	public Estudante updateCadastro(@RequestBody Estudante cadastro, @PathVariable String nome) {
		
		Estudante e = (Estudante) estudanterepository.findByNome(nome);
		
		if(e == null) {
			return null;
		}else {
			e.setEmail(cadastro.getEmail());
			e.setMatricula(cadastro.getMatricula());
			e.setNacionalidade(cadastro.getNacionalidade());
			e.setNiver(cadastro.getNiver());
			return estudanterepository.save(e);
		}
	}
	
	@ApiOperation(value = "Deletar algum estudante", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		estudanterepository.deleteById(id);
	}

}
