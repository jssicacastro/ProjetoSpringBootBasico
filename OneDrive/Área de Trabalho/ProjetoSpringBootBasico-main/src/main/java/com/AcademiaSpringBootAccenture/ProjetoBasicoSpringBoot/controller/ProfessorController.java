package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Aluno;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Professor;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.AlunoRepository;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.ProfessorRepository;

@RestController
@RequestMapping(value="/users")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorrepository;
	private List<Professor> professores = new ArrayList<Professor>();
	
	public ProfessorController( ProfessorRepository professorrepository){
		this.professorrepository=professorrepository;
	}
	
	@GetMapping("/viewProfessores")
    public List<Professor> viewProfessores() {
		return this.professorrepository.findAll();
    }
	
	
	@GetMapping("/viewProfessor/{id}")
	public Optional <Professor> viewProfessor(@PathVariable("id") int idprofessor) {
        return this.professorrepository.findById(idprofessor);
    }
	
	@PutMapping("/updateProfessor/{id}")
    public String updateProfessor(@PathVariable("id") int idprofessor, @RequestBody Professor novoprofessor) {
		Optional <Professor> professorAchado=this.professorrepository.findById(idprofessor);
		if(professorAchado.isPresent()) {
			Professor professor=professorAchado.get();
			professor.setIdprofessor(novoprofessor.getIdprofessor());
			professor.setNome(novoprofessor.getNome());
			professor.setCpf(novoprofessor.getCpf());
			professor.setIdade(novoprofessor.getIdade());
			professor.setSalario(novoprofessor.getSalario());
			professorrepository.save(professor);
			return "professor atualizado com sucesso!";
		}
		else {
			return "professor não encontrado!";
		}
		
    }
	
	@DeleteMapping("/deleteProfessor/{id}")
    public String deleteProfessor(@PathVariable("id") int idprofessor) {
		professorrepository.deleteById(idprofessor);
		return "Professor removido com sucesso!";
    }
	
	@PostMapping("/createProfessor")
    public String createProfessor(@RequestBody @Valid Professor professor) {
		professorrepository.save(professor);
        return "Professor inserido na lista com sucesso!";
    }
}
