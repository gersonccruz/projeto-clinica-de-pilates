package com.b33T3ch.projeto_clinica_pilates.dto.Cliente;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(
    @NotBlank(message = "Campo obrigátorio")
    String nome,

    @NotBlank(message = "Campo obrigátorio")
    @CPF(message = "CPF inválido")
    String cpf,

    @NotBlank(message = "Campo Obrigátorio")
    String email,

    @NotBlank(message = "Campo Obrigátorio")
    String telefone,

    @JsonFormat(pattern = "dd/MM/yyyy")
    String dataDeNascimento,

    String endereco
) {
    
}
