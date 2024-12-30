package com.educManagement.api.aula;

import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizacaoAula(
        @NotNull Long id,
        Date data,
        String observacao,
        DadosEndereco endereco
) {
}
