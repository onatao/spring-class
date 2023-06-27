package com.devnatao.rest.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 *  anotações do jakarta validation
 *  @NotBlank - o campo não poderá ser em branco
 *  @NotNull - o campo não poderá ser nulo
 */

public record ProductRecordDTO(@NotBlank String name, @NotNull BigDecimal value) {
}
