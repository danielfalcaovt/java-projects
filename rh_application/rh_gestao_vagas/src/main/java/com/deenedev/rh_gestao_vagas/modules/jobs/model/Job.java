package com.deenedev.rh_gestao_vagas.modules.jobs.model;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.deenedev.rh_gestao_vagas.modules.company.models.entities.Company;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Entity()
@Builder
public class Job {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    public UUID id;

    @NotNull()
    @Length(min = 2, max = 100)
    public String level;

    @NotNull()
    @Length(min = 2, max = 255)
    public String name;

    @NotNull()
    @Length(min = 2, max = 100)
    public String role;

    @Length(min = 5, max = 255)
    public String description;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    public Company company;

    @Column(name = "company_id", nullable = false)
    public UUID companyId;

    @CreationTimestamp
    @Column(name = "created_at")
    public String createdAt;
}
