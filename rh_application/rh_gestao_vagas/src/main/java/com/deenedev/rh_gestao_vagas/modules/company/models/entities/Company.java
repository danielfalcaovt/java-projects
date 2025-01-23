package com.deenedev.rh_gestao_vagas.modules.company.models.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.deenedev.rh_gestao_vagas.modules.applicant.models.entities.Applicant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity()
@Data
public class Company {
    
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    public UUID id;

    @CreationTimestamp
    @Column(name = "created_at")
    public String createdAt;

    @NotNull()
    public String name;

    @Pattern(regexp = "[0-9]{14,14}", message = "O CNPJ deve estar no formato correto.")
    @NotNull()
    @Column(name = "cnpj")
    public String cnpj;

    @Email(message = "O e-mail deve estar no formato correto.")
    @NotNull()
    public String email;

    @Length(min = 8, max = 100)
    @NotNull()
    public String password;

    
    public static Company build(String name,String cnpj, String email,String password) {
        Company company = new Company();
        company.setName(name);
        company.setCnpj(cnpj);
        company.setEmail(email);
        company.setPassword(password);
        return company;
    }
}
