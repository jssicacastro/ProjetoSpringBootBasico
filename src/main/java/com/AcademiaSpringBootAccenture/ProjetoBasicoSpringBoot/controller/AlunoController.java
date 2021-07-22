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
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.AlunoRepository;

@RestController
@RequestMapping(value="/users")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public AlunoController(@Valid AlunoRepository alunoRepository){
		this.alunoRepository=alunoRepository;
	}
	
	@GetMapping("/viewAlunos")
    public List<Aluno> viewAlunos() {
        return this.alunoRepository.findAll();
    }
	
	@GetMapping("/viewAluno/{id}")
    public String viewAluno(@PathVariable("id") int aluno_id) {
		Optional <Aluno> alunoAchado = this.alunoRepository.findById(aluno_id);
        
        if (alunoAchado.isPresent()) {
        	return alunoAchado.toString();
        }else {
        	return "Aluno não encontrado no banco de dados!";
        }
    }
	
	@PutMapping("/updateAluno/{id}")
    public String updateAluno(@PathVariable("id") int aluno_id, @RequestBody Aluno novoaluno) {
		Optional <Aluno> alunoAchado=this.alunoRepository.findById(aluno_id);
		if(alunoAchado.isPresent()) {
			Aluno aluno=alunoAchado.get();
			aluno.setNome(novoaluno.getNome());
			aluno.setCpf(novoaluno.getCpf());
			aluno.setIdade(novoaluno.getIdade());
			aluno.setCurso(novoaluno.getCurso());
			alunoRepository.save(aluno);
			return "Aluno atualizado com sucesso!";
		}
		else {
			return "Aluno não encontrado no banco de dados!";
		}
    }
	
	@DeleteMapping("/deleteAluno/{id}")
    public String deleteAluno(@PathVariable("id") int aluno_id) {
		Optional <Aluno> alunoAchado=this.alunoRepository.findById(aluno_id);
		if(alunoAchado.isPresent()) {
			this.alunoRepository.deleteById(aluno_id);
			return "Aluno excluído com sucesso!";
		}else {
			return "Aluno não encontrado no banco de dados!";
		}
		
    }
	
	@PostMapping("/createAluno")
    public String createAluno(@RequestBody @Valid Aluno aluno) {
		alunoRepository.save(aluno);
        return "Aluno inserido no banco de dados com sucesso!";
    }
	
}
