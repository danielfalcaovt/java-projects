package com.deenedev.rh_gestao_vagas.modules.jobs.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deenedev.rh_gestao_vagas.modules.jobs.model.Job;

public interface JobRepository extends JpaRepository<Job, UUID> {}
