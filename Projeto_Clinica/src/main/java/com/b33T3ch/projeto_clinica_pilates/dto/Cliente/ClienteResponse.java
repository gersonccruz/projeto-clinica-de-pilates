package com.b33T3ch.projeto_clinica_pilates.dto.Cliente;

public record ClienteResponse(
    String nome,
    String cpf,
    String email,
    String telefone,
    String dataDeNascimento,
    String endereco
) {
    
}