package com.deenedev.rh_gestao_vagas.modules.company.models.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompanyLoginDTO {
    @Email(message = "O e-mail deve estar no formato correto.")
    @NotNull()
    private String email;
    @NotNull()
    @Length(min = 10, max = 100)
    private String password;
}
