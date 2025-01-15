package com.deenedev.rh_gestao_vagas.modules.company.models.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.deenedev.rh_gestao_vagas.modules.jobs.model.Job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity()
public class Company {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    public UUID id;
    @NotNull()
    public String name;

    @Pattern(regexp = "[0-9]{14,14}", message = "O CNPJ deve estar no formato correto.")
    @NotNull()
    @Column(name = "cnpj")
    public String cnpj;
    
    @OneToMany()
    public List<Job> jobs;

    @Email(message = "O e-mail deve estar no formato correto.")
    public String email;

    @Length(min = 8, max = 100)
    public String password;

    @CreationTimestamp
    @Column(name = "created_at")
    public String createdAt;
}
