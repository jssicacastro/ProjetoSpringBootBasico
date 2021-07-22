package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
