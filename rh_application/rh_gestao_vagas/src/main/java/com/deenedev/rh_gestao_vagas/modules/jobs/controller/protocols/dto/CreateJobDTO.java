package com.deenedev.rh_gestao_vagas.modules.jobs.controller.protocols.dto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateJobDTO {
@GeneratedValue(strategy = GenerationType.UUID)
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

    @CreationTimestamp
    @Column(name = "created_at")
    private String createdAt;
}
