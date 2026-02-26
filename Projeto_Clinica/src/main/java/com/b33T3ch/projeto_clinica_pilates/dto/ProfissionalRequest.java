package com.b33T3ch.projeto_clinica_pilates.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfissionalRequest(
		@NotBlank(message = "Campo obrigátorio")
		String nome,
		
		@Email(message = "E-mail inválido")
		@NotBlank(message = "Campo Obrigátorio")
		String email,
		
		@NotBlank(message = "Campo Obrigátorio")
		String telefone,
		
		@NotBlank(message = "Campo Obrigátorio")
		String especialidade,
		
		@NotNull(message = "Campo Obrigátorio")
		Boolean ativo,

		@NotNull(message = "Campo Obrigátorio")
		Boolean residencia
		) {
		
}
