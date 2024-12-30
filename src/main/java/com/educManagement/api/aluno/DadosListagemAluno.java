package com.educManagement.api.aluno;

public record DadosListagemAluno(Long id, String nome, String email) {
    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail());
    }
}
