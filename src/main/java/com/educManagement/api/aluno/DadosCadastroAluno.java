package com.educManagement.api.aluno;


import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
        @NotBlank
        String nome,

        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,

        @NotNull @Valid DadosEndereco endereco) {
}
