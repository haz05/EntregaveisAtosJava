package com.vfbp.ProjetoFinalVitorFernandes.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class ProdutoModel {
	
	@ApiModelProperty(notes = "ID do produto", name="id", required = true )
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(notes = "Denominacao do produto", name="denominacao")
	@Column(nullable = false)
	private String denominacao;
	
	@ApiModelProperty(notes = "Codigo do produto", name="codigo")
	@Column(nullable = false)
	private String codigo;
	
	@ApiModelProperty(notes = "Preco do produto", name="preco")
	@Column(nullable = false)
	private float preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
