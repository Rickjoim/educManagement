package com.educManagement.api.aula;

import com.educManagement.api.aluno.Aluno;
import com.educManagement.api.endereco.Endereco;
import com.educManagement.api.professor.Professor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "aula")
@Entity(name = "Aula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Embedded
    private Endereco endereco;

    private String observacao;

    private Boolean ativo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    public Aula(DadosCadastroAula dados, Professor professor, Aluno aluno) {
        this.ativo = true;
        this.data = dados.data();
        this.observacao = dados.observacao();
        this.endereco = new Endereco(dados.endereco());
        this.professor = professor;
        this.aluno = aluno;
    }

    public Long getId() {
        return this.id;
    }

    public Date getData() {return this.data;}

    public String getObservacao() {
        return this.observacao;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public boolean getAtivo() {return this.ativo;}
    public void atualizarInformacoes(DadosAtualizacaoAula dados) {

        if (dados.data() != null) {
            this.data = dados.data();
        }
        if (dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if(dados.endereco()!= null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }
    public void excluir() {
        this.ativo=false;
    }

}
