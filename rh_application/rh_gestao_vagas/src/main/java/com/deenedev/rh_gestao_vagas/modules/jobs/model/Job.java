package com.deenedev.rh_gestao_vagas.modules.jobs.model;

import java.util.UUID;

import com.deenedev.rh_gestao_vagas.modules.jobs.controller.protocols.dto.CreateJobDTO;
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
public class Job {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @NotNull()
    @Length(min = 2, max = 100)
    private String level;

    @NotNull()
    @Length(min = 2, max = 255)
    private String name;

    @NotNull()
    @Length(min = 2, max = 100)
    private String role;

    @Length(min = 5, max = 255)
    private String description;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @CreationTimestamp
    @Column(name = "created_at")
    private String createdAt;


    public static CreateJobDTO convert(Job job) {
        CreateJobDTO newJob = new CreateJobDTO();
        newJob.setName(job.getName());
        newJob.setRole(job.getRole());
        newJob.setDescription(job.getDescription());
        newJob.setLevel(job.getLevel());
        return newJob;
    }
}
