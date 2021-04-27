//http://localhost:8080/swagger-ui.html
package com.vitor.Ex2API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex2ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex2ApiApplication.class, args);
	}

}
/*
A API deve cadastrar um estudante, contendo os dados necessários, como email, matrícula, data de nascimento e nacionalidade. ok
A API permite alterar e excluir o aluno se as restrições do banco de dados permitirem. ok 
A API permite listar as disciplinas ofertadas e o número máximo de vagas e as vagas disponíveis ok
A API permite ao aluno se matricular e cancelar uma disciplina, isso afeta as vagas disponiveis. ok
A API deve listar os dados do estudante juntamente com as disciplinas matriculadas. ok
*/