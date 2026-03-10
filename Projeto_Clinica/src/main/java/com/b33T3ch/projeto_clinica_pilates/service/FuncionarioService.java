package com.b33T3ch.projeto_clinica_pilates.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.b33T3ch.projeto_clinica_pilates.dto.Funcionario.FuncionarioRequest;
import com.b33T3ch.projeto_clinica_pilates.dto.Funcionario.FuncionarioResponse;
import com.b33T3ch.projeto_clinica_pilates.model.FuncionarioModel;
import com.b33T3ch.projeto_clinica_pilates.repository.FuncionarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {
	
	private FuncionarioRepository FuncionarioRepository;

	public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
		this.FuncionarioRepository = FuncionarioRepository;
	}	

	public FuncionarioResponse create(FuncionarioRequest resquest) {
		//Criar o Funcionario com base no corpo da requisição usando builder do lombok.

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		FuncionarioModel Funcionario = FuncionarioModel.builder()
				.nome(resquest.nome())
				.cpf(resquest.cpf())
				.dataDeNascimento(LocalDate.parse(resquest.dataDeNascimento(), formatter))
				.sexo(resquest.sexo())
				.email(resquest.email())
				.telefone(resquest.telefone())
				.funcao(resquest.funcao())
				.ativo(resquest.ativo())
				.residencia(resquest.residencia())
				.endereco((resquest.endereco()))
				.build();
		
				//salvo o Funcionario no banco de dados.
		FuncionarioModel salvo = FuncionarioRepository.save(Funcionario);
		return toResponse(salvo);
	}

	public List<FuncionarioResponse> findAll() {
		
		//procura todos os funcionarios no banco de dados, converte para resposta e retorna a lista de funcionarios.
		List<FuncionarioResponse> response = FuncionarioRepository.findAll()
			.stream()
			.map(this::toResponse)
			.toList();
		return response;
	}

	public FuncionarioResponse findById(Long id){
		//procure pelo id do Funcionario
		Optional<FuncionarioModel> FuncionarioOptional = FuncionarioRepository.findById(id);
		if(FuncionarioOptional.isEmpty()){
			//se não achar no banco, exception de entidade não encotrada.
			throw new EntityNotFoundException("Funcionario não encontrado");
		}
		return toResponse(FuncionarioOptional.get());
	}

	//Metodo para atualizar dados de um funcionario.
	public FuncionarioResponse update(Long id, FuncionarioRequest request) {
		Optional<FuncionarioModel> FuncionarioOptional = FuncionarioRepository.findById(id);
		if(FuncionarioOptional.isEmpty()){
			throw new EntityNotFoundException("Funcionario não encontrado");
		}
		FuncionarioModel Funcionario = FuncionarioOptional.get();
		Funcionario.setNome(request.nome());
		Funcionario.setEmail(request.email());
		Funcionario.setTelefone(request.telefone());
		Funcionario.setFuncao(request.funcao());
		Funcionario.setAtivo(request.ativo());
		Funcionario.setResidencia(request.residencia());
		Funcionario.setEndereco(request.endereco());

		FuncionarioModel atualizado = FuncionarioRepository.save(Funcionario);
		
		return toResponse(atualizado);
		
	}
	public void delete(Long id) {
		Optional<FuncionarioModel> FuncionarioOptional = FuncionarioRepository.findById(id);
		if(FuncionarioOptional.isEmpty()){
			throw new EntityNotFoundException("Funcionario não encontrado");
		}
		FuncionarioRepository.delete(FuncionarioOptional.get());
	}
	
	//resposta para o cliente.
	private FuncionarioResponse toResponse(FuncionarioModel Funcionario) {
		return new FuncionarioResponse(
				Funcionario.getNome(),
				Funcionario.getCpf(),
				Funcionario.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				Funcionario.getSexo(),
				Funcionario.getEmail(),
				Funcionario.getTelefone(),
				Funcionario.getFuncao(),
				Funcionario.getAtivo(),
				Funcionario.getResidencia(),
				Funcionario.getEndereco()
				);
	}
}
