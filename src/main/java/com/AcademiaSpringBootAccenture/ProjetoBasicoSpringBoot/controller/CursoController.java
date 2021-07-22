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
import com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.repository.CursoRepository;

@RestController
@RequestMapping(value="/users")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public CursoController(@Valid CursoRepository cursoRepository){
		this.cursoRepository=cursoRepository;
	}
	
	@GetMapping("/viewCursos")
    public List<Curso> viewCursos() {
        return this.cursoRepository.findAll();
    }
	
	@GetMapping("/viewCurso/{id}")
    public Optional<Curso> viewCurso(@PathVariable("id") int curso_id) {
       return this.cursoRepository.findById(curso_id);
    }
	
	@PutMapping("/updateCurso/{id}")
    public String updateCurso(@PathVariable("id") int curso_id, @RequestBody Curso cursoAtt) {
		Optional <Curso> cursoAchado=this.cursoRepository.findById(curso_id);
		if(cursoAchado.isPresent()) {
			Curso curso = cursoAchado.get();
			curso.setNome(cursoAtt.getNome());
			
			this.cursoRepository.save(curso);
			return "Curso atualizado com sucesso!";
		}else {
			return "Curso não encontrado no banco de dados!";
		}
    }
	
	@DeleteMapping("/deleteCurso/{id}")
    public String deleteCurso(@PathVariable("id") int curso_id) {
		Optional <Curso> cursoAchado=this.cursoRepository.findById(curso_id);
		if(cursoAchado.isPresent()) {
			this.cursoRepository.delete(cursoAchado.get());
			return "Curso excluído do banco de dados com sucesso!";
		}else {
			return "Curso não encontrado no banco de dados!";
		}
    }
	
	@PostMapping("/createCurso")
    public String createCurso(@RequestBody @Valid Curso curso) {
		this.cursoRepository.save(curso);
        return "Curso inserido no banco de dados com sucesso!";
    }
}
