package com.educManagement.api.controller;

import com.educManagement.api.aluno.Aluno;
import com.educManagement.api.aula.*;
import com.educManagement.api.aluno.AlunoRepository;
import com.educManagement.api.professor.Professor;
import com.educManagement.api.professor.ProfessorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarAula(@RequestBody DadosCadastroAula dados) {
        Professor professor = professorRepository.findById(dados.professorId())
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado"));
        Aluno aluno = alunoRepository.findById(dados.alunoId())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        Aula aula = new Aula(dados, professor, aluno);
        aulaRepository.save(aula);

        URI uri = URI.create("/aulas/" + aula.getId());
        return ResponseEntity.created(uri).body(aula);
    }

    @GetMapping
    public Page<DadosListagemAula> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return  aulaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemAula::new);
    }

    @GetMapping("/{id}")
    public DadosListagemAula buscarPorId(@PathVariable Long id) {
        var aula = aulaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aula com id " + id + " não encontrado."));

        if(aula.getAtivo()){
            return new DadosListagemAula(aula);
        }else{
            throw new IllegalArgumentException("Aula não encontrada");
        }


    }


    @PutMapping
    @Transactional
    public DadosAtualizacaoAula atualizarAula(@RequestBody DadosAtualizacaoAula dados) {
        var aula = aulaRepository.getReferenceById(dados.id());
        aula.atualizarInformacoes(dados);

        return new DadosAtualizacaoAula(dados.id(), dados.data(), dados.observacao(),dados.endereco());
    }


    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        var aula = aulaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula com id " + id + " não encontrada."));
        aulaRepository.getReferenceById(id);
        aula.excluir();
        return ResponseEntity.noContent().build();
    }
}
