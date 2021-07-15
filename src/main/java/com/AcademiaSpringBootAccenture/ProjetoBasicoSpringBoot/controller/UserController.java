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

import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Aluno;
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model.Professor;


@RestController
@RequestMapping(value="/users")
public class UserController {

	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@GetMapping("/viewAlunos")
    public List<Aluno> viewAlunos() {
        return alunos;
    }
	
	
	@GetMapping("/viewAluno/{cpf}")
    public Aluno viewAluno(@PathVariable("cpf") String cpf) {
        Aluno procurado = null;
        for (Aluno aux : alunos) {
        	if (aux.getCpf() == cpf) {
        		procurado = aux;
        	}
        }
        return procurado;
    }
	
	@PutMapping("/updateAluno")
    public String updateAluno(@PathVariable("cpf") String cpf, @RequestBody Aluno aluno) {
		for (Aluno aux : alunos) {
        	if (aux.getCpf() == cpf) {
        		aux = aluno;
        	}
        }
        return "Usuário atualizado com sucesso!";
    }
	
	@DeleteMapping("/deleteAluno")
    public void deleteAluno(@PathVariable("cpf") String cpf) {
		int posicao = -1;
		Aluno procurado=null;
		for (Aluno aux : alunos) {
			if(aux.getCpf().equals(cpf)) {
				posicao = alunos.indexOf(aux);
				procurado = aux;
				break;
			}
		}
		alunos.remove(posicao);
    }
	
	@PostMapping("/createAluno")
    public String createAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
        return "Aluno inserido na lista com sucesso!";
    }
	
private List<Professor> professores = new ArrayList<Professor>();
	
	@GetMapping("/viewProfessores")
    public List<Professor> viewProfessores() {
        return professores;
    }
	
	
	@GetMapping("/viewProfessor/{cpf}")
    public Professor viewProfessor(@PathVariable("cpf") String cpf) {
        Professor procurado = null;
        for (Professor aux : professores) {
        	if (aux.getCpf() == cpf) {
        		procurado = aux;
        	}
        }
        return procurado;
    }
	
	@PutMapping("/updateProfessor")
    public String updateProfessor() {
        return "Método UPDATE";
    }
	
	@DeleteMapping("/deleteProfessor")
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
		alunos.remove(posicao);
    }
	
	@PostMapping("/createProfessor")
    public String createProfessor(@RequestBody Professor professor) {
		professores.add(professor);
        return "Professor inserido na lista com sucesso!";
    }
}
