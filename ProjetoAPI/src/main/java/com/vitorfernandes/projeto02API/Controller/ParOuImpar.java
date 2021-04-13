package com.vitorfernandes.projeto02API.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vitorfernandes.projeto02API.Models.ParImpar;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/parimpar")
public class ParOuImpar {
	
	@ApiOperation(value = "Este numero é par?", response = Iterable.class, tags = "parimpar")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public boolean num(@RequestBody int num) {
		ParImpar parimpar = new ParImpar();
		parimpar.setEhpar(num);
		boolean resp = parimpar.getEhpar();
		return resp;
		
	}

}
