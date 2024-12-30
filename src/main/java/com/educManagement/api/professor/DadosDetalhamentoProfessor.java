package com.educManagement.api.professor;

import com.educManagement.api.endereco.Endereco;

public record DadosDetalhamentoProfessor(Long id, String nome, String email, String cpf, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoProfessor (Professor professor) {
        this(professor.getID(), professor.getNome(), professor.getEmail(), professor.getCpf(), professor.getTelefone(), professor.getEspecialidade(), professor.getEndereco());

    }
}
