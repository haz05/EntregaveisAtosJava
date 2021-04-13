package com.vitorfernandes.projeto02API.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vitorfernandes.projeto02API.Models.Transforma;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Swagger2RestController",
description = "REST APIs relacionada ao cadastro de PESSOAS")
@RestController
@RequestMapping("/temp")
public class ConverteTemp {
	
	@ApiOperation(value = "Envia temp em fahrenheit e retorne em celsius.", response = Iterable.class, tags = "temp")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public float temp(@RequestBody float temp) {
		Transforma transforma = new Transforma();
		transforma.setCel(temp);
		float resp = transforma.getCel();
		return resp;
		
	}

}
