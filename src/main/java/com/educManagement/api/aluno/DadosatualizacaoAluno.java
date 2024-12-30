package com.educManagement.api.aluno;

import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosatualizacaoAluno(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
