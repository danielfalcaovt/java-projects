package com.deenedev.rh_gestao_vagas.modules.applicant.controllers.protocols.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ApplicantLoginDTO(
        @Email @NotNull String email,
        @Length(min = 10, max = 100) String password) {
}