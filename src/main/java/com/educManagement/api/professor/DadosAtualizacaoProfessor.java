package com.educManagement.api.professor;

import com.educManagement.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
