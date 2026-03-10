package com.b33T3ch.projeto_clinica_pilates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.b33T3ch.projeto_clinica_pilates.model.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

}
