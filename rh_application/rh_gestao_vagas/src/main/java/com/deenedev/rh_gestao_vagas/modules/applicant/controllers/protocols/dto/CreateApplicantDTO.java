package com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateApplicantDTO(
        @NotNull @Length(min = 5, max = 255) String name,
        @NotNull @Length(min = 11, max = 11) @Pattern(regexp = "[0-9]{11,11}", message = "O CPF deve estar no formato correto.") String cpf,
        @Email @NotNull String email,
        @NotNull String password,
        @Transient() @NotNull String confirmPassword,
        @Length(min = 2, max = 255) String curriculum,
        @Length(min = 2, max = 255) String description) {
}
