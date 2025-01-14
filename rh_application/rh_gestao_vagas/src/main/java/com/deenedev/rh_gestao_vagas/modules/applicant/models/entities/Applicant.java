package com.deenedev.rh_gestao_vagas.modules.applicant.models.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity()
public class Applicant {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    @NotNull()
    private String name;
    @Length(min = 11, max = 11)
    @Pattern(regexp = "[0-9]{11,11}", message = "O CPF deve estar no formato correto.")
    @NotNull()
    private String CPF;
    @Email(message = "O e-mail deve estar no formato correto.")
    private String email;
    @Length(min = 8, max = 100)
    private String password;
    private String curriculum;
    @Length(min = 2, max = 255)
    private String description;
    
    @CreationTimestamp
    private String created_at;
}
