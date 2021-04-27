package com.vitor.Ex2API.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.Ex2API.Models.Disciplina;
import com.vitor.Ex2API.Models.Estudante;
import com.vitor.Ex2API.Models.Matricula;
import com.vitor.Ex2API.Repositories.DisciplinaRepository;
import com.vitor.Ex2API.Repositories.DisciplinaRepository2;
import com.vitor.Ex2API.Repositories.EstudanteRepository;
import com.vitor.Ex2API.Repositories.EstudanteRepository2;
import com.vitor.Ex2API.Repositories.MatriculadoRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de Matriculas")
@RestController
@RequestMapping("/cadastroMatricula")
public class MatriculaCadastro {
	
	@Autowired
	private MatriculadoRepository matricularepository;
	
	@Autowired
	private DisciplinaRepository disciplinarepository;
	
	@Autowired
	private EstudanteRepository estudanterepository;
	
	@Autowired
	private DisciplinaRepository2 disciplinarepository2;
	
	@Autowired
	private EstudanteRepository2 estudanterepository2;
	
	
	@ApiOperation(value = "Retorna todas as Matriculas", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/matriculas")
	public List<Matricula> getMatriculas() 
	{
		return matricularepository.findAll();
	}
	/*
	@ApiOperation(value = "Retorna todas as Matriculas", response = Iterable.class, tags = "matriculas")
	@GetMapping("/matriculas")
	public List<Matricula> getVagas() 
	{
		return matricularepository.findAll();
	}
	*/
	@ApiOperation(value = "Grava uma matrícula", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/matricular")
	public Matricula add(@RequestParam Long idDisciplina, @RequestParam Long idEstudante) 
	{
		try {

			Optional<Disciplina> disciplina = disciplinarepository.findById(idDisciplina);

			Optional<Estudante> estudante = estudanterepository.findById(idEstudante);
			
			Matricula matricula = new Matricula();
			matricula.setEstudante(estudante.get());
			matricula.setDisciplina(disciplina.get());

			long vagas = disciplina.get().getVagasmax() 
					- matricularepository.countByDisciplina(disciplina.get());
			
			if(vagas == 0)
			{
				return null;
			}
			
			if(matricularepository.countByDisciplinaAndEstudante(disciplina.get(), estudante.get()) > 0)
			{
				return null;
			}
			
			Matricula m = matricularepository.save(matricula);
			
			Disciplina d = disciplinarepository.getOne(idDisciplina);
			d.setVagasdisp((int)vagas-1);
			disciplinarepository.save(d);
			return m;

		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	/*
	@ApiOperation(value = "Grava uma matrícula pelo nome da disciplina e do aluno", response = Iterable.class, tags = "Cadastrar")
	@PostMapping("/matricularPorNome")
	public Matricula cadastroPorNome(@PathVariable String NomeDisciplina, @PathVariable String NomeEstudante) 
	{
		try {

			Optional<Disciplina> disciplina = disciplinarepository2.findByNome(NomeEstudante);

			Optional<Estudante> estudante = estudanterepository2.findByNome(NomeEstudante);

			Matricula matricula = new Matricula();
			matricula.setEstudante(estudante.get());
			matricula.setDisciplina(disciplina.get());

			long vagas = disciplina.get().getVagasmax() 
					- matricularepository.countByDisciplina(disciplina.get());
			
			if(vagas == 0)
			{
				return null;
			}
			
			if(matricularepository.countByDisciplinaAndEstudante(disciplina.get(), estudante.get()) > 0)
			{
				return null;
			}
			
			Matricula m = matricularepository.save(matricula);
			return m;

		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	*/
	@ApiOperation(value = "Deletar alguma matricula passando o id da matricula", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/{id}")
	public void deleteMatricula(@PathVariable Long id) {
		
		Matricula m = matricularepository.getOne(id);
		Disciplina d = m.getDisciplina();
		long vagas = d.getVagasdisp();
		d.setVagasdisp((int)vagas+1);
		disciplinarepository.save(d);
		
		matricularepository.deleteById(id);
		
	}
	
	@ApiOperation(value = "Deletar alguma matricula passando o id do estudante e da matricula", response = Iterable.class, tags = "deletecadastro")
	@DeleteMapping("/deleteMatricula")
	public void deleteMatriculaPorNome(@RequestParam Long idDisciplina, @RequestParam Long idEstudante)  {
		
		Optional<Disciplina> disciplina = disciplinarepository.findById(idDisciplina);
		Optional<Estudante> estudante = estudanterepository.findById(idEstudante);
		
		Matricula matricula = matricularepository.findByDisciplinaAndEstudante(disciplina, estudante);
		long id = matricula.getId();
		//Matricula m = matricularepository.getOne(id);
		
		long vagas = disciplina.get().getVagasdisp();
		
		Disciplina d = disciplinarepository.getOne(idDisciplina);
		d.setVagasdisp((int)vagas+1);
		disciplinarepository.save(d);
		
		matricularepository.deleteById(id);
		
	}

	@ApiOperation(value = "Retorna o estudante e suas matriculas", response = Iterable.class, tags = "getCadastro")
	@GetMapping("/getEstudantesComMatricula")
	public List getEstudanteComMatricula(@RequestParam Long idEstudante){
		
		Optional<Estudante> estudante = estudanterepository.findById(idEstudante);

		List<Matricula> listamatricula = matricularepository.findByEstudante(estudante);
		
		ArrayList<String> listadisciplina = new ArrayList();
		for(Matricula m:listamatricula) {
			String var = m.getDisciplina().getNome();
			
			listadisciplina.add(var);
		}
		
		
		
		ArrayList lista = new ArrayList();
		lista.add(estudante.get().getId());
		lista.add(estudante.get().getNome());
		lista.add(estudante.get().getEmail());
		lista.add(estudante.get().getMatricula());
		lista.add(estudante.get().getNacionalidade());
		lista.add(estudante.get().getNiver());
		
		lista.add(listadisciplina);
		
		//List var = estudanterepository.findAll() +listamatricula;
		return lista;
	}
}
