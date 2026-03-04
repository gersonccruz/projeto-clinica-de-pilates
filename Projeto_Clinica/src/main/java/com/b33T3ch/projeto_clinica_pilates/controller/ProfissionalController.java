package com.b33T3ch.projeto_clinica_pilates.controller;

import java.util.List;
import java.util.Optional;

import com.b33T3ch.projeto_clinica_pilates.dto.ProfissionalRequest;
import com.b33T3ch.projeto_clinica_pilates.dto.ProfissionalResponse;
import com.b33T3ch.projeto_clinica_pilates.model.ProfissionalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b33T3ch.projeto_clinica_pilates.repository.ProfissionalRepository;
import com.b33T3ch.projeto_clinica_pilates.service.ProfissionalService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/*
    Classe para controller de profissionais, onde serão criados os endpoints para lidar com os dados dos profissionais
    de atendimento da clínica de pilates. Cadastro, consulta, atualização e exclusão de profissionais serão feitos aqui.
    
*/

@Controller
@RequestMapping("/main")
public class ProfissionalController {

    @Autowired
    public ProfissionalService service;

    /*Endpoint para ver o profissional pelo id, onde o id é passado como parâmetro na URL 
     Se o profissional for encontrado, retorna os dados do profissional, caso contrário, retorna um erro 404.*/ 
    @GetMapping("/profissionais/{id}")
    public ResponseEntity<ProfissionalResponse> getProfissional(@PathVariable(value = "id") Long id) {
        try{
            //buscar o id do profissional.
            ProfissionalResponse response = service.findById(id);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e){
            //se não achar, devolve um 404 (not found)
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    //endpoint para listar todos os profissionais.
    @GetMapping("/profissionais/all")
    public ResponseEntity<List<ProfissionalResponse>> getAllProfissionais() {
        return ResponseEntity.ok(service.findAll());
    }
    //endopoint de registro dos profissionais.
    @PostMapping("/profissionais/register")
    public ResponseEntity<ProfissionalResponse> registerProfissional(@Valid @RequestBody ProfissionalRequest profissional){
        ProfissionalResponse response = service.create(profissional);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);
    }
}
