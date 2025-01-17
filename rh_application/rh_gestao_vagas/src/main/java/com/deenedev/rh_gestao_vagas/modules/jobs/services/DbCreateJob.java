package com.deenedev.rh_gestao_vagas.modules.jobs.services;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deenedev.rh_gestao_vagas.modules.jobs.model.Job;
import com.deenedev.rh_gestao_vagas.modules.jobs.protocols.usecases.CreateJob;
import com.deenedev.rh_gestao_vagas.modules.jobs.repositories.JobRepository;

import jakarta.validation.ConstraintViolationException;

@Service
public class DbCreateJob implements CreateJob {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job create(Job job) throws ConstraintViolationException, IllegalArgumentException {
        // exceções throwing errado, não consigo descobrir quais são
        return this.jobRepository.save(job);
    }
}
