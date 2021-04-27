package com.vitor.Ex2API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Disciplina {
	
	//@ApiModelProperty(notes = "ID do individuo", name="id", required = true )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@ApiModelProperty(notes = "Nome da disciplina", name="nome")
	@Column(nullable = false)
	private String nome;
	
	//@ApiModelProperty(notes = "Numero de vagas maximo", name="vagasmax")
	@Column(nullable = false)
	private Integer vagasmax;
	
	@Column(nullable = false)
	private int vagasdisp;

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

	public Integer getVagasmax() {
		return vagasmax;
	}

	public void setVagasmax(Integer vagasmax) {
		this.vagasmax = vagasmax;
	}

	public int getVagasdisp() {
		return vagasdisp;
	}

	public void setVagasdisp(int vagasdisp) {
		this.vagasdisp = vagasdisp;
	}

}
