package com.educManagement.api.professor;

import com.educManagement.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String telefone;
    private String email;

    private String cpf;

    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Professor() {
    }

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoProfessor dados) {
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco()!= null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Especialidade getEspecialidade() {
        return this.especialidade;
    }

    public Long getID() {return this.id;}

    public String getTelefone() {return this.telefone;}

    public void excluir() {
        this.ativo=false;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public boolean getAtivo() {return this.ativo;}
}
