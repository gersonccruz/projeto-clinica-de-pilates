package com.b33T3ch.projeto_clinica_pilates.dto.Funcionario;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuncionarioRequest(
		@NotBlank(message = "Campo obrigátorio")
		String nome,

		@NotBlank(message = "Campo obrigátorio")
		@CPF(message = "CPF inválido")
		String cpf,

		@JsonFormat(pattern = "dd/MM/yyyy")
		String dataDeNascimento,

		@Email(message = "E-mail inválido")
		@NotBlank(message = "Campo Obrigátorio")
		String email,
		
		@NotBlank(message = "Campo Obrigátorio")
		String sexo,

		@NotBlank(message = "Campo Obrigátorio")
		String telefone,
		
		@NotBlank(message = "Campo Obrigátorio")
		String funcao,
		
		@NotNull(message = "Campo Obrigátorio")
		Boolean ativo,

		@NotNull(message = "Campo Obrigátorio")
		Boolean residencia,

		@NotBlank(message = "Campo Obrigátorio")
		String endereco
		) {
		
}
