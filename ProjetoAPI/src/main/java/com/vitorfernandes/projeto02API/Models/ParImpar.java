package com.vitorfernandes.projeto02API.Models;

import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;

public class ParImpar {
	
	@ApiModelProperty(notes = "temperatura em celsius", name="cel")
	@Column(nullable = false)
	private int ehpar;

	public boolean getEhpar() {
		int resp = ehpar % 2;	
		if (resp == 0) {
			return true;
		}else {
			return false;
		}
		
		
	}

	public void setEhpar(int ehpar) {
		this.ehpar = ehpar;
	}
	

}
