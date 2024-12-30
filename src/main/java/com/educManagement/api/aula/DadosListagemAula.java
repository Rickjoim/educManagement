package com.educManagement.api.aula;

import com.educManagement.api.aluno.DadosListagemAluno;
import com.educManagement.api.endereco.DadosEndereco;
import com.educManagement.api.professor.DadosListagemProfessor;

import java.util.Date;

public record DadosListagemAula(Long id, Date data, String observacao, DadosListagemProfessor professor, DadosListagemAluno aluno, DadosEndereco endereco) {
    public DadosListagemAula (Aula aula){
        this(aula.getId(), aula.getData(), aula.getObservacao(), new DadosListagemProfessor(aula.getProfessor()), new DadosListagemAluno(aula.getAluno()), new DadosEndereco(aula.getEndereco()));
    }

}
