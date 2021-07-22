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
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Curso;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Professor;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.AlunoRepository;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.ProfessorRepository;

@RestController
@RequestMapping(value="/users")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
	private List<Professor> professores = new ArrayList<Professor>();
	
	public ProfessorController( ProfessorRepository professorRepository){
		this.professorRepository=professorRepository;
	}
	
	@GetMapping("/viewProfessores")
    public List<Professor> viewProfessores() {
		return this.professorRepository.findAll();
    }
	
	
	@GetMapping("/viewProfessor/{id}")
	public String viewProfessor(@PathVariable("id") int professor_id) {
		Optional <Professor> professorAchado = this.professorRepository.findById(professor_id);
        
        if (professorAchado.isPresent()) {
        	return professorAchado.toString();
        }else {
        	return "Professor não encontrado no banco de dados!";
        }
    }
	
	@PutMapping("/updateProfessor/{id}")
    public String updateProfessor(@PathVariable("id") int professor_id, @RequestBody Professor novoprofessor) {
		Optional <Professor> professorAchado=this.professorRepository.findById(professor_id);
		if(professorAchado.isPresent()) {
			Professor professor=professorAchado.get();
			professor.setNome(novoprofessor.getNome());
			professor.setCpf(novoprofessor.getCpf());
			professor.setIdade(novoprofessor.getIdade());
			professor.setSalario(novoprofessor.getSalario());
			professorRepository.save(professor);
			return "professor atualizado com sucesso!";
		}
		else {
			return "Professor não encontrado no banco de dados!";
		}
		
    }
	
	@DeleteMapping("/deleteProfessor/{id}")
    public String deleteProfessor(@PathVariable("id") int professor_id) {
		Optional <Professor> professorAchado = this.professorRepository.findById(professor_id);
        
        if (professorAchado.isPresent()) {
        	professorRepository.delete(professorAchado.get());
        	return "Professor removido do banco de dados com sucesso!";
        }else {
        	return "Professor não encontrado no banco de dados!";
        }
    }
	
	@PostMapping("/createProfessor")
    public String createProfessor(@RequestBody @Valid Professor professor) {
		this.professorRepository.save(professor);
        return "Professor inserido na lista com sucesso!";
    }
}
