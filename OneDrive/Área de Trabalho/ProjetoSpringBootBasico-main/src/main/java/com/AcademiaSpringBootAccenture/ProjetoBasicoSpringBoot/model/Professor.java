package com.AcademiaSpringBootAccenture.ProjetoBasicoSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idprofessor;
	private String nome;
	private String cpf;
	private int idade;
	private double salario;
}
