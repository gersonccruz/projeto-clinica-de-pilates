package com.b33T3ch.projeto_clinica_pilates.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_FUNCIONARIOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/*
	Classe para modelo de FUNCIONARIOS, onde serão armazenados dados dos FUNCIONARIOS de atendimento
	da clínica de pilates.
*/

public class FuncionarioModel {
	
	//Id sendo gerado de forma sequencial (1,2,3...)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	/*
		Nenhuma das colunas abaixo podem ser nulas.
		o email obviamente deve ser único. Não invetem moda.
	*/

	@Column(nullable = false)
	private String nome;

	@Column
	private LocalDate dataDeNascimento;

	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String funcao;
	
	@Column(nullable = false)
	private Boolean ativo;

	@Column
	private Boolean residencia;

	@Column
	private String endereco;
}
