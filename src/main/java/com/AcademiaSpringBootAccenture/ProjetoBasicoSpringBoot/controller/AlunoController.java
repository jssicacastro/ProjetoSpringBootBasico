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

@RestController
@RequestMapping(value="/users")
public class AlunoController {

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
	
}