package com.b33T3ch.projeto_clinica_pilates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b33T3ch.projeto_clinica_pilates.dto.ProfissionalResponse;
import com.b33T3ch.projeto_clinica_pilates.dto.ProfissionalRequest;
import com.b33T3ch.projeto_clinica_pilates.model.ProfissionalModel;
import com.b33T3ch.projeto_clinica_pilates.repository.ProfissionalRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository profissionalRepository;

	public ProfissionalResponse create(ProfissionalRequest resquest) {
		//Criar o profissional com base no corpo da requisição usando builder do lombok.
		ProfissionalModel profissional = ProfissionalModel.builder()
				.nome(resquest.nome())
				.email(resquest.email())
				.telefone(resquest.telefone())
				.especialidade(resquest.especialidade())
				.ativo(resquest.ativo())
				.residencia(resquest.residencia())
				.build();
		
				//salvo o profissional no banco de dados.
		ProfissionalModel salvo = profissionalRepository.save(profissional);
		return toResponse(salvo);
	}

	public List<ProfissionalResponse> findAll() {
		
		//procura todos os profissionais no banco de dados, converte para resposta e retorna a lista de profissionais.
		List<ProfissionalResponse> response = profissionalRepository.findAll()
			.stream()
			.map(this::toResponse)
			.toList();
		return response;
	}

	public ProfissionalResponse findById(Long id){
		//procure pelo id do profissional
		Optional<ProfissionalModel> profissionalOptional = profissionalRepository.findById(id);
		if(profissionalOptional.isEmpty()){
			//se não achar no banco, exception de entidade não encotrada.
			throw new EntityNotFoundException("Profissional não encontrado");
		}
		return toResponse(profissionalOptional.get());
	}
	
	//resposta para o cliente.
	private ProfissionalResponse toResponse(ProfissionalModel profissional) {
		return new ProfissionalResponse(
				profissional.getId(),
				profissional.getNome(),
				profissional.getEmail(),
				profissional.getTelefone(),
				profissional.getEspecialidade(),
				profissional.getAtivo(),
				profissional.getResidencia()
				);
	}
}
