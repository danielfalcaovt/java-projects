package com.deenedev.rh_gestao_vagas.modules.company.controllers.protocols.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CompanySignUpDTO {
    @NotNull()
    private String name;

    @Pattern(regexp = "[0-9]{14,14}", message = "O CNPJ deve estar no formato correto.")
    @NotNull()
    @Column(name = "cnpj")
    private String cnpj;

    @Email(message = "O e-mail deve estar no formato correto.")
    @NotNull()
    private String email;

    @Length(min = 8, max = 100)
    @NotNull()
    private String password;
}
