package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		private int idaluno;
		@NotBlank(message = "o nome é obrigatório") @Length(min = 0, max = 30, message = "O nome deverá ter no máximo {max} caracteres") private String nome;	
		@CPF private String cpf;
		@Positive(message="A idade deve ser válida") private int idade;
		@NotBlank(message = "o curso é obrigatório") private String curso;
}
