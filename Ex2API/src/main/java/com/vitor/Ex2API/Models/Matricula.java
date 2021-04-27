package com.vitor.Ex2API.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import io.swagger.annotations.ApiModelProperty;
@Entity
public class Matricula {
	
	//@ApiModelProperty(notes = "ID do individuo", name="id", required = true )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@ApiModelProperty(notes = "Nome estudante", name="idDis")
	@ManyToOne
	private Disciplina disciplina;
	
	//@ApiModelProperty(notes = "Nome disciplina", name="idEst")
	@ManyToOne
	private Estudante estudante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	

}
