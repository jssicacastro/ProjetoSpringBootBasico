package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Professor;

@RestController
@RequestMapping(value="/users")
public class ProfessorController {
	
	private List<Professor> professores = new ArrayList<Professor>();
	
	@GetMapping("/viewProfessores")
    public List<Professor> viewProfessores() {
        return professores;
    }
	
	
	@GetMapping("/viewProfessor/{cpf}")
    public Professor viewProfessor(@PathVariable("cpf") String cpf) {
        Professor procurado = null;
        for (Professor aux : professores) {
        	if (aux.getCpf().equals(cpf)) {
        		procurado = aux;
        	}
        }
        return procurado;
    }
	
	@PutMapping("/updateProfessor/{cpf}")
    public void updateProfessor(@PathVariable("cpf") String cpf, @RequestBody Professor professor) {
		for (int i=0 ; i < professores.size(); i++) {
			Professor aux = professores.get(i);
        	if (aux.getCpf().equals(cpf)) {
        		professores.set(i, professor);
        		System.out.println("Professor atualizado com sucesso!");
        	}
        }
		
    }
	
	@DeleteMapping("/deleteProfessor/{cpf}")
    public void deleteProfessor(@PathVariable("cpf") String cpf) {
		int posicao = -1;
		Professor procurado=null;
		for (Professor aux : professores) {
			if(aux.getCpf().equals(cpf)) {
				posicao = professores.indexOf(aux);
				procurado = aux;
				break;
			}
		}
		professores.remove(posicao);
    }
	
	@PostMapping("/createProfessor")
    public String createProfessor(@RequestBody Professor professor) {
		professores.add(professor);
        return "Professor inserido na lista com sucesso!";
    }
}
