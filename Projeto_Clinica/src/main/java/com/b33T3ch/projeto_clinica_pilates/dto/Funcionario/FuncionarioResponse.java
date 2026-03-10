package com.b33T3ch.projeto_clinica_pilates.dto.Funcionario;

public record FuncionarioResponse(
		String nome,
		String cpf,
		String dataDeNascimento,
		String sexo,
		String email,
		String telefone,
		String funcao,
		Boolean ativo,
		Boolean residencia,
		String endereco
		) {
}
