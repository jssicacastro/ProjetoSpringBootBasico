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

	//Controller de Alunos
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	@GetMapping("/viewAlunos")
    public List<Aluno> viewAlunos() {
        return alunos;
    }
	
	
	@GetMapping("/viewAluno/{cpf}")
    public Aluno viewAluno(@PathVariable("cpf") String cpf) {
        Aluno procurado = null;
        for (Aluno aux : alunos) {
        	if (aux.getCpf().equals(cpf)){
        		procurado = aux;
        		System.out.println(procurado.toString());
        	}
        }
        return procurado;
    }
	
	@PutMapping("/updateAluno/{cpf}")
    public void updateAluno(@PathVariable("cpf") String cpf, @RequestBody Aluno aluno) {
		for (int i=0 ; i < alunos.size(); i++) {
			Aluno aux = alunos.get(i);
        	if (aux.getCpf().equals(cpf)) {
        		alunos.set(i, aluno);
        		System.out.println("Aluno atualizado com sucesso!");
        	}
        }
    }
	
	@DeleteMapping("/deleteAluno/{cpf}")
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
	
	
	//Controller de Professores	
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
