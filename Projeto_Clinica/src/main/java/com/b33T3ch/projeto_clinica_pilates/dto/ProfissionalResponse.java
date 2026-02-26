package com.b33T3ch.projeto_clinica_pilates.dto;

public record ProfissionalResponse(
		Long id,
		String nome,
		String email,
		String telefone,
		String especialidade,
		Boolean ativo,
		Boolean residencia
		) {

}
