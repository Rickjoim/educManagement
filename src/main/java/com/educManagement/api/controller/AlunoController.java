package com.educManagement.api.controller;

import com.educManagement.api.aluno.*;
import jakarta.transaction.Transactional;
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
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroAluno dados, UriComponentsBuilder uribuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);
        var url = uribuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(url).body(new DadosDetalhamentoAluno(aluno));
    }


    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @GetMapping("/{nome}")
    public DadosListagemAluno busca(@PathVariable String nome) {
        var aluno = repository.findByNome(nome);
        if (aluno == null || aluno.getAtivo() != true) {
            throw new IllegalArgumentException("Aluno com nome " + nome + " não encontrado.");
        }
        return new DadosListagemAluno(aluno);
    }

    @Transactional
    @PutMapping
    public ResponseEntity atualizar(@RequestBody DadosatualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var aluno = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno com id " + id + " não encontrado."));
        repository.getReferenceById(id);
        aluno.excluir();
        return ResponseEntity.noContent().build();
    }

}
