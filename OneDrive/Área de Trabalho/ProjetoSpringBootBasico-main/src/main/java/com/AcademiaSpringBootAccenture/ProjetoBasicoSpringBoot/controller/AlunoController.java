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
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.AlunoRepository;

@RestController
@RequestMapping(value="/users")
public class AlunoController {

	@Autowired
	private AlunoRepository alunorepository;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public AlunoController(@Valid AlunoRepository alunorepository){
		this.alunorepository=alunorepository;
	}
	
	@GetMapping("/viewAlunos")
    public List<Aluno> viewAlunos() {
        return this.alunorepository.findAll();
    }
	
	
	//fazer depois
	@GetMapping("/viewAluno/{id}")
    public Optional <Aluno> viewAluno(@PathVariable("id") int idaluno) {
        return this.alunorepository.findById(idaluno);
    }
	
	@PutMapping("/updateAluno/{id}")
    public String updateAluno(@PathVariable("id") int idaluno, @RequestBody Aluno novoaluno) {
		Optional <Aluno> alunoAchado=this.alunorepository.findById(idaluno);
		if(alunoAchado.isPresent()) {
			Aluno aluno=alunoAchado.get();
			aluno.setIdaluno(novoaluno.getIdaluno());
			aluno.setNome(novoaluno.getNome());
			aluno.setCpf(novoaluno.getCpf());
			aluno.setIdade(novoaluno.getIdade());
			aluno.setCurso(novoaluno.getCurso());
			alunorepository.save(aluno);
			return "Aluno atualizado com sucesso!";
		}
		else {
			return "Aluno não encontrado!";
		}
    }
	
	@DeleteMapping("/deleteAluno/{id}")
    public String deleteAluno(@PathVariable("id") int idaluno) {
		alunorepository.deleteById(idaluno);
		return "Aluno excluído com sucesso!";
    }
	
	@PostMapping("/createAluno")
    public String createAluno(@RequestBody @Valid Aluno aluno) {
		alunorepository.save(aluno);
        return "Aluno inserido na lista com sucesso!";
    }
	
}
