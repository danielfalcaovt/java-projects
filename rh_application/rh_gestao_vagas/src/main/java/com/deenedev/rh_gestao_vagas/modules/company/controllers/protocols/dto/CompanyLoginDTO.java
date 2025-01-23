package com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CompanyLoginDTO(
        @Email(message = "O e-mail deve estar no formato correto.") @NotNull() String email,
        @NotNull() @Length(min = 10, max = 100) String password) {
}
