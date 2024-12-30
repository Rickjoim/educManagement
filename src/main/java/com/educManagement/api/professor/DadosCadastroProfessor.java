package com.educManagement.api.professor;


import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,

        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{11,14}")
        String cpf,
        @NotNull
        Especialidade especialidade,

        @NotNull @Valid DadosEndereco endereco) {


}
