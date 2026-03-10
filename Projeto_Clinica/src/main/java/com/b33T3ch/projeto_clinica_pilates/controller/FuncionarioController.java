package com.b33T3ch.projeto_clinica_pilates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b33T3ch.projeto_clinica_pilates.dto.Funcionario.FuncionarioRequest;
import com.b33T3ch.projeto_clinica_pilates.dto.Funcionario.FuncionarioResponse;
import com.b33T3ch.projeto_clinica_pilates.service.FuncionarioService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

/*
    Classe para controller de funcionarios, onde serão criados os endpoints para lidar com os dados dos funcionarios
    de atendimento da clínica de pilates. Cadastro, consulta, atualização e exclusão de funcionarios serão feitos aqui.
    
*/

@RestController
@RequestMapping("/")
public class FuncionarioController {

    @Autowired
    public FuncionarioService service;

    /*Endpoint para ver o Funcionario pelo id, onde o id é passado como parâmetro na URL 
     Se o Funcionario for encontrado, retorna os dados do Funcionario, caso contrário, retorna um erro 404.*/ 
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponse> getFuncionario(@PathVariable(value = "id") Long id) {
        try{
            FuncionarioResponse response = service.findById(id);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    //endpoint para listar todos os funcionarios.
    @GetMapping("/funcionarios/all")
    public ResponseEntity<List<FuncionarioResponse>> getAllfuncionarios() {
        return ResponseEntity.ok(service.findAll());
    }
    //endopoint de registro dos funcionarios.
    @PostMapping("/funcionarios/register")
    public ResponseEntity<FuncionarioResponse> registerFuncionario(@Valid @RequestBody FuncionarioRequest Funcionario){
        FuncionarioResponse response = service.create(Funcionario);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);
    }

    @PutMapping("/funcionarios/update/{id}")
    public ResponseEntity<FuncionarioResponse> updateFuncionario(@PathVariable(value = "id") Long id, 
    @Valid @RequestBody FuncionarioRequest Funcionario){
        try{
            FuncionarioResponse response = service.update(id, Funcionario);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }

    @DeleteMapping("/funcionarios/delete/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable(value = "id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
    }
}
