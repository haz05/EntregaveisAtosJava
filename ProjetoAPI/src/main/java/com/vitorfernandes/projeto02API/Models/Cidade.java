package com.vitorfernandes.projeto02API.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cidade {
	
	@ApiModelProperty(notes = "ID da pessoa", name="id", required = true )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Ano", name="ano")
	@Column(nullable = false)
	private String ano;
	
	@ApiModelProperty(notes = "quantidade populacional", name="quantidade Pupulacional")
	@Column(nullable = false)
	private String qnt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getQnt() {
		return qnt;
	}

	public void setQnt(String qnt) {
		this.qnt = qnt;
	}
	
	

}
