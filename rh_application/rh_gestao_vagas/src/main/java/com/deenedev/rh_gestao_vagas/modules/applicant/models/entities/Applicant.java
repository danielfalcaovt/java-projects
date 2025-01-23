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
    private String cpf;
    @NotNull()
    @Email(message = "O e-mail deve estar no formato correto.")
    private String email;
    @Length(min = 8, max = 100)
    @NotNull()
    private String password;
    private String curriculum;
    @Length(min = 2, max = 255)
    private String description;
    
    @CreationTimestamp
    private String created_at;

    public static Applicant build(String name,String cpf,String email,String password,String curriculum,String description) {
        Applicant applicant = new Applicant();
        applicant.setName(name);
        applicant.setCpf(cpf);
        applicant.setEmail(email);
        applicant.setPassword(password);
        applicant.setCurriculum(curriculum);
        applicant.setDescription(description);
        return applicant;
    }
}
