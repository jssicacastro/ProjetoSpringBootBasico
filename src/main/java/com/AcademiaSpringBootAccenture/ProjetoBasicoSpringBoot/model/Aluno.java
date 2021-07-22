package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

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
public class Aluno {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int aluno_id;
		
		@NotBlank(message = "o nome é obrigatório") 
		@Length(min = 0, max = 30, message = "O nome deverá ter no máximo {max} caracteres") 
		private String nome;	
		
		@CPF 
		private String cpf;
		
		@Positive(message="A idade deve ser válida") 
		private int idade;
		
		@ManyToOne
		@JoinColumn (name = "curso")
		private Curso curso;
}
