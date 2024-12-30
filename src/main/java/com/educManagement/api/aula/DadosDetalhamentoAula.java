package com.educManagement.api.aula;

import com.educManagement.api.aluno.Aluno;
import com.educManagement.api.endereco.Endereco;
import com.educManagement.api.professor.Professor;

import java.util.Date;

public record DadosDetalhamentoAula(Long id, Date data, String observacao, Endereco endereco, Professor professor, Aluno aluno) {
    public DadosDetalhamentoAula(Aula aula) {
        this(aula.getId(), aula.getData(), aula.getObservacao(), aula.getEndereco(), aula.getProfessor(), aula.getAluno());

    }
}
