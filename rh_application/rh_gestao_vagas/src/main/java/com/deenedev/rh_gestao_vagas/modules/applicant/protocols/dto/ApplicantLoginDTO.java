package com.deenedev.rh_gestao_vagas.modules.applicant.protocols.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicantLoginDTO {
    @Email(message = "O e-mail deve estar no formato correto.")
    private String email;
    @Length(min = 10, max = 100, message = "A senha deve estar no formato correto.")
    private String password;
}
