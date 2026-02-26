package com.b33T3ch.projeto_clinica_pilates.model;

import javax.swing.text.StyledEditorKit.BoldAction;

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
@Table(name = "TB_PROFISSIONAIS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/*
	Classe para modelo de profissionais, onde serão armazenados dados dos profissionais de atendimento
	da clínica de pilates.
*/

public class ProfissionalModel {
	
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
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String especialidade;
	
	@Column(nullable = false)
	private Boolean ativo;

	@Column(nullable = false)
	private Boolean residencia;
}
