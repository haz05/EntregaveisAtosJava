package com.vitor.Ex2API.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vitor.Ex2API.Models.Disciplina;
import com.vitor.Ex2API.Models.Estudante;
import com.vitor.Ex2API.Models.Matricula;

@Repository
public interface MatriculadoRepository extends JpaRepository<Matricula, Long>{
	
	public long countByDisciplina(Disciplina disciplina);
	public long countByDisciplinaAndEstudante(Disciplina disciplina, Estudante estudante);
	public Matricula findByDisciplinaAndEstudante(Optional<Disciplina> disciplina, Optional<Estudante> estudante);
	public List<Matricula> findByEstudante(Optional<Estudante> estudante);
}
