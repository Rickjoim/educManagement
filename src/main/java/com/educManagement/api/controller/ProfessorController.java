package com.educManagement.api.controller;

import com.educManagement.api.professor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroProfessor dados, UriComponentsBuilder uribuilder) {
        var professor = new Professor(dados);
        repository.save(professor);
        var url = uribuilder.path("/professores/{id}").buildAndExpand(professor.getID()).toUri();
        return ResponseEntity.created(url).body(new DadosDetalhamentoProfessor(professor));
    }

    @GetMapping
    public Page<DadosListagemProfessor> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);
    }

    @GetMapping("/{cpf}")
    public DadosListagemProfessor busca(@PathVariable String cpf) {
        var professor = repository.findByCpf(cpf);
        if (professor == null || professor.getAtivo() != true) {
            throw new IllegalArgumentException("Professor com CPF (" + cpf + ") não encontrado.");
        }
        return new DadosListagemProfessor(professor);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoProfessor dados) {
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var professor = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor com id " + id + " não encontrado."));
        repository.getReferenceById(id);
        professor.excluir();
        return ResponseEntity.noContent().build();
    }

}
