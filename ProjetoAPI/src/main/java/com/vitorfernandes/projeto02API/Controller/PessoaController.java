//http://localhost:8080/swagger-ui.html    

package com.vitorfernandes.projeto02API.Controller;

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
import com.vitorfernandes.projeto02API.Models.ParImpar;
import com.vitorfernandes.projeto02API.Models.Pessoa;
import com.vitorfernandes.projeto02API.Models.Transforma;
import com.vitorfernandes.projeto02API.Repositories.CidadeRepository;
import com.vitorfernandes.projeto02API.Repositories.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/teste")
public class PessoaController {

	
	
	
	/*
	 
	@Autowired
	private PessoaRepository pessoarepository;
	
	@ApiOperation(value = "Retorna as pessoas cadastradas", response = Iterable.class, tags = "getPessoas")
	@GetMapping
	public List<Pessoa> getPessoas(){
		return pessoarepository.findAll();
	}
	
	@ApiOperation(value = "Cadastra uma nova pessoa e recebe-a como retorno", response = Iterable.class, tags = "adicionar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		
		return pessoarepository.save(pessoa);
		
	}
	
	@ApiOperation(value = "Retorna as pessoas cadastradas, passando como parametro o ID", response = Iterable.class, tags = "getPessoa")
	@GetMapping("/{id}")
	public Optional<Pessoa> getPessoa(@PathVariable Long id) {
		try {
			
			return pessoarepository.findById(id);	
		}catch(Exception e){
			return null;
		}
	}
	
	@ApiOperation(value = "Deletar alguma pessoa", response = Iterable.class, tags = "deletePessoas")
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Long id) {
		pessoarepository.deleteById(id);
		
	}
	
	@ApiOperation(value = "Altera uma pessoa, recebendo uma pessoa e o ID por parametro. Retorna a nova pessoa.", response = Iterable.class, tags = "alterar")
	@PutMapping("/{id}")
	public Pessoa updatePessoa(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		
		Pessoa p = pessoarepository.getOne(id);
		
		if(p == null) {
			return null;
		}else {
			p.setNome(pessoa.getNome());
			return pessoarepository.save(p);
		}
	}
	*/
	

}
