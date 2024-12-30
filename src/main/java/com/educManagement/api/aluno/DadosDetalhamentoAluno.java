package com.educManagement.api.aluno;

import com.educManagement.api.endereco.Endereco;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String telefone, Endereco endereco) {
    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getEndereco());

    }
}
