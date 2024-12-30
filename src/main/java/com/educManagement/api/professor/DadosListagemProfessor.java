package com.educManagement.api.professor;

public record DadosListagemProfessor(Long id, String nome, String email, String cpf, Especialidade especialidade) {
    public DadosListagemProfessor (Professor professor){
        this(professor.getID(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getEspecialidade());
    }
}
