package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

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
@GroupSequence(Professor.class)
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;		
	
	@NotBlank(message = "o nome é obrigatório") 
	@Length(min = 3, max = 30, message = "O nome deverá ter no máximo {max} caracteres")
	private String nome;
	
	@CPF(message="O CPF deve ser válido") 
	private String cpf;
	
	@Positive(message="A idade deve ser válida") 
	private int idade;
	
	@PositiveOrZero(message="O salário deve ser válido") 
	private double salario;
}
