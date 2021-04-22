package br.vfbp.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "precificacao2")
public class Precificacao extends GenericDomain {
	@Column(length = 15, nullable = false)
	private String codigo;
	@Column(length = 200, nullable = false)
	private String denominacao;
	@Column(nullable = false)
	private float Preco;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public float getPreco() {
		return Preco;
	}

	public void setPreco(float preco) {
		Preco = preco;
	}

}
