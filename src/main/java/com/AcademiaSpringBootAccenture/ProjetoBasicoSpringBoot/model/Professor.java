package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

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
public class Professor {

	private String nome;
	private String cpf;
	private int idade;
	private double salario;
}
