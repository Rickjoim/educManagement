package com.educManagement.api.aula;

import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosCadastroAula(
        @NotNull
        Date data,

        @NotBlank
        String observacao,

        @NotNull @Valid
        DadosEndereco endereco,

        @NotNull
        Long professorId,

        @NotNull
        Long alunoId
) {

}
