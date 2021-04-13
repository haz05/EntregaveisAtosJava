package com.vitorfernandes.projeto02API.Models;

import javax.persistence.Column;

import io.swagger.annotations.ApiModelProperty;

public class Transforma {
	
	@ApiModelProperty(notes = "temperatura em celsius", name="cel")
	@Column(nullable = false)
	private float cel;

	public float getCel() {
		float temp= 5*(cel-32)/9;
		return temp;
	}

	public void setCel(float cel) {
		this.cel = cel;
	}

	

	

}
