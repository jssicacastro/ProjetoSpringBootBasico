package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	@Entity
	@Table
public class Curso {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer curso_id;
		
		private String nome;
		
		@OneToMany(mappedBy = "curso")
		private List<Aluno> alunos;

}
