package com.vitor.Ex2API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Estudante {
	
	//@ApiModelProperty(notes = "ID do individuo", name="id", required = true )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@ApiModelProperty(notes = "Nome", name="nome")
	@Column(nullable = false)
	private String nome;
	
	//@ApiModelProperty(notes = "Email", name="email")
	@Column(nullable = false)
	private String email;
	
	//@ApiModelProperty(notes = "Matricula", name="matricula")
	@Column(nullable = false)
	private String matricula;
	
	//@ApiModelProperty(notes = "Nacionalidade", name="nacionalidade")
	@Column(nullable = false)
	private String nacionalidade;
	
	//@ApiModelProperty(notes = "Niver", name="niver")
	@Column(nullable = false)
	private String niver;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNiver() {
		return niver;
	}

	public void setNiver(String niver) {
		this.niver = niver;
	}
	
	
}
